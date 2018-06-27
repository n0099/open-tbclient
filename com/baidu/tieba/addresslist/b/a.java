package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a boj;
    private List<InterfaceC0132a> bok = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> bol;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0132a {
        void W(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a Ri() {
        a aVar;
        synchronized (a.class) {
            if (boj == null) {
                boj = new a();
            }
            aVar = boj;
        }
        return aVar;
    }

    public void a(InterfaceC0132a interfaceC0132a) {
        if (interfaceC0132a != null && !this.bok.contains(interfaceC0132a)) {
            this.bok.add(interfaceC0132a);
        }
    }

    public void b(InterfaceC0132a interfaceC0132a) {
        if (interfaceC0132a != null) {
            this.bok.remove(interfaceC0132a);
        }
    }

    public void X(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bol = list;
        if (this.bol != null) {
            Collections.sort(this.bol, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.bol != null && aVar != null) {
            String Fz = aVar.Fz();
            if (TextUtils.isEmpty(Fz)) {
                Fz = "#";
                aVar.fX("#");
            }
            String str = Fz;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.bol) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.Fz()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.fX(str);
                    this.bol.add(aVar3);
                }
                this.bol.add(aVar);
                Collections.sort(this.bol, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aE(long j) {
        if (this.bol != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.bol.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.Fz();
                    this.bol.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bol) {
                    if (str.equals(aVar.Fz())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.bol.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Rj() {
        return this.bol;
    }

    private void notifyObservers() {
        for (InterfaceC0132a interfaceC0132a : this.bok) {
            interfaceC0132a.W(this.bol);
        }
    }
}
