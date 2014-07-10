package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.relationship.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a a;
    private List<b> b = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.b> c;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public void a(b bVar) {
        if (bVar != null && !this.b.contains(bVar)) {
            this.b.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.b.remove(bVar);
        }
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.c = list;
        if (this.c != null) {
            Collections.sort(this.c, new c());
        }
        c();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        boolean z = false;
        if (this.c != null && bVar != null) {
            String f = bVar.f();
            if (TextUtils.isEmpty(f)) {
                f = "#";
                bVar.d("#");
            }
            String str = f;
            String b = bVar.b();
            String str2 = b == null ? "" : b;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.b bVar2 : this.c) {
                if (str2.equals(bVar2.b())) {
                    z = true;
                }
                if (str.equals(bVar2.f())) {
                    z2 = true;
                }
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.b bVar3 = new com.baidu.tbadk.coreExtra.relationship.b();
                    bVar3.d(str);
                    this.c.add(bVar3);
                }
                this.c.add(bVar);
                Collections.sort(this.c, new c());
                c();
            }
        }
    }

    public void a(long j) {
        if (this.c != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.b> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.b next = it.next();
                if (next.c() == j) {
                    str = next.f();
                    this.c.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.c) {
                    if (str.equals(bVar.f())) {
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.c.removeAll(arrayList);
                }
            }
            c();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> b() {
        return this.c;
    }

    private void c() {
        for (b bVar : this.b) {
            bVar.a(this.c);
        }
    }
}
