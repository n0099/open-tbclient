package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a bUF;
    private List<InterfaceC0127a> bUG = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> bUH;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0127a {
        void ab(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a UM() {
        a aVar;
        synchronized (a.class) {
            if (bUF == null) {
                bUF = new a();
            }
            aVar = bUF;
        }
        return aVar;
    }

    public void a(InterfaceC0127a interfaceC0127a) {
        if (interfaceC0127a != null && !this.bUG.contains(interfaceC0127a)) {
            this.bUG.add(interfaceC0127a);
        }
    }

    public void b(InterfaceC0127a interfaceC0127a) {
        if (interfaceC0127a != null) {
            this.bUG.remove(interfaceC0127a);
        }
    }

    public void ac(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bUH = list;
        if (this.bUH != null) {
            Collections.sort(this.bUH, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.bUH != null && aVar != null) {
            String IU = aVar.IU();
            if (TextUtils.isEmpty(IU)) {
                IU = "#";
                aVar.fE("#");
            }
            String str = IU;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.bUH) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.IU()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.fE(str);
                    this.bUH.add(aVar3);
                }
                this.bUH.add(aVar);
                Collections.sort(this.bUH, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aI(long j) {
        if (this.bUH != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.bUH.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.IU();
                    this.bUH.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bUH) {
                    if (str.equals(aVar.IU())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.bUH.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> UN() {
        return this.bUH;
    }

    private void notifyObservers() {
        for (InterfaceC0127a interfaceC0127a : this.bUG) {
            interfaceC0127a.ab(this.bUH);
        }
    }
}
