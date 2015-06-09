package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a azK;
    private List<b> azL = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> azM;

    private a() {
    }

    public static synchronized a FO() {
        a aVar;
        synchronized (a.class) {
            if (azK == null) {
                azK = new a();
            }
            aVar = azK;
        }
        return aVar;
    }

    public void a(b bVar) {
        if (bVar != null && !this.azL.contains(bVar)) {
            this.azL.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.azL.remove(bVar);
        }
    }

    public void w(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.azM = list;
        if (this.azM != null) {
            Collections.sort(this.azM, new com.baidu.tieba.addresslist.relationship.b());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.azM != null && aVar != null) {
            String xx = aVar.xx();
            if (TextUtils.isEmpty(xx)) {
                xx = "#";
                aVar.ea("#");
            }
            String str = xx;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.azM) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                if (str.equals(aVar2.xx())) {
                    z2 = true;
                }
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.ea(str);
                    this.azM.add(aVar3);
                }
                this.azM.add(aVar);
                Collections.sort(this.azM, new com.baidu.tieba.addresslist.relationship.b());
                notifyObservers();
            }
        }
    }

    public void F(long j) {
        if (this.azM != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.azM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.xx();
                    this.azM.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.azM) {
                    if (str.equals(aVar.xx())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.azM.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> FP() {
        return this.azM;
    }

    private void notifyObservers() {
        for (b bVar : this.azL) {
            bVar.v(this.azM);
        }
    }
}
