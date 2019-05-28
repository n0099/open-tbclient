package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a cXc;
    private List<InterfaceC0271a> cXd = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> cXe;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0271a {
        void az(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a aBY() {
        a aVar;
        synchronized (a.class) {
            if (cXc == null) {
                cXc = new a();
            }
            aVar = cXc;
        }
        return aVar;
    }

    public void a(InterfaceC0271a interfaceC0271a) {
        if (interfaceC0271a != null && !this.cXd.contains(interfaceC0271a)) {
            this.cXd.add(interfaceC0271a);
        }
    }

    public void b(InterfaceC0271a interfaceC0271a) {
        if (interfaceC0271a != null) {
            this.cXd.remove(interfaceC0271a);
        }
    }

    public void aA(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cXe = list;
        if (this.cXe != null) {
            Collections.sort(this.cXe, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.cXe != null && aVar != null) {
            String aoN = aVar.aoN();
            if (TextUtils.isEmpty(aoN)) {
                aoN = "#";
                aVar.pk("#");
            }
            String str = aoN;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.cXe) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.aoN()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.pk(str);
                    this.cXe.add(aVar3);
                }
                this.cXe.add(aVar);
                Collections.sort(this.cXe, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void bO(long j) {
        if (this.cXe != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.cXe.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.aoN();
                    this.cXe.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.cXe) {
                    if (str.equals(aVar.aoN())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.cXe.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aBZ() {
        return this.cXe;
    }

    private void notifyObservers() {
        for (InterfaceC0271a interfaceC0271a : this.cXd) {
            interfaceC0271a.az(this.cXe);
        }
    }
}
