package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static a eQb;
    private List<com.baidu.tbadk.coreExtra.relationship.a> eQc;
    private List<InterfaceC0507a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0507a {
        void bc(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bmX() {
        a aVar;
        synchronized (a.class) {
            if (eQb == null) {
                eQb = new a();
            }
            aVar = eQb;
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
        this.eQc = list;
        if (this.eQc != null) {
            Collections.sort(this.eQc, new ContactComparator());
        }
        bmZ();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.eQc != null && aVar != null) {
            String baZ = aVar.baZ();
            if (TextUtils.isEmpty(baZ)) {
                baZ = "#";
                aVar.xt("#");
            }
            String str = baZ;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.eQc) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.baZ()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.xt(str);
                    this.eQc.add(aVar3);
                }
                this.eQc.add(aVar);
                Collections.sort(this.eQc, new ContactComparator());
                bmZ();
            }
        }
    }

    public void da(long j) {
        if (this.eQc != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.eQc.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.baZ();
                    this.eQc.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.eQc) {
                    if (str.equals(aVar.baZ())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.eQc.removeAll(arrayList);
                }
            }
            bmZ();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bmY() {
        return this.eQc;
    }

    private void bmZ() {
        for (InterfaceC0507a interfaceC0507a : this.mObservers) {
            interfaceC0507a.bc(this.eQc);
        }
    }
}
