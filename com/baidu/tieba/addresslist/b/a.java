package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a axY;
    private List<b> axZ = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> aya;

    private a() {
    }

    public static synchronized a EU() {
        a aVar;
        synchronized (a.class) {
            if (axY == null) {
                axY = new a();
            }
            aVar = axY;
        }
        return aVar;
    }

    public void a(b bVar) {
        if (bVar != null && !this.axZ.contains(bVar)) {
            this.axZ.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.axZ.remove(bVar);
        }
    }

    public void v(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aya = list;
        if (this.aya != null) {
            Collections.sort(this.aya, new com.baidu.tieba.addresslist.relationship.b());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.aya != null && aVar != null) {
            String wJ = aVar.wJ();
            if (TextUtils.isEmpty(wJ)) {
                wJ = "#";
                aVar.dJ("#");
            }
            String str = wJ;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.aya) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                if (str.equals(aVar2.wJ())) {
                    z2 = true;
                }
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.dJ(str);
                    this.aya.add(aVar3);
                }
                this.aya.add(aVar);
                Collections.sort(this.aya, new com.baidu.tieba.addresslist.relationship.b());
                notifyObservers();
            }
        }
    }

    public void G(long j) {
        if (this.aya != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.aya.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.wJ();
                    this.aya.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.aya) {
                    if (str.equals(aVar.wJ())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.aya.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> EV() {
        return this.aya;
    }

    private void notifyObservers() {
        for (b bVar : this.axZ) {
            bVar.u(this.aya);
        }
    }
}
