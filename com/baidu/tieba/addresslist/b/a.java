package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static a ebz;
    private List<com.baidu.tbadk.coreExtra.relationship.a> ebA;
    private List<InterfaceC0408a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0408a {
        void aX(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a aYI() {
        a aVar;
        synchronized (a.class) {
            if (ebz == null) {
                ebz = new a();
            }
            aVar = ebz;
        }
        return aVar;
    }

    public void a(InterfaceC0408a interfaceC0408a) {
        if (interfaceC0408a != null && !this.mObservers.contains(interfaceC0408a)) {
            this.mObservers.add(interfaceC0408a);
        }
    }

    public void b(InterfaceC0408a interfaceC0408a) {
        if (interfaceC0408a != null) {
            this.mObservers.remove(interfaceC0408a);
        }
    }

    public void aY(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ebA = list;
        if (this.ebA != null) {
            Collections.sort(this.ebA, new ContactComparator());
        }
        aYK();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.ebA != null && aVar != null) {
            String aMt = aVar.aMt();
            if (TextUtils.isEmpty(aMt)) {
                aMt = "#";
                aVar.uw("#");
            }
            String str = aMt;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.ebA) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.aMt()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.uw(str);
                    this.ebA.add(aVar3);
                }
                this.ebA.add(aVar);
                Collections.sort(this.ebA, new ContactComparator());
                aYK();
            }
        }
    }

    public void cr(long j) {
        if (this.ebA != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.ebA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.aMt();
                    this.ebA.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.ebA) {
                    if (str.equals(aVar.aMt())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.ebA.removeAll(arrayList);
                }
            }
            aYK();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aYJ() {
        return this.ebA;
    }

    private void aYK() {
        for (InterfaceC0408a interfaceC0408a : this.mObservers) {
            interfaceC0408a.aX(this.ebA);
        }
    }
}
