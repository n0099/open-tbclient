package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    private static a feO;
    private List<com.baidu.tbadk.coreExtra.relationship.a> feP;
    private List<InterfaceC0525a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0525a {
        void bq(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bsA() {
        a aVar;
        synchronized (a.class) {
            if (feO == null) {
                feO = new a();
            }
            aVar = feO;
        }
        return aVar;
    }

    public void a(InterfaceC0525a interfaceC0525a) {
        if (interfaceC0525a != null && !this.mObservers.contains(interfaceC0525a)) {
            this.mObservers.add(interfaceC0525a);
        }
    }

    public void b(InterfaceC0525a interfaceC0525a) {
        if (interfaceC0525a != null) {
            this.mObservers.remove(interfaceC0525a);
        }
    }

    public void br(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.feP = list;
        if (this.feP != null) {
            Collections.sort(this.feP, new ContactComparator());
        }
        bsC();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.feP != null && aVar != null) {
            String bgI = aVar.bgI();
            if (TextUtils.isEmpty(bgI)) {
                bgI = "#";
                aVar.yS("#");
            }
            String str = bgI;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.feP) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.bgI()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.yS(str);
                    this.feP.add(aVar3);
                }
                this.feP.add(aVar);
                Collections.sort(this.feP, new ContactComparator());
                bsC();
            }
        }
    }

    public void dq(long j) {
        if (this.feP != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.feP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.bgI();
                    this.feP.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.feP) {
                    if (str.equals(aVar.bgI())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.feP.removeAll(arrayList);
                }
            }
            bsC();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bsB() {
        return this.feP;
    }

    private void bsC() {
        for (InterfaceC0525a interfaceC0525a : this.mObservers) {
            interfaceC0525a.bq(this.feP);
        }
    }
}
