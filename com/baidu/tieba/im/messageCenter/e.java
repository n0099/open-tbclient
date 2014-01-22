package com.baidu.tieba.im.messageCenter;

import android.util.SparseArray;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.cr;
import com.baidu.tieba.util.by;
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
    private SparseArray<Class<? extends cr>> d;
    private SparseArray<LinkedList<WeakReference<g>>> e;
    private com.baidu.tieba.im.a<cr> f;
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
        synchronized (e.class) {
            if (a == null) {
                a = new e();
            }
        }
        return a;
    }

    public void a(com.baidu.tieba.im.message.q qVar, int i, int i2, boolean z) {
        this.g.a(qVar, true, i, false, i2, z);
    }

    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null) {
            Class<? extends d> cls = this.b.get(qVar.w());
            if (cls == null) {
                this.g.a(qVar, true, 0, false, 0, true);
                return;
            }
            try {
                d newInstance = cls.newInstance();
                newInstance.b(qVar);
                com.baidu.tieba.im.m.a(newInstance, this.f);
            } catch (Exception e) {
                a(qVar, com.baidu.tieba.im.k.v, TiebaApplication.h().getString(R.string.error_unkown));
            }
        }
    }

    public void b(boolean z) {
        this.g.b(z);
    }

    public void a(com.baidu.tieba.im.net.a aVar) {
        this.g.a(aVar);
    }

    public void b(com.baidu.tieba.im.message.q qVar) {
        this.g.b(qVar);
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
                com.baidu.adp.lib.g.e.a(e.getMessage());
            }
        }
        return null;
    }

    public void b(int i, Class<? extends a> cls) {
        this.c.put(i, cls);
    }

    public void c(int i, Class<? extends cr> cls) {
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

    private cr b(com.baidu.tieba.im.message.q qVar, int i, String str) {
        if (qVar == null) {
            return null;
        }
        cr crVar = new cr(qVar.w());
        crVar.a(qVar);
        crVar.g(i);
        crVar.c(str);
        return crVar;
    }

    public boolean c(com.baidu.tieba.im.message.q qVar) {
        return this.g.a(qVar);
    }

    public boolean b(int i) {
        return this.g.a(i);
    }

    public void d(com.baidu.tieba.im.message.q qVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(qVar);
        a(linkedList);
    }

    public void e(com.baidu.tieba.im.message.q qVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(qVar);
        a(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<com.baidu.tieba.im.message.q> list) {
        if (list != null) {
            for (com.baidu.tieba.im.message.q qVar : list) {
                if (qVar != null) {
                    if (qVar instanceof cr) {
                        cr crVar = (cr) qVar;
                        if (crVar.l() != 0) {
                            by.a("dispatchMessage", crVar.w(), crVar.v(), crVar.m(), crVar.l());
                        }
                    }
                    LinkedList<WeakReference<g>> linkedList = this.e.get(qVar.w());
                    if (linkedList != null && !linkedList.isEmpty()) {
                        Iterator<WeakReference<g>> it = linkedList.iterator();
                        while (it.hasNext()) {
                            g gVar = it.next().get();
                            if (gVar != null) {
                                gVar.a(qVar);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.im.message.q qVar, int i, String str) {
        cr b;
        if (qVar != null) {
            Class<? extends cr> cls = this.d.get(qVar.w());
            if (cls == null) {
                b = b(qVar, i, str);
            } else {
                try {
                    b = cls.newInstance();
                    b.e(qVar.w());
                    b.g(i);
                    b.c(str);
                    b.a(qVar);
                    if (i > 0) {
                        by.a(TiebaApplication.h().getApplicationContext(), "send_msg_fail_time", "send_fail", 1, new Object[0]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    b = b(qVar, com.baidu.tieba.im.k.v, TiebaApplication.h().getString(R.string.error_unkown));
                }
            }
            e(b);
        }
    }
}
