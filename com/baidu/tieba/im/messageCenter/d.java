package com.baidu.tieba.im.messageCenter;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d b = null;
    Handler a = new Handler(Looper.getMainLooper());
    private SparseArray<Class<? extends c>> c;
    private SparseArray<Class<? extends a>> d;
    private SparseArray<Class<? extends da>> e;
    private SparseArray<LinkedList<WeakReference<g>>> f;
    private com.baidu.tieba.im.a<da> g;
    private i h;

    public final void a(boolean z) {
        this.h.a(z);
    }

    private d() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.e = new SparseArray<>();
        this.c = new SparseArray<>();
        this.d = new SparseArray<>();
        this.f = new SparseArray<>();
        this.g = new e(this);
        this.h = new i(this);
    }

    public static d a() {
        synchronized (d.class) {
            if (b == null) {
                b = new d();
            }
        }
        return b;
    }

    public final void a(s sVar, int i, int i2, boolean z) {
        this.h.a(sVar, true, -3, false, 0, false);
    }

    public final void a(s sVar) {
        if (sVar != null) {
            Class<? extends c> cls = this.c.get(sVar.w());
            if (cls == null) {
                this.h.a(sVar, true, 0, false, 0, true);
                return;
            }
            try {
                c newInstance = cls.newInstance();
                newInstance.b(sVar);
                com.baidu.tieba.im.i.a(newInstance, this.g);
            } catch (Exception e) {
                a(sVar, com.baidu.tieba.im.g.v, TiebaApplication.g().b().getString(R.string.error_unkown));
            }
        }
    }

    public final void b(boolean z) {
        this.h.b(false);
    }

    public final void a(com.baidu.tieba.im.net.a aVar) {
        this.h.a(aVar);
    }

    public final void b(s sVar) {
        this.h.b(sVar);
    }

    public final void a(int i, Class<? extends c> cls) {
        this.c.put(i, cls);
    }

    public final a a(int i) {
        Class<? extends a> cls = this.d.get(i);
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(e.getMessage());
            }
        }
        return null;
    }

    public final void b(int i, Class<? extends a> cls) {
        this.d.put(i, cls);
    }

    public final void c(int i, Class<? extends da> cls) {
        this.e.put(i, cls);
    }

    public final void a(int i, g gVar) {
        if (gVar != null) {
            LinkedList<WeakReference<g>> linkedList = this.f.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.f.put(i, linkedList);
            }
            linkedList.add(new WeakReference<>(gVar));
        }
    }

    public final void a(g gVar) {
        if (gVar != null) {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                LinkedList<WeakReference<g>> valueAt = this.f.valueAt(i);
                Iterator<WeakReference<g>> it = valueAt.iterator();
                while (true) {
                    if (it.hasNext()) {
                        WeakReference<g> next = it.next();
                        g gVar2 = next.get();
                        if (gVar2 != null && gVar2.equals(gVar)) {
                            valueAt.remove(next);
                            break;
                        }
                    }
                }
            }
        }
    }

    private static da b(s sVar, int i, String str) {
        if (sVar == null) {
            return null;
        }
        da daVar = new da(sVar.w());
        daVar.a(sVar);
        daVar.g(i);
        daVar.c(str);
        return daVar;
    }

    public final boolean c(s sVar) {
        return this.h.a(sVar);
    }

    public final boolean b(int i) {
        return this.h.a(202003);
    }

    public final void d(s sVar) {
        if (BdUtilHelper.c()) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(sVar);
            a(linkedList);
            return;
        }
        this.a.post(new f(this, sVar));
    }

    public final void e(s sVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(sVar);
        a(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(List<s> list) {
        if (list != null) {
            for (s sVar : list) {
                if (sVar != null) {
                    if (sVar instanceof da) {
                        da daVar = (da) sVar;
                        if (daVar.m() != 0) {
                            cb.a("dispatchMessage", daVar.w(), daVar.v(), daVar.n(), daVar.m());
                        }
                    }
                    LinkedList<WeakReference<g>> linkedList = this.f.get(sVar.w());
                    if (linkedList != null && !linkedList.isEmpty()) {
                        Iterator<WeakReference<g>> it = linkedList.iterator();
                        while (it.hasNext()) {
                            g gVar = it.next().get();
                            if (gVar != null) {
                                gVar.a(sVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(s sVar, int i, String str) {
        da b2;
        if (sVar != null) {
            Class<? extends da> cls = this.e.get(sVar.w());
            if (cls == null) {
                b2 = b(sVar, i, str);
            } else {
                try {
                    b2 = cls.newInstance();
                    b2.e(sVar.w());
                    b2.g(i);
                    b2.c(str);
                    b2.a(sVar);
                    if (i > 0) {
                        cb.a(TiebaApplication.g().b().getApplicationContext(), "send_msg_fail_time", "send_fail", 1, new Object[0]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    b2 = b(sVar, com.baidu.tieba.im.g.v, TiebaApplication.g().b().getString(R.string.error_unkown));
                }
            }
            e(b2);
        }
    }
}
