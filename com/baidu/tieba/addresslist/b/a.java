package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.relationship.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a aoD;
    private List<b> aoE = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.b> aoF;

    private a() {
    }

    public static synchronized a AU() {
        a aVar;
        synchronized (a.class) {
            if (aoD == null) {
                aoD = new a();
            }
            aVar = aoD;
        }
        return aVar;
    }

    public void a(b bVar) {
        if (bVar != null && !this.aoE.contains(bVar)) {
            this.aoE.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aoE.remove(bVar);
        }
    }

    public void A(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.aoF = list;
        if (this.aoF != null) {
            Collections.sort(this.aoF, new c());
        }
        notifyObservers();
    }

    public void c(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        boolean z = false;
        if (this.aoF != null && bVar != null) {
            String sW = bVar.sW();
            if (TextUtils.isEmpty(sW)) {
                sW = "#";
                bVar.dC("#");
            }
            String str = sW;
            String userName = bVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.b bVar2 : this.aoF) {
                if (str2.equals(bVar2.getUserName())) {
                    z = true;
                }
                if (str.equals(bVar2.sW())) {
                    z2 = true;
                }
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.b bVar3 = new com.baidu.tbadk.coreExtra.relationship.b();
                    bVar3.dC(str);
                    this.aoF.add(bVar3);
                }
                this.aoF.add(bVar);
                Collections.sort(this.aoF, new c());
                notifyObservers();
            }
        }
    }

    public void G(long j) {
        if (this.aoF != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.b> it = this.aoF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.b next = it.next();
                if (next.getUserId() == j) {
                    str = next.sW();
                    this.aoF.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.aoF) {
                    if (str.equals(bVar.sW())) {
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.aoF.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> AV() {
        return this.aoF;
    }

    private void notifyObservers() {
        for (b bVar : this.aoE) {
            bVar.z(this.aoF);
        }
    }
}
