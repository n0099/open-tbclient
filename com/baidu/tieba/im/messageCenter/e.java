package com.baidu.tieba.im.messageCenter;

import android.util.SparseArray;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.cc;
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
    private SparseArray<Class<? extends cc>> d;
    private SparseArray<LinkedList<WeakReference<g>>> e;
    private com.baidu.tieba.im.a<cc> f;
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

    public void a(com.baidu.tieba.im.message.o oVar, int i, int i2, boolean z) {
        this.g.a(oVar, true, i, false, i2, z);
    }

    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null) {
            Class<? extends d> cls = this.b.get(oVar.u());
            if (cls == null) {
                this.g.a(oVar, true, 0, false, 0, true);
                return;
            }
            try {
                d newInstance = cls.newInstance();
                newInstance.b(oVar);
                com.baidu.tieba.im.m.a(newInstance, this.f);
            } catch (Exception e) {
                a(oVar, com.baidu.tieba.im.k.v, TiebaApplication.g().getString(R.string.error_unkown));
            }
        }
    }

    public void b(boolean z) {
        this.g.b(z);
    }

    public void a(com.baidu.tieba.im.net.a aVar) {
        this.g.a(aVar);
    }

    public void b(com.baidu.tieba.im.message.o oVar) {
        this.g.b(oVar);
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

    public void c(int i, Class<? extends cc> cls) {
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

    private cc b(com.baidu.tieba.im.message.o oVar, int i, String str) {
        if (oVar == null) {
            return null;
        }
        cc ccVar = new cc(oVar.u());
        ccVar.a(oVar);
        ccVar.g(i);
        ccVar.c(str);
        return ccVar;
    }

    public boolean c(com.baidu.tieba.im.message.o oVar) {
        return this.g.a(oVar);
    }

    public boolean b(int i) {
        return this.g.a(i);
    }

    public void d(com.baidu.tieba.im.message.o oVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(oVar);
        a(linkedList);
    }

    public void e(com.baidu.tieba.im.message.o oVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(oVar);
        a(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<com.baidu.tieba.im.message.o> list) {
        LinkedList<WeakReference<g>> linkedList;
        if (list != null) {
            for (com.baidu.tieba.im.message.o oVar : list) {
                if (oVar != null && (linkedList = this.e.get(oVar.u())) != null && !linkedList.isEmpty()) {
                    Iterator<WeakReference<g>> it = linkedList.iterator();
                    while (it.hasNext()) {
                        g gVar = it.next().get();
                        if (gVar != null) {
                            gVar.a(oVar);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.im.message.o oVar, int i, String str) {
        cc b;
        if (oVar != null) {
            Class<? extends cc> cls = this.d.get(oVar.u());
            if (cls == null) {
                b = b(oVar, i, str);
            } else {
                try {
                    b = cls.newInstance();
                    b.e(oVar.u());
                    b.g(i);
                    b.c(str);
                    b.a(oVar);
                    if (i > 0 && TiebaApplication.g().s()) {
                        StatService.onEvent(TiebaApplication.g().getApplicationContext(), "send_msg_fail_time", "send_fail", 1);
                    }
                } catch (Exception e) {
                    b = b(oVar, com.baidu.tieba.im.k.v, TiebaApplication.g().getString(R.string.error_unkown));
                }
            }
            e(b);
        }
    }
}
