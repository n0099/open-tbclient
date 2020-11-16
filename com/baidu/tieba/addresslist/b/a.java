package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes20.dex */
public class a {
    private static a fTA;
    private List<com.baidu.tbadk.coreExtra.relationship.a> fTB;
    private List<InterfaceC0610a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0610a {
        void bO(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bJh() {
        a aVar;
        synchronized (a.class) {
            if (fTA == null) {
                fTA = new a();
            }
            aVar = fTA;
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
        this.fTB = list;
        if (this.fTB != null) {
            Collections.sort(this.fTB, new ContactComparator());
        }
        bJj();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.fTB != null && aVar != null) {
            String bwG = aVar.bwG();
            if (TextUtils.isEmpty(bwG)) {
                bwG = "#";
                aVar.Cx("#");
            }
            String str = bwG;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.fTB) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.bwG()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.Cx(str);
                    this.fTB.add(aVar3);
                }
                this.fTB.add(aVar);
                Collections.sort(this.fTB, new ContactComparator());
                bJj();
            }
        }
    }

    public void ej(long j) {
        if (this.fTB != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.fTB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.bwG();
                    this.fTB.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.fTB) {
                    if (str.equals(aVar.bwG())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.fTB.removeAll(arrayList);
                }
            }
            bJj();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bJi() {
        return this.fTB;
    }

    private void bJj() {
        for (InterfaceC0610a interfaceC0610a : this.mObservers) {
            interfaceC0610a.bO(this.fTB);
        }
    }
}
