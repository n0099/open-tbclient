package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a bUw;
    private List<InterfaceC0128a> bUx = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> bUy;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0128a {
        void ab(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a UM() {
        a aVar;
        synchronized (a.class) {
            if (bUw == null) {
                bUw = new a();
            }
            aVar = bUw;
        }
        return aVar;
    }

    public void a(InterfaceC0128a interfaceC0128a) {
        if (interfaceC0128a != null && !this.bUx.contains(interfaceC0128a)) {
            this.bUx.add(interfaceC0128a);
        }
    }

    public void b(InterfaceC0128a interfaceC0128a) {
        if (interfaceC0128a != null) {
            this.bUx.remove(interfaceC0128a);
        }
    }

    public void ac(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bUy = list;
        if (this.bUy != null) {
            Collections.sort(this.bUy, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.bUy != null && aVar != null) {
            String IU = aVar.IU();
            if (TextUtils.isEmpty(IU)) {
                IU = "#";
                aVar.fE("#");
            }
            String str = IU;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.bUy) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.IU()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.fE(str);
                    this.bUy.add(aVar3);
                }
                this.bUy.add(aVar);
                Collections.sort(this.bUy, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aI(long j) {
        if (this.bUy != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.bUy.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.IU();
                    this.bUy.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bUy) {
                    if (str.equals(aVar.IU())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.bUy.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> UN() {
        return this.bUy;
    }

    private void notifyObservers() {
        for (InterfaceC0128a interfaceC0128a : this.bUx) {
            interfaceC0128a.ab(this.bUy);
        }
    }
}
