package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private static a gbK;
    private List<com.baidu.tbadk.coreExtra.relationship.a> gbL;
    private List<InterfaceC0622a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0622a {
        void bS(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bMP() {
        a aVar;
        synchronized (a.class) {
            if (gbK == null) {
                gbK = new a();
            }
            aVar = gbK;
        }
        return aVar;
    }

    public void a(InterfaceC0622a interfaceC0622a) {
        if (interfaceC0622a != null && !this.mObservers.contains(interfaceC0622a)) {
            this.mObservers.add(interfaceC0622a);
        }
    }

    public void b(InterfaceC0622a interfaceC0622a) {
        if (interfaceC0622a != null) {
            this.mObservers.remove(interfaceC0622a);
        }
    }

    public void bT(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gbL = list;
        if (this.gbL != null) {
            Collections.sort(this.gbL, new ContactComparator());
        }
        bMR();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.gbL != null && aVar != null) {
            String bAg = aVar.bAg();
            if (TextUtils.isEmpty(bAg)) {
                bAg = "#";
                aVar.Df("#");
            }
            String str = bAg;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.gbL) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.bAg()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.Df(str);
                    this.gbL.add(aVar3);
                }
                this.gbL.add(aVar);
                Collections.sort(this.gbL, new ContactComparator());
                bMR();
            }
        }
    }

    public void eM(long j) {
        if (this.gbL != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.gbL.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.bAg();
                    this.gbL.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.gbL) {
                    if (str.equals(aVar.bAg())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.gbL.removeAll(arrayList);
                }
            }
            bMR();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bMQ() {
        return this.gbL;
    }

    private void bMR() {
        for (InterfaceC0622a interfaceC0622a : this.mObservers) {
            interfaceC0622a.bS(this.gbL);
        }
    }
}
