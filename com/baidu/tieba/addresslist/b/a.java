package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a bCS;
    private List<InterfaceC0188a> bCT = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> bCU;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0188a {
        void ae(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a Wt() {
        a aVar;
        synchronized (a.class) {
            if (bCS == null) {
                bCS = new a();
            }
            aVar = bCS;
        }
        return aVar;
    }

    public void a(InterfaceC0188a interfaceC0188a) {
        if (interfaceC0188a != null && !this.bCT.contains(interfaceC0188a)) {
            this.bCT.add(interfaceC0188a);
        }
    }

    public void b(InterfaceC0188a interfaceC0188a) {
        if (interfaceC0188a != null) {
            this.bCT.remove(interfaceC0188a);
        }
    }

    public void af(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bCU = list;
        if (this.bCU != null) {
            Collections.sort(this.bCU, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.bCU != null && aVar != null) {
            String Kc = aVar.Kc();
            if (TextUtils.isEmpty(Kc)) {
                Kc = "#";
                aVar.gZ("#");
            }
            String str = Kc;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.bCU) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.Kc()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.gZ(str);
                    this.bCU.add(aVar3);
                }
                this.bCU.add(aVar);
                Collections.sort(this.bCU, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aW(long j) {
        if (this.bCU != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.bCU.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.Kc();
                    this.bCU.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bCU) {
                    if (str.equals(aVar.Kc())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.bCU.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Wu() {
        return this.bCU;
    }

    private void notifyObservers() {
        for (InterfaceC0188a interfaceC0188a : this.bCT) {
            interfaceC0188a.ae(this.bCU);
        }
    }
}
