package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a dar;
    private List<InterfaceC0282a> das = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> dat;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0282a {
        void az(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a aDT() {
        a aVar;
        synchronized (a.class) {
            if (dar == null) {
                dar = new a();
            }
            aVar = dar;
        }
        return aVar;
    }

    public void a(InterfaceC0282a interfaceC0282a) {
        if (interfaceC0282a != null && !this.das.contains(interfaceC0282a)) {
            this.das.add(interfaceC0282a);
        }
    }

    public void b(InterfaceC0282a interfaceC0282a) {
        if (interfaceC0282a != null) {
            this.das.remove(interfaceC0282a);
        }
    }

    public void aA(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dat = list;
        if (this.dat != null) {
            Collections.sort(this.dat, new ContactComparator());
        }
        aDV();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.dat != null && aVar != null) {
            String aqh = aVar.aqh();
            if (TextUtils.isEmpty(aqh)) {
                aqh = "#";
                aVar.pL("#");
            }
            String str = aqh;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.dat) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.aqh()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.pL(str);
                    this.dat.add(aVar3);
                }
                this.dat.add(aVar);
                Collections.sort(this.dat, new ContactComparator());
                aDV();
            }
        }
    }

    public void bS(long j) {
        if (this.dat != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.dat.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.aqh();
                    this.dat.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.dat) {
                    if (str.equals(aVar.aqh())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.dat.removeAll(arrayList);
                }
            }
            aDV();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aDU() {
        return this.dat;
    }

    private void aDV() {
        for (InterfaceC0282a interfaceC0282a : this.das) {
            interfaceC0282a.az(this.dat);
        }
    }
}
