package com.baidu.tieba.download;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.a.k;
import com.baidu.tieba.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class c {
    private static c a = new c();
    private static a b = null;
    private static List<a> c = new LinkedList();
    private e d = null;
    private int e = 20;
    @SuppressLint({"HandlerLeak"})
    private Handler f = new d(this);

    private c() {
    }

    public static c a() {
        return a;
    }

    public final void a(a aVar, int i) {
        int g = aVar.g();
        int i2 = 0;
        for (a aVar2 : c) {
            if (aVar2.g() == g) {
                i2++;
            }
        }
        if (i2 >= i) {
            aVar.a(2);
            p.c();
            aVar.e(p.d().getString(k.download_fail_over_max));
            if (aVar.m() != null) {
                aVar.m().a(aVar);
            }
        } else if (aVar != null) {
            if (!w.a()) {
                p.c();
                aVar.e(p.d().getString(k.download_fail_no_sd));
                aVar.a(2);
            }
            if (aVar.f() == 2) {
                if (aVar.m() != null) {
                    aVar.m().a(aVar);
                    return;
                }
                return;
            }
            for (int i3 = 0; i3 < c.size(); i3++) {
                a aVar3 = c.get(i3);
                if (aVar3 != null && aVar3.d().equals(aVar.d()) && aVar3.a().equals(aVar.a())) {
                    return;
                }
            }
            aVar.a(1);
            c.add(aVar);
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (b == null && !c.isEmpty()) {
            a aVar = c.get(0);
            b = aVar;
            if (aVar != null) {
                f.e("download_file:start:" + b.d());
                this.d = new e(this);
                this.d.execute(b);
            }
        }
    }

    public final void a(String str, int i) {
        if (b != null && b.a().equals(str) && b.g() == 11) {
            this.d.cancel(true);
            return;
        }
        LinkedList<a> linkedList = new LinkedList();
        Iterator<a> it = c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next.a().equals(str) && next.g() == 11) {
                next.a(4);
                next.e((String) null);
                if (next.m() != null) {
                    next.m().a(next);
                }
                linkedList.add(next);
            }
        }
        for (a aVar : linkedList) {
            c.remove(aVar);
        }
    }

    public final void a(int i) {
        if (b != null && b.g() == 11) {
            this.d.cancel(true);
        }
        LinkedList<a> linkedList = new LinkedList();
        for (a aVar : c) {
            if (aVar.g() == 11) {
                aVar.a(4);
                aVar.e((String) null);
                if (aVar.m() != null) {
                    aVar.m().a(aVar);
                }
                linkedList.add(aVar);
            }
        }
        for (a aVar2 : linkedList) {
            c.remove(aVar2);
        }
    }

    public static List<a> b() {
        return c;
    }
}
