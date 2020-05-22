package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static a ePQ;
    private List<com.baidu.tbadk.coreExtra.relationship.a> ePR;
    private List<InterfaceC0507a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0507a {
        void bc(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bmV() {
        a aVar;
        synchronized (a.class) {
            if (ePQ == null) {
                ePQ = new a();
            }
            aVar = ePQ;
        }
        return aVar;
    }

    public void a(InterfaceC0507a interfaceC0507a) {
        if (interfaceC0507a != null && !this.mObservers.contains(interfaceC0507a)) {
            this.mObservers.add(interfaceC0507a);
        }
    }

    public void b(InterfaceC0507a interfaceC0507a) {
        if (interfaceC0507a != null) {
            this.mObservers.remove(interfaceC0507a);
        }
    }

    public void bd(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ePR = list;
        if (this.ePR != null) {
            Collections.sort(this.ePR, new ContactComparator());
        }
        bmX();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.ePR != null && aVar != null) {
            String baY = aVar.baY();
            if (TextUtils.isEmpty(baY)) {
                baY = "#";
                aVar.xt("#");
            }
            String str = baY;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.ePR) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.baY()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.xt(str);
                    this.ePR.add(aVar3);
                }
                this.ePR.add(aVar);
                Collections.sort(this.ePR, new ContactComparator());
                bmX();
            }
        }
    }

    public void da(long j) {
        if (this.ePR != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.ePR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.baY();
                    this.ePR.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.ePR) {
                    if (str.equals(aVar.baY())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.ePR.removeAll(arrayList);
                }
            }
            bmX();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bmW() {
        return this.ePR;
    }

    private void bmX() {
        for (InterfaceC0507a interfaceC0507a : this.mObservers) {
            interfaceC0507a.bc(this.ePR);
        }
    }
}
