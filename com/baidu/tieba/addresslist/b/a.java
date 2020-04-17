package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static a eBm;
    private List<com.baidu.tbadk.coreExtra.relationship.a> eBn;
    private List<InterfaceC0439a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0439a {
        void bh(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bgM() {
        a aVar;
        synchronized (a.class) {
            if (eBm == null) {
                eBm = new a();
            }
            aVar = eBm;
        }
        return aVar;
    }

    public void a(InterfaceC0439a interfaceC0439a) {
        if (interfaceC0439a != null && !this.mObservers.contains(interfaceC0439a)) {
            this.mObservers.add(interfaceC0439a);
        }
    }

    public void b(InterfaceC0439a interfaceC0439a) {
        if (interfaceC0439a != null) {
            this.mObservers.remove(interfaceC0439a);
        }
    }

    public void bi(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eBn = list;
        if (this.eBn != null) {
            Collections.sort(this.eBn, new ContactComparator());
        }
        bgO();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.eBn != null && aVar != null) {
            String aUQ = aVar.aUQ();
            if (TextUtils.isEmpty(aUQ)) {
                aUQ = "#";
                aVar.vK("#");
            }
            String str = aUQ;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.eBn) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.aUQ()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.vK(str);
                    this.eBn.add(aVar3);
                }
                this.eBn.add(aVar);
                Collections.sort(this.eBn, new ContactComparator());
                bgO();
            }
        }
    }

    public void cY(long j) {
        if (this.eBn != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.eBn.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.aUQ();
                    this.eBn.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.eBn) {
                    if (str.equals(aVar.aUQ())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.eBn.removeAll(arrayList);
                }
            }
            bgO();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bgN() {
        return this.eBn;
    }

    private void bgO() {
        for (InterfaceC0439a interfaceC0439a : this.mObservers) {
            interfaceC0439a.bh(this.eBn);
        }
    }
}
