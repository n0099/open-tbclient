package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a cYz;
    private List<InterfaceC0268a> cYA = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> cYB;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0268a {
        void az(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a aDn() {
        a aVar;
        synchronized (a.class) {
            if (cYz == null) {
                cYz = new a();
            }
            aVar = cYz;
        }
        return aVar;
    }

    public void a(InterfaceC0268a interfaceC0268a) {
        if (interfaceC0268a != null && !this.cYA.contains(interfaceC0268a)) {
            this.cYA.add(interfaceC0268a);
        }
    }

    public void b(InterfaceC0268a interfaceC0268a) {
        if (interfaceC0268a != null) {
            this.cYA.remove(interfaceC0268a);
        }
    }

    public void aA(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cYB = list;
        if (this.cYB != null) {
            Collections.sort(this.cYB, new ContactComparator());
        }
        aDp();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.cYB != null && aVar != null) {
            String apT = aVar.apT();
            if (TextUtils.isEmpty(apT)) {
                apT = "#";
                aVar.pA("#");
            }
            String str = apT;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.cYB) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.apT()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.pA(str);
                    this.cYB.add(aVar3);
                }
                this.cYB.add(aVar);
                Collections.sort(this.cYB, new ContactComparator());
                aDp();
            }
        }
    }

    public void bP(long j) {
        if (this.cYB != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.cYB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.apT();
                    this.cYB.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.cYB) {
                    if (str.equals(aVar.apT())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.cYB.removeAll(arrayList);
                }
            }
            aDp();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aDo() {
        return this.cYB;
    }

    private void aDp() {
        for (InterfaceC0268a interfaceC0268a : this.cYA) {
            interfaceC0268a.az(this.cYB);
        }
    }
}
