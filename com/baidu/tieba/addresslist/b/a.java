package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a boP;
    private List<InterfaceC0130a> boQ = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> boR;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0130a {
        void V(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a Rp() {
        a aVar;
        synchronized (a.class) {
            if (boP == null) {
                boP = new a();
            }
            aVar = boP;
        }
        return aVar;
    }

    public void a(InterfaceC0130a interfaceC0130a) {
        if (interfaceC0130a != null && !this.boQ.contains(interfaceC0130a)) {
            this.boQ.add(interfaceC0130a);
        }
    }

    public void b(InterfaceC0130a interfaceC0130a) {
        if (interfaceC0130a != null) {
            this.boQ.remove(interfaceC0130a);
        }
    }

    public void W(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.boR = list;
        if (this.boR != null) {
            Collections.sort(this.boR, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.boR != null && aVar != null) {
            String Fv = aVar.Fv();
            if (TextUtils.isEmpty(Fv)) {
                Fv = "#";
                aVar.fV("#");
            }
            String str = Fv;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.boR) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.Fv()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.fV(str);
                    this.boR.add(aVar3);
                }
                this.boR.add(aVar);
                Collections.sort(this.boR, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aH(long j) {
        if (this.boR != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.boR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.Fv();
                    this.boR.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.boR) {
                    if (str.equals(aVar.Fv())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.boR.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Rq() {
        return this.boR;
    }

    private void notifyObservers() {
        for (InterfaceC0130a interfaceC0130a : this.boQ) {
            interfaceC0130a.V(this.boR);
        }
    }
}
