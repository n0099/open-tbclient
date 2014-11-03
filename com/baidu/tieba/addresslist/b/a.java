package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.relationship.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a ahn;
    private List<b> aho = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.b> ahp;

    private a() {
    }

    public static synchronized a xB() {
        a aVar;
        synchronized (a.class) {
            if (ahn == null) {
                ahn = new a();
            }
            aVar = ahn;
        }
        return aVar;
    }

    public void a(b bVar) {
        if (bVar != null && !this.aho.contains(bVar)) {
            this.aho.add(bVar);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.aho.remove(bVar);
        }
    }

    public void v(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.ahp = list;
        if (this.ahp != null) {
            Collections.sort(this.ahp, new c());
        }
        notifyObservers();
    }

    public void c(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        boolean z = false;
        if (this.ahp != null && bVar != null) {
            String pC = bVar.pC();
            if (TextUtils.isEmpty(pC)) {
                pC = "#";
                bVar.cF("#");
            }
            String str = pC;
            String userName = bVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.b bVar2 : this.ahp) {
                if (str2.equals(bVar2.getUserName())) {
                    z = true;
                }
                if (str.equals(bVar2.pC())) {
                    z2 = true;
                }
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.b bVar3 = new com.baidu.tbadk.coreExtra.relationship.b();
                    bVar3.cF(str);
                    this.ahp.add(bVar3);
                }
                this.ahp.add(bVar);
                Collections.sort(this.ahp, new c());
                notifyObservers();
            }
        }
    }

    public void w(long j) {
        if (this.ahp != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.b> it = this.ahp.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.b next = it.next();
                if (next.getUserId() == j) {
                    str = next.pC();
                    this.ahp.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.ahp) {
                    if (str.equals(bVar.pC())) {
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.ahp.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> xC() {
        return this.ahp;
    }

    private void notifyObservers() {
        for (b bVar : this.aho) {
            bVar.u(this.ahp);
        }
    }
}
