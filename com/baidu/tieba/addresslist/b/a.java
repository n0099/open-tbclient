package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a azJ;
    private List<b> azK = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> azL;

    private a() {
    }

    public static synchronized a FN() {
        a aVar;
        synchronized (a.class) {
            if (azJ == null) {
                azJ = new a();
            }
            aVar = azJ;
        }
        return aVar;
    }

    public void a(b bVar) {
        if (bVar != null && !this.azK.contains(bVar)) {
            this.azK.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.azK.remove(bVar);
        }
    }

    public void w(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.azL = list;
        if (this.azL != null) {
            Collections.sort(this.azL, new com.baidu.tieba.addresslist.relationship.b());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.azL != null && aVar != null) {
            String xw = aVar.xw();
            if (TextUtils.isEmpty(xw)) {
                xw = "#";
                aVar.ea("#");
            }
            String str = xw;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.azL) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                if (str.equals(aVar2.xw())) {
                    z2 = true;
                }
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.ea(str);
                    this.azL.add(aVar3);
                }
                this.azL.add(aVar);
                Collections.sort(this.azL, new com.baidu.tieba.addresslist.relationship.b());
                notifyObservers();
            }
        }
    }

    public void F(long j) {
        if (this.azL != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.azL.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.xw();
                    this.azL.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.azL) {
                    if (str.equals(aVar.xw())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.azL.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> FO() {
        return this.azL;
    }

    private void notifyObservers() {
        for (b bVar : this.azK) {
            bVar.v(this.azL);
        }
    }
}
