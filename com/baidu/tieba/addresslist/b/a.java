package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a boR;
    private List<InterfaceC0130a> boS = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> boT;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0130a {
        void V(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a Ru() {
        a aVar;
        synchronized (a.class) {
            if (boR == null) {
                boR = new a();
            }
            aVar = boR;
        }
        return aVar;
    }

    public void a(InterfaceC0130a interfaceC0130a) {
        if (interfaceC0130a != null && !this.boS.contains(interfaceC0130a)) {
            this.boS.add(interfaceC0130a);
        }
    }

    public void b(InterfaceC0130a interfaceC0130a) {
        if (interfaceC0130a != null) {
            this.boS.remove(interfaceC0130a);
        }
    }

    public void W(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.boT = list;
        if (this.boT != null) {
            Collections.sort(this.boT, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.boT != null && aVar != null) {
            String Fv = aVar.Fv();
            if (TextUtils.isEmpty(Fv)) {
                Fv = "#";
                aVar.fV("#");
            }
            String str = Fv;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.boT) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.Fv()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.fV(str);
                    this.boT.add(aVar3);
                }
                this.boT.add(aVar);
                Collections.sort(this.boT, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aH(long j) {
        if (this.boT != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.boT.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.Fv();
                    this.boT.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.boT) {
                    if (str.equals(aVar.Fv())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.boT.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Rv() {
        return this.boT;
    }

    private void notifyObservers() {
        for (InterfaceC0130a interfaceC0130a : this.boS) {
            interfaceC0130a.V(this.boT);
        }
    }
}
