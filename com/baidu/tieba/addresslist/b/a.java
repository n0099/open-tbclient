package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private static a fOd;
    private List<com.baidu.tbadk.coreExtra.relationship.a> fOe;
    private List<InterfaceC0598a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0598a {
        void bH(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bHp() {
        a aVar;
        synchronized (a.class) {
            if (fOd == null) {
                fOd = new a();
            }
            aVar = fOd;
        }
        return aVar;
    }

    public void a(InterfaceC0598a interfaceC0598a) {
        if (interfaceC0598a != null && !this.mObservers.contains(interfaceC0598a)) {
            this.mObservers.add(interfaceC0598a);
        }
    }

    public void b(InterfaceC0598a interfaceC0598a) {
        if (interfaceC0598a != null) {
            this.mObservers.remove(interfaceC0598a);
        }
    }

    public void bI(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fOe = list;
        if (this.fOe != null) {
            Collections.sort(this.fOe, new ContactComparator());
        }
        bHr();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.fOe != null && aVar != null) {
            String buR = aVar.buR();
            if (TextUtils.isEmpty(buR)) {
                buR = "#";
                aVar.CK("#");
            }
            String str = buR;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.fOe) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.buR()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.CK(str);
                    this.fOe.add(aVar3);
                }
                this.fOe.add(aVar);
                Collections.sort(this.fOe, new ContactComparator());
                bHr();
            }
        }
    }

    public void dN(long j) {
        if (this.fOe != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.fOe.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.buR();
                    this.fOe.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.fOe) {
                    if (str.equals(aVar.buR())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.fOe.removeAll(arrayList);
                }
            }
            bHr();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bHq() {
        return this.fOe;
    }

    private void bHr() {
        for (InterfaceC0598a interfaceC0598a : this.mObservers) {
            interfaceC0598a.bH(this.fOe);
        }
    }
}
