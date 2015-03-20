package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a axQ;
    private List<b> axR = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> axS;

    private a() {
    }

    public static synchronized a EO() {
        a aVar;
        synchronized (a.class) {
            if (axQ == null) {
                axQ = new a();
            }
            aVar = axQ;
        }
        return aVar;
    }

    public void a(b bVar) {
        if (bVar != null && !this.axR.contains(bVar)) {
            this.axR.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.axR.remove(bVar);
        }
    }

    public void v(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.axS = list;
        if (this.axS != null) {
            Collections.sort(this.axS, new com.baidu.tieba.addresslist.relationship.b());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.axS != null && aVar != null) {
            String wD = aVar.wD();
            if (TextUtils.isEmpty(wD)) {
                wD = "#";
                aVar.dG("#");
            }
            String str = wD;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.axS) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                if (str.equals(aVar2.wD())) {
                    z2 = true;
                }
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.dG(str);
                    this.axS.add(aVar3);
                }
                this.axS.add(aVar);
                Collections.sort(this.axS, new com.baidu.tieba.addresslist.relationship.b());
                notifyObservers();
            }
        }
    }

    public void G(long j) {
        if (this.axS != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.axS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.wD();
                    this.axS.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.axS) {
                    if (str.equals(aVar.wD())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.axS.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> EP() {
        return this.axS;
    }

    private void notifyObservers() {
        for (b bVar : this.axR) {
            bVar.u(this.axS);
        }
    }
}
