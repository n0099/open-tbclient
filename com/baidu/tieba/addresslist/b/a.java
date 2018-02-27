package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a bUt;
    private List<InterfaceC0128a> bUu = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> bUv;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0128a {
        void ab(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a UL() {
        a aVar;
        synchronized (a.class) {
            if (bUt == null) {
                bUt = new a();
            }
            aVar = bUt;
        }
        return aVar;
    }

    public void a(InterfaceC0128a interfaceC0128a) {
        if (interfaceC0128a != null && !this.bUu.contains(interfaceC0128a)) {
            this.bUu.add(interfaceC0128a);
        }
    }

    public void b(InterfaceC0128a interfaceC0128a) {
        if (interfaceC0128a != null) {
            this.bUu.remove(interfaceC0128a);
        }
    }

    public void ac(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bUv = list;
        if (this.bUv != null) {
            Collections.sort(this.bUv, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.bUv != null && aVar != null) {
            String IT = aVar.IT();
            if (TextUtils.isEmpty(IT)) {
                IT = "#";
                aVar.fE("#");
            }
            String str = IT;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.bUv) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.IT()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.fE(str);
                    this.bUv.add(aVar3);
                }
                this.bUv.add(aVar);
                Collections.sort(this.bUv, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aI(long j) {
        if (this.bUv != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.bUv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.IT();
                    this.bUv.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bUv) {
                    if (str.equals(aVar.IT())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.bUv.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> UM() {
        return this.bUv;
    }

    private void notifyObservers() {
        for (InterfaceC0128a interfaceC0128a : this.bUu) {
            interfaceC0128a.ab(this.bUv);
        }
    }
}
