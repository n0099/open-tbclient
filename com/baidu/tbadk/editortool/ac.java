package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.baidu.tbadk.core.util.UtilHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class ac {
    private static ac a = new ac();
    private ArrayList<ag> b = new ArrayList<>();
    private List<e> c = new ArrayList();

    public static ac a() {
        return a;
    }

    private ac() {
    }

    public final void a(e eVar) {
        if (!this.c.contains(eVar)) {
            this.c.add(eVar);
            Collections.sort(this.c);
        }
    }

    public final void b() {
        com.baidu.adp.lib.f.d.a();
        com.baidu.adp.lib.f.d.a(new ad(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void c() {
        ArrayList arrayList = new ArrayList();
        ae aeVar = new ae(this, arrayList);
        for (e eVar : this.c) {
            eVar.a(aeVar);
        }
        new Handler(Looper.getMainLooper()).post(new af(this, arrayList));
    }

    public final boolean a(String str) {
        Iterator<ag> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().a(str)) {
                return true;
            }
        }
        return false;
    }

    public static com.baidu.adp.widget.ImageView.b b(String str) {
        return com.baidu.tbadk.imageManager.e.a().c(str);
    }

    public static String a(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public final com.baidu.adp.widget.ImageView.b a(String str, String str2) {
        com.baidu.adp.widget.ImageView.b bVar;
        Bitmap c;
        com.baidu.adp.widget.ImageView.b c2 = com.baidu.tbadk.imageManager.e.a().c(str2);
        if (c2 != null) {
            return c2;
        }
        Iterator<ag> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = c2;
                break;
            }
            ag next = it.next();
            if (next.a(str2)) {
                bVar = next.b(str2);
                break;
            }
        }
        if (bVar == null && str != null && (c = c(str, a(str2, false))) != null) {
            bVar = new com.baidu.adp.widget.ImageView.b(c, false, str2);
        }
        a(str2, bVar, false);
        return bVar;
    }

    public final com.baidu.adp.widget.ImageView.b b(String str, String str2) {
        com.baidu.adp.widget.ImageView.b bVar;
        if (aa.c().e()) {
            return null;
        }
        com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(b(str2, true));
        if (c != null) {
            return c;
        }
        Iterator<ag> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = c;
                break;
            }
            ag next = it.next();
            if (next.a(str2)) {
                bVar = next.c(str2);
                break;
            }
        }
        if (bVar == null && str != null) {
            bVar = d(str, a(str2, true));
        }
        a(str2, bVar, true);
        return bVar;
    }

    public static String b(String str, boolean z) {
        if (!aa.c().e()) {
            List<ag> d = aa.c().d();
            if (z) {
                for (ag agVar : d) {
                    if (agVar.a(str)) {
                        return str;
                    }
                }
                return "#@" + str;
            }
            return str;
        }
        return str;
    }

    public final void a(String str, com.baidu.adp.widget.ImageView.b bVar, boolean z) {
        if (bVar != null) {
            if (z) {
                com.baidu.tbadk.imageManager.e.a().c(b(str, z), bVar);
                return;
            }
            com.baidu.tbadk.imageManager.e.a().c(str, bVar);
        }
    }

    public final ArrayList<ag> d() {
        return this.b;
    }

    public final ag c(String str) {
        Iterator<ag> it = this.b.iterator();
        while (it.hasNext()) {
            ag next = it.next();
            if (next.e().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static Bitmap c(String str, String str2) {
        return com.baidu.tbadk.core.util.w.c(".emotions/" + str, str2);
    }

    public final com.baidu.adp.widget.ImageView.b d(String str, String str2) {
        File file = new File(com.baidu.tbadk.core.util.w.a + "/" + com.baidu.tbadk.core.data.n.f() + "/.emotions/" + str + "/", str2);
        if (file.exists()) {
            if (!UtilHelper.a(1024)) {
                Bitmap c = c(str, str2);
                if (c != null) {
                    return new com.baidu.adp.widget.ImageView.b(c, false, str2);
                }
                return null;
            }
            return com.baidu.adp.gif.b.a().a(file.getAbsolutePath());
        }
        return null;
    }
}
