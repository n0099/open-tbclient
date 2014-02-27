package com.baidu.tieba.d;

import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.af;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class g {
    private static g a = new g();
    private static a b = null;
    private static List<a> c = new LinkedList();
    private i d = null;
    private int e = 20;
    private Handler f = new h(this);

    private g() {
    }

    public static g a() {
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
            aVar.e(TiebaApplication.g().b().getString(R.string.download_fail_over_max));
            if (aVar.m() != null) {
                aVar.m().c(aVar);
            }
        } else if (aVar != null) {
            if (!af.a()) {
                aVar.e(TiebaApplication.g().b().getString(R.string.download_fail_no_sd));
                aVar.a(2);
            }
            if (aVar.f() == 2) {
                if (aVar.m() != null) {
                    aVar.m().c(aVar);
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
                com.baidu.adp.lib.util.e.e("download_file:start:" + b.d());
                this.d = new i(this);
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
                    next.m().c(next);
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
                    aVar.m().c(aVar);
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
