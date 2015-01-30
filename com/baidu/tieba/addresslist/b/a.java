package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.relationship.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a apB;
    private List<b> apC = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.b> apD;

    private a() {
    }

    public static synchronized a Bu() {
        a aVar;
        synchronized (a.class) {
            if (apB == null) {
                apB = new a();
            }
            aVar = apB;
        }
        return aVar;
    }

    public void a(b bVar) {
        if (bVar != null && !this.apC.contains(bVar)) {
            this.apC.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.apC.remove(bVar);
        }
    }

    public void A(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.apD = list;
        if (this.apD != null) {
            Collections.sort(this.apD, new c());
        }
        notifyObservers();
    }

    public void c(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        boolean z = false;
        if (this.apD != null && bVar != null) {
            String tn = bVar.tn();
            if (TextUtils.isEmpty(tn)) {
                tn = "#";
                bVar.dB("#");
            }
            String str = tn;
            String userName = bVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.b bVar2 : this.apD) {
                if (str2.equals(bVar2.getUserName())) {
                    z = true;
                }
                if (str.equals(bVar2.tn())) {
                    z2 = true;
                }
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.b bVar3 = new com.baidu.tbadk.coreExtra.relationship.b();
                    bVar3.dB(str);
                    this.apD.add(bVar3);
                }
                this.apD.add(bVar);
                Collections.sort(this.apD, new c());
                notifyObservers();
            }
        }
    }

    public void G(long j) {
        if (this.apD != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.b> it = this.apD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.b next = it.next();
                if (next.getUserId() == j) {
                    str = next.tn();
                    this.apD.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.apD) {
                    if (str.equals(bVar.tn())) {
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.apD.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> Bv() {
        return this.apD;
    }

    private void notifyObservers() {
        for (b bVar : this.apC) {
            bVar.z(this.apD);
        }
    }
}
