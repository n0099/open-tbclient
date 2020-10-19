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
import com.baidu.tbadk.core.util.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static g feZ = null;
    private d ffc;
    private boolean bhy = false;
    private final c feV = new c() { // from class: com.baidu.tbadk.mutiprocess.g.1
        @Override // com.baidu.tbadk.mutiprocess.c
        public void b(a aVar) {
            g.this.d(aVar);
        }
    };
    private Handler mUIHandler = new Handler(Looper.getMainLooper());
    private final com.baidu.tbadk.h.g ffd = new com.baidu.tbadk.h.g() { // from class: com.baidu.tbadk.mutiprocess.g.3
        @Override // com.baidu.tbadk.h.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof TbPageContextSupport) {
                g.this.m(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    };
    private final Map<Class<? extends a>, b> ffa = new HashMap();
    private final Map<Class<? extends a>, LinkedList<h>> ffb = new HashMap();

    private g() {
    }

    public static void publishEvent(a aVar) {
        int myPid = Process.myPid();
        int pid = aVar.getPid();
        if (aVar.getType() == 2 && myPid == pid) {
            bxb().d(aVar);
        } else {
            bxb().f(aVar);
        }
    }

    public static g bxb() {
        if (feZ == null) {
            synchronized (g.class) {
                if (feZ == null) {
                    feZ = new g();
                }
            }
        }
        return feZ;
    }

    public void init(Application application) {
        if (!this.bhy) {
            if (application == null) {
                throw new NullPointerException("MutiProcessManager Initialized, application is null");
            }
            f(application);
            this.ffc = new e(application);
            this.ffc.a(this.feV);
            this.ffc.startService();
            this.bhy = true;
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
                b bVar = this.ffa.get(cls);
                if (bVar != null) {
                    bVar.a(aVar);
                }
            } catch (Exception e) {
                BdLog.detailException(cls.getName(), e);
            }
            try {
                LinkedList<h> linkedList = this.ffb.get(cls);
                if (!y.isEmpty(linkedList)) {
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
        if (this.ffc != null) {
            this.ffc.publishEvent(aVar);
        }
    }

    public void a(Class<? extends a> cls, b bVar) {
        if (bVar == null) {
            throw new NullPointerException("register listener is null");
        }
        if (cls == null) {
            throw new NullPointerException("register IEvent class is null");
        }
        if (this.ffa.containsKey(cls)) {
            BdLog.e(cls + " has existed, Please unRegister old listener first！");
        } else {
            this.ffa.put(cls, bVar);
        }
    }

    public void a(Class<? extends a> cls, h hVar, BdUniqueId bdUniqueId) {
        if (hVar == null) {
            throw new NullPointerException("register listener is null");
        }
        if (cls == null) {
            throw new NullPointerException("register IEvent class is null");
        }
        LinkedList<h> linkedList = this.ffb.get(cls);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.ffb.put(cls, linkedList);
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
            for (Map.Entry<Class<? extends a>, LinkedList<h>> entry : this.ffb.entrySet()) {
                LinkedList<h> value = entry.getValue();
                if (!y.isEmpty(value)) {
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

    private void f(Application application) {
        try {
            application.registerActivityLifecycleCallbacks(this.ffd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
