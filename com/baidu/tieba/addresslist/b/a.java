package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a djQ;
    private List<com.baidu.tbadk.coreExtra.relationship.a> djR;
    private List<InterfaceC0314a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0314a {
        void aR(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a aEc() {
        a aVar;
        synchronized (a.class) {
            if (djQ == null) {
                djQ = new a();
            }
            aVar = djQ;
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
        this.djR = list;
        if (this.djR != null) {
            Collections.sort(this.djR, new ContactComparator());
        }
        aEe();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.djR != null && aVar != null) {
            String asb = aVar.asb();
            if (TextUtils.isEmpty(asb)) {
                asb = "#";
                aVar.oV("#");
            }
            String str = asb;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.djR) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.asb()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.oV(str);
                    this.djR.add(aVar3);
                }
                this.djR.add(aVar);
                Collections.sort(this.djR, new ContactComparator());
                aEe();
            }
        }
    }

    public void bH(long j) {
        if (this.djR != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.djR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.asb();
                    this.djR.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.djR) {
                    if (str.equals(aVar.asb())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.djR.removeAll(arrayList);
                }
            }
            aEe();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aEd() {
        return this.djR;
    }

    private void aEe() {
        for (InterfaceC0314a interfaceC0314a : this.mObservers) {
            interfaceC0314a.aR(this.djR);
        }
    }
}
