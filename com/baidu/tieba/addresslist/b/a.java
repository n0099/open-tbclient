package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private static a gkC;
    private List<com.baidu.tbadk.coreExtra.relationship.a> gkD;
    private List<InterfaceC0600a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0600a {
        void bU(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bLW() {
        a aVar;
        synchronized (a.class) {
            if (gkC == null) {
                gkC = new a();
            }
            aVar = gkC;
        }
        return aVar;
    }

    public void a(InterfaceC0600a interfaceC0600a) {
        if (interfaceC0600a != null && !this.mObservers.contains(interfaceC0600a)) {
            this.mObservers.add(interfaceC0600a);
        }
    }

    public void b(InterfaceC0600a interfaceC0600a) {
        if (interfaceC0600a != null) {
            this.mObservers.remove(interfaceC0600a);
        }
    }

    public void bV(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gkD = list;
        if (this.gkD != null) {
            Collections.sort(this.gkD, new ContactComparator());
        }
        bLY();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z;
        boolean z2 = false;
        if (this.gkD != null && aVar != null) {
            String bzc = aVar.bzc();
            if (TextUtils.isEmpty(bzc)) {
                bzc = "#";
                aVar.Cp("#");
            }
            String str = bzc;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.gkD.iterator();
            boolean z3 = false;
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (str2.equals(next.getUserName())) {
                    z3 = true;
                }
                z2 = str.equals(next.bzc()) ? true : z;
            }
            if (!z3) {
                if (!z) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar2.Cp(str);
                    this.gkD.add(aVar2);
                }
                this.gkD.add(aVar);
                Collections.sort(this.gkD, new ContactComparator());
                bLY();
            }
        }
    }

    public void eS(long j) {
        if (this.gkD != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.gkD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.bzc();
                    this.gkD.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.gkD) {
                    if (str.equals(aVar.bzc())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.gkD.removeAll(arrayList);
                }
            }
            bLY();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bLX() {
        return this.gkD;
    }

    private void bLY() {
        for (InterfaceC0600a interfaceC0600a : this.mObservers) {
            interfaceC0600a.bU(this.gkD);
        }
    }
}
