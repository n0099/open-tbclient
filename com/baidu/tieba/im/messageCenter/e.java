package com.baidu.tieba.im.messageCenter;

import android.util.SparseArray;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bz;
import com.slidingmenu.lib.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e a = null;
    private SparseArray<Class<? extends d>> b;
    private SparseArray<Class<? extends a>> c;
    private SparseArray<Class<? extends bz>> d;
    private SparseArray<LinkedList<WeakReference<g>>> e;
    private com.baidu.tieba.im.a<bz> f;
    private i g;

    public void a(boolean z) {
        this.g.a(z);
    }

    private e() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.d = new SparseArray<>();
        this.b = new SparseArray<>();
        this.c = new SparseArray<>();
        this.e = new SparseArray<>();
        this.f = new f(this);
        this.g = new i(this);
    }

    public static e a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    public void a(com.baidu.tieba.im.message.n nVar, int i, int i2, boolean z) {
        this.g.a(nVar, true, i, false, i2, z);
    }

    public void a(com.baidu.tieba.im.message.n nVar) {
        if (nVar != null) {
            Class<? extends d> cls = this.b.get(nVar.t());
            if (cls == null) {
                this.g.a(nVar, true, 0, false, 0, true);
                return;
            }
            try {
                d newInstance = cls.newInstance();
                newInstance.b(nVar);
                com.baidu.tieba.im.m.a(newInstance, this.f);
            } catch (Exception e) {
                a(nVar, com.baidu.tieba.im.k.v, TiebaApplication.h().getString(R.string.error_unkown));
            }
        }
    }

    public void b(boolean z) {
        this.g.b(z);
    }

    public void a(com.baidu.tieba.im.net.a aVar) {
        this.g.a(aVar);
    }

    public void b(com.baidu.tieba.im.message.n nVar) {
        this.g.b(nVar);
    }

    public void a(int i, Class<? extends d> cls) {
        this.b.put(i, cls);
    }

    public a a(int i) {
        Class<? extends a> cls = this.c.get(i);
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                com.baidu.adp.lib.h.e.a(e.getMessage());
            }
        }
        return null;
    }

    public void b(int i, Class<? extends a> cls) {
        this.c.put(i, cls);
    }

    public void c(int i, Class<? extends bz> cls) {
        this.d.put(i, cls);
    }

    public void a(int i, g gVar) {
        if (gVar != null) {
            LinkedList<WeakReference<g>> linkedList = this.e.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.e.put(i, linkedList);
            }
            linkedList.add(new WeakReference<>(gVar));
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                LinkedList<WeakReference<g>> valueAt = this.e.valueAt(i);
                Iterator<WeakReference<g>> it = valueAt.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
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

    private bz b(com.baidu.tieba.im.message.n nVar, int i, String str) {
        if (nVar == null) {
            return null;
        }
        bz bzVar = new bz(nVar.t());
        bzVar.a(nVar);
        bzVar.c(i);
        bzVar.c(str);
        return bzVar;
    }

    public boolean c(com.baidu.tieba.im.message.n nVar) {
        return this.g.a(nVar);
    }

    public boolean b(int i) {
        return this.g.a(i);
    }

    public void d(com.baidu.tieba.im.message.n nVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(nVar);
        a(linkedList);
    }

    public void e(com.baidu.tieba.im.message.n nVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(nVar);
        a(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<com.baidu.tieba.im.message.n> list) {
        LinkedList<WeakReference<g>> linkedList;
        if (list != null) {
            for (com.baidu.tieba.im.message.n nVar : list) {
                if (nVar != null && (linkedList = this.e.get(nVar.t())) != null && !linkedList.isEmpty()) {
                    Iterator<WeakReference<g>> it = linkedList.iterator();
                    while (it.hasNext()) {
                        g gVar = it.next().get();
                        if (gVar != null) {
                            gVar.a(nVar);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.im.message.n nVar, int i, String str) {
        bz b;
        if (nVar != null) {
            Class<? extends bz> cls = this.d.get(nVar.t());
            if (cls == null) {
                b = b(nVar, i, str);
            } else {
                try {
                    b = cls.newInstance();
                    b.e(nVar.t());
                    b.c(i);
                    b.c(str);
                    b.a(nVar);
                    if (i > 0 && TiebaApplication.h().t()) {
                        StatService.onEvent(TiebaApplication.h().getApplicationContext(), "send_msg_fail_time", "send_fail", 1);
                    }
                } catch (Exception e) {
                    b = b(nVar, com.baidu.tieba.im.k.v, TiebaApplication.h().getString(R.string.error_unkown));
                }
            }
            e(b);
        }
    }
}
