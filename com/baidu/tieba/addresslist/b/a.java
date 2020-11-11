package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private static a fTT;
    private List<com.baidu.tbadk.coreExtra.relationship.a> fTU;
    private List<InterfaceC0610a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0610a {
        void bO(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bJO() {
        a aVar;
        synchronized (a.class) {
            if (fTT == null) {
                fTT = new a();
            }
            aVar = fTT;
        }
        return aVar;
    }

    public void a(InterfaceC0610a interfaceC0610a) {
        if (interfaceC0610a != null && !this.mObservers.contains(interfaceC0610a)) {
            this.mObservers.add(interfaceC0610a);
        }
    }

    public void b(InterfaceC0610a interfaceC0610a) {
        if (interfaceC0610a != null) {
            this.mObservers.remove(interfaceC0610a);
        }
    }

    public void bP(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fTU = list;
        if (this.fTU != null) {
            Collections.sort(this.fTU, new ContactComparator());
        }
        bJQ();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.fTU != null && aVar != null) {
            String bxq = aVar.bxq();
            if (TextUtils.isEmpty(bxq)) {
                bxq = "#";
                aVar.CY("#");
            }
            String str = bxq;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.fTU) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.bxq()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.CY(str);
                    this.fTU.add(aVar3);
                }
                this.fTU.add(aVar);
                Collections.sort(this.fTU, new ContactComparator());
                bJQ();
            }
        }
    }

    public void ej(long j) {
        if (this.fTU != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.fTU.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.bxq();
                    this.fTU.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.fTU) {
                    if (str.equals(aVar.bxq())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.fTU.removeAll(arrayList);
                }
            }
            bJQ();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bJP() {
        return this.fTU;
    }

    private void bJQ() {
        for (InterfaceC0610a interfaceC0610a : this.mObservers) {
            interfaceC0610a.bO(this.fTU);
        }
    }
}
