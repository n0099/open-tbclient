package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    private static a fql;
    private List<com.baidu.tbadk.coreExtra.relationship.a> fqm;
    private List<InterfaceC0571a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0571a {
        void bq(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bBy() {
        a aVar;
        synchronized (a.class) {
            if (fql == null) {
                fql = new a();
            }
            aVar = fql;
        }
        return aVar;
    }

    public void a(InterfaceC0571a interfaceC0571a) {
        if (interfaceC0571a != null && !this.mObservers.contains(interfaceC0571a)) {
            this.mObservers.add(interfaceC0571a);
        }
    }

    public void b(InterfaceC0571a interfaceC0571a) {
        if (interfaceC0571a != null) {
            this.mObservers.remove(interfaceC0571a);
        }
    }

    public void br(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fqm = list;
        if (this.fqm != null) {
            Collections.sort(this.fqm, new ContactComparator());
        }
        bBA();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.fqm != null && aVar != null) {
            String bpu = aVar.bpu();
            if (TextUtils.isEmpty(bpu)) {
                bpu = "#";
                aVar.Bj("#");
            }
            String str = bpu;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.fqm) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.bpu()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.Bj(str);
                    this.fqm.add(aVar3);
                }
                this.fqm.add(aVar);
                Collections.sort(this.fqm, new ContactComparator());
                bBA();
            }
        }
    }

    public void dB(long j) {
        if (this.fqm != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.fqm.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.bpu();
                    this.fqm.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.fqm) {
                    if (str.equals(aVar.bpu())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.fqm.removeAll(arrayList);
                }
            }
            bBA();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bBz() {
        return this.fqm;
    }

    private void bBA() {
        for (InterfaceC0571a interfaceC0571a : this.mObservers) {
            interfaceC0571a.bq(this.fqm);
        }
    }
}
