package com.baidu.tbadk.mutiprocess;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static g eqk = null;
    private d eqn;
    private boolean aSa = false;
    private final c eqg = new c() { // from class: com.baidu.tbadk.mutiprocess.g.1
        @Override // com.baidu.tbadk.mutiprocess.c
        public void b(a aVar) {
            g.this.d(aVar);
        }
    };
    private Handler mUIHandler = new Handler(Looper.getMainLooper());
    private final com.baidu.tbadk.h.e eqo = new com.baidu.tbadk.h.e() { // from class: com.baidu.tbadk.mutiprocess.g.3
        @Override // com.baidu.tbadk.h.e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof TbPageContextSupport) {
                g.this.m(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    };
    private final Map<Class<? extends a>, b> eql = new HashMap();
    private final Map<Class<? extends a>, LinkedList<h>> eqm = new HashMap();

    private g() {
    }

    public static void publishEvent(a aVar) {
        int myPid = Process.myPid();
        int pid = aVar.getPid();
        if (aVar.getType() == 2 && myPid == pid) {
            beJ().d(aVar);
        } else {
            beJ().f(aVar);
        }
    }

    public static g beJ() {
        if (eqk == null) {
            synchronized (g.class) {
                if (eqk == null) {
                    eqk = new g();
                }
            }
        }
        return eqk;
    }

    public void init(Application application) {
        if (!this.aSa) {
            if (application == null) {
                throw new NullPointerException("MutiProcessManager Initialized, application is null");
            }
            e(application);
            this.eqn = new e(application);
            this.eqn.a(this.eqg);
            this.eqn.startService();
            this.aSa = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final a aVar) {
        if (l.isMainThread()) {
            e(aVar);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.tbadk.mutiprocess.g.2
                @Override // java.lang.Runnable
                public void run() {
                    g.this.e(aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(a aVar) {
        if (aVar != null) {
            Class<?> cls = aVar.getClass();
            try {
                b bVar = this.eql.get(cls);
                if (bVar != null) {
                    bVar.a(aVar);
                }
            } catch (Exception e) {
                BdLog.detailException(cls.getName(), e);
            }
            try {
                LinkedList<h> linkedList = this.eqm.get(cls);
                if (!v.isEmpty(linkedList)) {
                    int myPid = Process.myPid();
                    for (h hVar : linkedList) {
                        if (hVar != null && (!hVar.isSelfListener() || (aVar.getPid() == myPid && hVar.getTag() != null && hVar.getTag().getId() == aVar.getTag()))) {
                            try {
                                hVar.a(aVar);
                            } catch (Exception e2) {
                                BdLog.detailException(cls.getName(), e2);
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                BdLog.detailException(cls.getName(), e3);
            }
        }
    }

    private void f(a aVar) {
        if (this.eqn != null) {
            this.eqn.publishEvent(aVar);
        }
    }

    public void a(Class<? extends a> cls, b bVar) {
        if (bVar == null) {
            throw new NullPointerException("register listener is null");
        }
        if (cls == null) {
            throw new NullPointerException("register IEvent class is null");
        }
        if (this.eql.containsKey(cls)) {
            BdLog.e(cls + " has existed, Please unRegister old listener first！");
        } else {
            this.eql.put(cls, bVar);
        }
    }

    public void a(Class<? extends a> cls, h hVar, BdUniqueId bdUniqueId) {
        if (hVar == null) {
            throw new NullPointerException("register listener is null");
        }
        if (cls == null) {
            throw new NullPointerException("register IEvent class is null");
        }
        LinkedList<h> linkedList = this.eqm.get(cls);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.eqm.put(cls, linkedList);
        }
        if (linkedList.contains(hVar)) {
            BdLog.e("listener has existed, Please unRegister old listener first！");
            return;
        }
        hVar.setTag(bdUniqueId);
        FrameHelper.a(linkedList, hVar);
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            for (Map.Entry<Class<? extends a>, LinkedList<h>> entry : this.eqm.entrySet()) {
                LinkedList<h> value = entry.getValue();
                if (!v.isEmpty(value)) {
                    Iterator<h> it = value.iterator();
                    while (it.hasNext()) {
                        h next = it.next();
                        if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    private void e(Application application) {
        try {
            application.registerActivityLifecycleCallbacks(this.eqo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
