package com.baidu.tieba.im.messageCenter;

import android.util.SparseArray;
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
public class e {
    private static e a = null;
    private SparseArray<Class<? extends d>> b;
    private SparseArray<Class<? extends a>> c;
    private SparseArray<Class<? extends da>> d;
    private SparseArray<LinkedList<WeakReference<g>>> e;
    private com.baidu.tieba.im.a<da> f;
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

    public void a(s sVar, int i, int i2, boolean z) {
        this.g.a(sVar, true, i, false, i2, z);
    }

    public void a(s sVar) {
        if (sVar != null) {
            Class<? extends d> cls = this.b.get(sVar.w());
            if (cls == null) {
                this.g.a(sVar, true, 0, false, 0, true);
                return;
            }
            try {
                d newInstance = cls.newInstance();
                newInstance.b(sVar);
                com.baidu.tieba.im.j.a(newInstance, this.f);
            } catch (Exception e) {
                a(sVar, com.baidu.tieba.im.h.v, TiebaApplication.g().b().getString(R.string.error_unkown));
            }
        }
    }

    public void b(boolean z) {
        this.g.b(z);
    }

    public void a(com.baidu.tieba.im.net.a aVar) {
        this.g.a(aVar);
    }

    public void b(s sVar) {
        this.g.b(sVar);
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
                com.baidu.adp.lib.util.f.b(e.getMessage());
            }
        }
        return null;
    }

    public void b(int i, Class<? extends a> cls) {
        this.c.put(i, cls);
    }

    public void c(int i, Class<? extends da> cls) {
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

    private da b(s sVar, int i, String str) {
        if (sVar == null) {
            return null;
        }
        da daVar = new da(sVar.w());
        daVar.a(sVar);
        daVar.g(i);
        daVar.c(str);
        return daVar;
    }

    public boolean c(s sVar) {
        return this.g.a(sVar);
    }

    public boolean b(int i) {
        return this.g.a(i);
    }

    public void d(s sVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(sVar);
        a(linkedList);
    }

    public void e(s sVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(sVar);
        a(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<s> list) {
        if (list != null) {
            for (s sVar : list) {
                if (sVar != null) {
                    if (sVar instanceof da) {
                        da daVar = (da) sVar;
                        if (daVar.m() != 0) {
                            cb.a("dispatchMessage", daVar.w(), daVar.v(), daVar.n(), daVar.m());
                        }
                    }
                    LinkedList<WeakReference<g>> linkedList = this.e.get(sVar.w());
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
    public void a(s sVar, int i, String str) {
        da b;
        if (sVar != null) {
            Class<? extends da> cls = this.d.get(sVar.w());
            if (cls == null) {
                b = b(sVar, i, str);
            } else {
                try {
                    b = cls.newInstance();
                    b.e(sVar.w());
                    b.g(i);
                    b.c(str);
                    b.a(sVar);
                    if (i > 0) {
                        cb.a(TiebaApplication.g().b().getApplicationContext(), "send_msg_fail_time", "send_fail", 1, new Object[0]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    b = b(sVar, com.baidu.tieba.im.h.v, TiebaApplication.g().b().getString(R.string.error_unkown));
                }
            }
            e(b);
        }
    }
}
