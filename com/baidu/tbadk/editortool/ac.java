package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ac {
    private static ac a = new ac();
    private ArrayList<ag> b = new ArrayList<>();
    private List<e> c = new ArrayList();

    public static ac a() {
        return a;
    }

    private ac() {
    }

    public void a(e eVar) {
        synchronized (this.c) {
            if (!this.c.contains(eVar)) {
                this.c.add(eVar);
                Collections.sort(this.c);
            }
        }
    }

    public void b() {
        com.baidu.adp.lib.f.d.a().a(new ad(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void c() {
        ArrayList arrayList = new ArrayList();
        ae aeVar = new ae(this, arrayList);
        synchronized (this.c) {
            for (int i = 0; i < this.c.size(); i++) {
                this.c.get(i).a(aeVar);
            }
        }
        new Handler(Looper.getMainLooper()).post(new af(this, arrayList));
    }

    public boolean a(String str) {
        Iterator<ag> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().a(str)) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.adp.widget.a.a b(String str) {
        return com.baidu.tbadk.imageManager.e.a().c(str);
    }

    public com.baidu.adp.widget.a.a c(String str) {
        return com.baidu.tbadk.imageManager.e.a().c(b(str, true));
    }

    public String a(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public com.baidu.adp.widget.a.a a(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        Bitmap c;
        com.baidu.adp.widget.a.a c2 = com.baidu.tbadk.imageManager.e.a().c(str2);
        if (c2 != null) {
            return c2;
        }
        Iterator<ag> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = c2;
                break;
            }
            ag next = it.next();
            if (next.a(str2)) {
                aVar = next.b(str2);
                break;
            }
        }
        if (aVar == null && str != null && (c = c(str, a(str2, false))) != null) {
            aVar = new com.baidu.adp.widget.a.a(c, false, str2);
        }
        a(str2, aVar, false);
        return aVar;
    }

    public com.baidu.adp.widget.a.a b(String str, String str2) {
        com.baidu.adp.widget.a.a aVar;
        if (aa.c().e()) {
            return null;
        }
        com.baidu.adp.widget.a.a c = c(str2);
        if (c != null) {
            return c;
        }
        Iterator<ag> it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = c;
                break;
            }
            ag next = it.next();
            if (next.a(str2)) {
                aVar = next.c(str2);
                break;
            }
        }
        if (aVar == null && str != null) {
            aVar = d(str, a(str2, true));
        }
        a(str2, aVar, true);
        return aVar;
    }

    public String b(String str, boolean z) {
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

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null) {
            if (z) {
                com.baidu.tbadk.imageManager.e.a().b(b(str, z), aVar, true);
                return;
            }
            com.baidu.tbadk.imageManager.e.a().b(str, aVar, false);
        }
    }

    public ArrayList<ag> d() {
        return this.b;
    }

    public ag d(String str) {
        Iterator<ag> it = this.b.iterator();
        while (it.hasNext()) {
            ag next = it.next();
            if (next.e().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public Bitmap c(String str, String str2) {
        return com.baidu.tbadk.core.util.x.c(".emotions/" + str, str2);
    }

    public com.baidu.adp.widget.a.a d(String str, String str2) {
        File file = new File(com.baidu.tbadk.core.util.x.a + "/" + TbConfig.getTempDirName() + "/.emotions/" + str + "/", str2);
        if (file.exists()) {
            if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
                Bitmap c = c(str, str2);
                if (c != null) {
                    return new com.baidu.adp.widget.a.a(c, false, str2);
                }
                return null;
            }
            return com.baidu.adp.gif.b.a().a(file.getAbsolutePath());
        }
        return null;
    }
}
