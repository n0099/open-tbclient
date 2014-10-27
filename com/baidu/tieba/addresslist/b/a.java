package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.relationship.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a ahe;
    private List<b> ahf = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.b> ahg;

    private a() {
    }

    public static synchronized a xz() {
        a aVar;
        synchronized (a.class) {
            if (ahe == null) {
                ahe = new a();
            }
            aVar = ahe;
        }
        return aVar;
    }

    public void a(b bVar) {
        if (bVar != null && !this.ahf.contains(bVar)) {
            this.ahf.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.ahf.remove(bVar);
        }
    }

    public void v(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.ahg = list;
        if (this.ahg != null) {
            Collections.sort(this.ahg, new c());
        }
        notifyObservers();
    }

    public void c(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        boolean z = false;
        if (this.ahg != null && bVar != null) {
            String pA = bVar.pA();
            if (TextUtils.isEmpty(pA)) {
                pA = "#";
                bVar.cE("#");
            }
            String str = pA;
            String userName = bVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.b bVar2 : this.ahg) {
                if (str2.equals(bVar2.getUserName())) {
                    z = true;
                }
                if (str.equals(bVar2.pA())) {
                    z2 = true;
                }
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.b bVar3 = new com.baidu.tbadk.coreExtra.relationship.b();
                    bVar3.cE(str);
                    this.ahg.add(bVar3);
                }
                this.ahg.add(bVar);
                Collections.sort(this.ahg, new c());
                notifyObservers();
            }
        }
    }

    public void w(long j) {
        if (this.ahg != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.b> it = this.ahg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.b next = it.next();
                if (next.getUserId() == j) {
                    str = next.pA();
                    this.ahg.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.ahg) {
                    if (str.equals(bVar.pA())) {
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.ahg.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> xA() {
        return this.ahg;
    }

    private void notifyObservers() {
        for (b bVar : this.ahf) {
            bVar.u(this.ahg);
        }
    }
}
