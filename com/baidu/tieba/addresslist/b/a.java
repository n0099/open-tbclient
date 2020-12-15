package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private static a gbM;
    private List<com.baidu.tbadk.coreExtra.relationship.a> gbN;
    private List<InterfaceC0622a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0622a {
        void bS(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bMQ() {
        a aVar;
        synchronized (a.class) {
            if (gbM == null) {
                gbM = new a();
            }
            aVar = gbM;
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
        this.gbN = list;
        if (this.gbN != null) {
            Collections.sort(this.gbN, new ContactComparator());
        }
        bMS();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.gbN != null && aVar != null) {
            String bAg = aVar.bAg();
            if (TextUtils.isEmpty(bAg)) {
                bAg = "#";
                aVar.Df("#");
            }
            String str = bAg;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.gbN) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.bAg()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.Df(str);
                    this.gbN.add(aVar3);
                }
                this.gbN.add(aVar);
                Collections.sort(this.gbN, new ContactComparator());
                bMS();
            }
        }
    }

    public void eM(long j) {
        if (this.gbN != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.gbN.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.bAg();
                    this.gbN.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.gbN) {
                    if (str.equals(aVar.bAg())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.gbN.removeAll(arrayList);
                }
            }
            bMS();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bMR() {
        return this.gbN;
    }

    private void bMS() {
        for (InterfaceC0622a interfaceC0622a : this.mObservers) {
            interfaceC0622a.bS(this.gbN);
        }
    }
}
