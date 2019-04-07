package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a cOP;
    private List<InterfaceC0256a> cOQ = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> cOR;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0256a {
        void as(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a awP() {
        a aVar;
        synchronized (a.class) {
            if (cOP == null) {
                cOP = new a();
            }
            aVar = cOP;
        }
        return aVar;
    }

    public void a(InterfaceC0256a interfaceC0256a) {
        if (interfaceC0256a != null && !this.cOQ.contains(interfaceC0256a)) {
            this.cOQ.add(interfaceC0256a);
        }
    }

    public void b(InterfaceC0256a interfaceC0256a) {
        if (interfaceC0256a != null) {
            this.cOQ.remove(interfaceC0256a);
        }
    }

    public void at(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cOR = list;
        if (this.cOR != null) {
            Collections.sort(this.cOR, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.cOR != null && aVar != null) {
            String ajM = aVar.ajM();
            if (TextUtils.isEmpty(ajM)) {
                ajM = "#";
                aVar.oa("#");
            }
            String str = ajM;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.cOR) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.ajM()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.oa(str);
                    this.cOR.add(aVar3);
                }
                this.cOR.add(aVar);
                Collections.sort(this.cOR, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void bz(long j) {
        if (this.cOR != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.cOR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.ajM();
                    this.cOR.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.cOR) {
                    if (str.equals(aVar.ajM())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.cOR.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> awQ() {
        return this.cOR;
    }

    private void notifyObservers() {
        for (InterfaceC0256a interfaceC0256a : this.cOQ) {
            interfaceC0256a.as(this.cOR);
        }
    }
}
