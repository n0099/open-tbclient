package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    private static a fqh;
    private List<com.baidu.tbadk.coreExtra.relationship.a> fqi;
    private List<InterfaceC0571a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0571a {
        void bq(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bBx() {
        a aVar;
        synchronized (a.class) {
            if (fqh == null) {
                fqh = new a();
            }
            aVar = fqh;
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
        this.fqi = list;
        if (this.fqi != null) {
            Collections.sort(this.fqi, new ContactComparator());
        }
        bBz();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.fqi != null && aVar != null) {
            String bpt = aVar.bpt();
            if (TextUtils.isEmpty(bpt)) {
                bpt = "#";
                aVar.Bi("#");
            }
            String str = bpt;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.fqi) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.bpt()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.Bi(str);
                    this.fqi.add(aVar3);
                }
                this.fqi.add(aVar);
                Collections.sort(this.fqi, new ContactComparator());
                bBz();
            }
        }
    }

    public void dB(long j) {
        if (this.fqi != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.fqi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.bpt();
                    this.fqi.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.fqi) {
                    if (str.equals(aVar.bpt())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.fqi.removeAll(arrayList);
                }
            }
            bBz();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bBy() {
        return this.fqi;
    }

    private void bBz() {
        for (InterfaceC0571a interfaceC0571a : this.mObservers) {
            interfaceC0571a.bq(this.fqi);
        }
    }
}
