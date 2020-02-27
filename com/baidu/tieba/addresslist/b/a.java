package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static a eaV;
    private List<com.baidu.tbadk.coreExtra.relationship.a> eaW;
    private List<InterfaceC0408a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0408a {
        void aX(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a aYB() {
        a aVar;
        synchronized (a.class) {
            if (eaV == null) {
                eaV = new a();
            }
            aVar = eaV;
        }
        return aVar;
    }

    public void a(InterfaceC0408a interfaceC0408a) {
        if (interfaceC0408a != null && !this.mObservers.contains(interfaceC0408a)) {
            this.mObservers.add(interfaceC0408a);
        }
    }

    public void b(InterfaceC0408a interfaceC0408a) {
        if (interfaceC0408a != null) {
            this.mObservers.remove(interfaceC0408a);
        }
    }

    public void aY(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eaW = list;
        if (this.eaW != null) {
            Collections.sort(this.eaW, new ContactComparator());
        }
        aYD();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.eaW != null && aVar != null) {
            String aMm = aVar.aMm();
            if (TextUtils.isEmpty(aMm)) {
                aMm = "#";
                aVar.uv("#");
            }
            String str = aMm;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.eaW) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.aMm()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.uv(str);
                    this.eaW.add(aVar3);
                }
                this.eaW.add(aVar);
                Collections.sort(this.eaW, new ContactComparator());
                aYD();
            }
        }
    }

    public void cr(long j) {
        if (this.eaW != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.eaW.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.aMm();
                    this.eaW.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.eaW) {
                    if (str.equals(aVar.aMm())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.eaW.removeAll(arrayList);
                }
            }
            aYD();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aYC() {
        return this.eaW;
    }

    private void aYD() {
        for (InterfaceC0408a interfaceC0408a : this.mObservers) {
            interfaceC0408a.aX(this.eaW);
        }
    }
}
