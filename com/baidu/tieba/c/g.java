package com.baidu.tieba.c;

import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ad;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
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

    public void a(a aVar, int i) {
        int i2;
        int g = aVar.g();
        int i3 = 0;
        Iterator<a> it = c.iterator();
        while (true) {
            i2 = i3;
            if (!it.hasNext()) {
                break;
            }
            i3 = it.next().g() == g ? i2 + 1 : i2;
        }
        if (i2 >= i) {
            aVar.a(2);
            aVar.d(TiebaApplication.h().getString(R.string.download_fail_over_max));
            if (aVar.m() != null) {
                aVar.m().b(aVar);
                return;
            }
            return;
        }
        a(aVar);
    }

    public void a(a aVar) {
        if (aVar != null) {
            if (!ad.a()) {
                aVar.d(TiebaApplication.h().getString(R.string.download_fail_no_sd));
                aVar.a(2);
            }
            if (aVar.f() == 2) {
                if (aVar.m() != null) {
                    aVar.m().b(aVar);
                    return;
                }
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < c.size()) {
                    a aVar2 = c.get(i2);
                    if (aVar2 == null || !aVar2.d().equals(aVar.d()) || !aVar2.a().equals(aVar.a())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    aVar.a(1);
                    c.add(aVar);
                    e();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (b == null && !c.isEmpty()) {
            b = c.get(0);
            if (b != null) {
                com.baidu.adp.lib.g.e.d("download_file:start:" + b.d());
                this.d = new i(this);
                this.d.execute(b);
            }
        }
    }

    public void a(String str, int i) {
        if (b != null && b.a().equals(str) && b.g() == i) {
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
            if (next.a().equals(str) && next.g() == i) {
                next.a(4);
                next.d((String) null);
                if (next.m() != null) {
                    next.m().b(next);
                }
                linkedList.add(next);
            }
        }
        for (a aVar : linkedList) {
            c.remove(aVar);
        }
    }

    public void a(int i) {
        if (b != null && b.g() == i) {
            this.d.cancel(true);
        }
        LinkedList<a> linkedList = new LinkedList();
        for (a aVar : c) {
            if (aVar.g() == i) {
                aVar.a(4);
                aVar.d((String) null);
                if (aVar.m() != null) {
                    aVar.m().b(aVar);
                }
                linkedList.add(aVar);
            }
        }
        for (a aVar2 : linkedList) {
            c.remove(aVar2);
        }
    }

    public List<a> b() {
        return c;
    }
}
