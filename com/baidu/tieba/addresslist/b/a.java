package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a diZ;
    private List<com.baidu.tbadk.coreExtra.relationship.a> dja;
    private List<InterfaceC0314a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0314a {
        void aR(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a aEa() {
        a aVar;
        synchronized (a.class) {
            if (diZ == null) {
                diZ = new a();
            }
            aVar = diZ;
        }
        return aVar;
    }

    public void a(InterfaceC0314a interfaceC0314a) {
        if (interfaceC0314a != null && !this.mObservers.contains(interfaceC0314a)) {
            this.mObservers.add(interfaceC0314a);
        }
    }

    public void b(InterfaceC0314a interfaceC0314a) {
        if (interfaceC0314a != null) {
            this.mObservers.remove(interfaceC0314a);
        }
    }

    public void aS(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dja = list;
        if (this.dja != null) {
            Collections.sort(this.dja, new ContactComparator());
        }
        aEc();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.dja != null && aVar != null) {
            String arZ = aVar.arZ();
            if (TextUtils.isEmpty(arZ)) {
                arZ = "#";
                aVar.oV("#");
            }
            String str = arZ;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.dja) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.arZ()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.oV(str);
                    this.dja.add(aVar3);
                }
                this.dja.add(aVar);
                Collections.sort(this.dja, new ContactComparator());
                aEc();
            }
        }
    }

    public void bG(long j) {
        if (this.dja != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.dja.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.arZ();
                    this.dja.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.dja) {
                    if (str.equals(aVar.arZ())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.dja.removeAll(arrayList);
                }
            }
            aEc();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aEb() {
        return this.dja;
    }

    private void aEc() {
        for (InterfaceC0314a interfaceC0314a : this.mObservers) {
            interfaceC0314a.aR(this.dja);
        }
    }
}
