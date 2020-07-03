package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static a fam;
    private List<com.baidu.tbadk.coreExtra.relationship.a> fan;
    private List<InterfaceC0515a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0515a {
        void bm(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bpx() {
        a aVar;
        synchronized (a.class) {
            if (fam == null) {
                fam = new a();
            }
            aVar = fam;
        }
        return aVar;
    }

    public void a(InterfaceC0515a interfaceC0515a) {
        if (interfaceC0515a != null && !this.mObservers.contains(interfaceC0515a)) {
            this.mObservers.add(interfaceC0515a);
        }
    }

    public void b(InterfaceC0515a interfaceC0515a) {
        if (interfaceC0515a != null) {
            this.mObservers.remove(interfaceC0515a);
        }
    }

    public void bn(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fan = list;
        if (this.fan != null) {
            Collections.sort(this.fan, new ContactComparator());
        }
        bpz();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.fan != null && aVar != null) {
            String bdb = aVar.bdb();
            if (TextUtils.isEmpty(bdb)) {
                bdb = "#";
                aVar.xM("#");
            }
            String str = bdb;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.fan) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.bdb()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.xM(str);
                    this.fan.add(aVar3);
                }
                this.fan.add(aVar);
                Collections.sort(this.fan, new ContactComparator());
                bpz();
            }
        }
    }

    public void dc(long j) {
        if (this.fan != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.fan.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.bdb();
                    this.fan.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.fan) {
                    if (str.equals(aVar.bdb())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.fan.removeAll(arrayList);
                }
            }
            bpz();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bpy() {
        return this.fan;
    }

    private void bpz() {
        for (InterfaceC0515a interfaceC0515a : this.mObservers) {
            interfaceC0515a.bm(this.fan);
        }
    }
}
