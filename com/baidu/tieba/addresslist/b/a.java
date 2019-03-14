package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a cON;
    private List<InterfaceC0256a> cOO = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> cOP;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0256a {
        void as(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a awS() {
        a aVar;
        synchronized (a.class) {
            if (cON == null) {
                cON = new a();
            }
            aVar = cON;
        }
        return aVar;
    }

    public void a(InterfaceC0256a interfaceC0256a) {
        if (interfaceC0256a != null && !this.cOO.contains(interfaceC0256a)) {
            this.cOO.add(interfaceC0256a);
        }
    }

    public void b(InterfaceC0256a interfaceC0256a) {
        if (interfaceC0256a != null) {
            this.cOO.remove(interfaceC0256a);
        }
    }

    public void at(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cOP = list;
        if (this.cOP != null) {
            Collections.sort(this.cOP, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.cOP != null && aVar != null) {
            String ajP = aVar.ajP();
            if (TextUtils.isEmpty(ajP)) {
                ajP = "#";
                aVar.nZ("#");
            }
            String str = ajP;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.cOP) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.ajP()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.nZ(str);
                    this.cOP.add(aVar3);
                }
                this.cOP.add(aVar);
                Collections.sort(this.cOP, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void bz(long j) {
        if (this.cOP != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.cOP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.ajP();
                    this.cOP.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.cOP) {
                    if (str.equals(aVar.ajP())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.cOP.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> awT() {
        return this.cOP;
    }

    private void notifyObservers() {
        for (InterfaceC0256a interfaceC0256a : this.cOO) {
            interfaceC0256a.as(this.cOP);
        }
    }
}
