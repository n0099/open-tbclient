package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.relationship.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a apy;
    private List<com.baidu.tbadk.coreExtra.relationship.b> apA;
    private List<b> apz = new ArrayList();

    private a() {
    }

    public static synchronized a Bo() {
        a aVar;
        synchronized (a.class) {
            if (apy == null) {
                apy = new a();
            }
            aVar = apy;
        }
        return aVar;
    }

    public void a(b bVar) {
        if (bVar != null && !this.apz.contains(bVar)) {
            this.apz.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.apz.remove(bVar);
        }
    }

    public void A(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.apA = list;
        if (this.apA != null) {
            Collections.sort(this.apA, new c());
        }
        notifyObservers();
    }

    public void c(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        boolean z = false;
        if (this.apA != null && bVar != null) {
            String th = bVar.th();
            if (TextUtils.isEmpty(th)) {
                th = "#";
                bVar.dy("#");
            }
            String str = th;
            String userName = bVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.b bVar2 : this.apA) {
                if (str2.equals(bVar2.getUserName())) {
                    z = true;
                }
                if (str.equals(bVar2.th())) {
                    z2 = true;
                }
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.b bVar3 = new com.baidu.tbadk.coreExtra.relationship.b();
                    bVar3.dy(str);
                    this.apA.add(bVar3);
                }
                this.apA.add(bVar);
                Collections.sort(this.apA, new c());
                notifyObservers();
            }
        }
    }

    public void G(long j) {
        if (this.apA != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.b> it = this.apA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.b next = it.next();
                if (next.getUserId() == j) {
                    str = next.th();
                    this.apA.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.apA) {
                    if (str.equals(bVar.th())) {
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.apA.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> Bp() {
        return this.apA;
    }

    private void notifyObservers() {
        for (b bVar : this.apz) {
            bVar.z(this.apA);
        }
    }
}
