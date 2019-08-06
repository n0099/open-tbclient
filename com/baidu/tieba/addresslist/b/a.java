package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a cYG;
    private List<InterfaceC0273a> cYH = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> cYI;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0273a {
        void az(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a aDp() {
        a aVar;
        synchronized (a.class) {
            if (cYG == null) {
                cYG = new a();
            }
            aVar = cYG;
        }
        return aVar;
    }

    public void a(InterfaceC0273a interfaceC0273a) {
        if (interfaceC0273a != null && !this.cYH.contains(interfaceC0273a)) {
            this.cYH.add(interfaceC0273a);
        }
    }

    public void b(InterfaceC0273a interfaceC0273a) {
        if (interfaceC0273a != null) {
            this.cYH.remove(interfaceC0273a);
        }
    }

    public void aA(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cYI = list;
        if (this.cYI != null) {
            Collections.sort(this.cYI, new ContactComparator());
        }
        aDr();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.cYI != null && aVar != null) {
            String apV = aVar.apV();
            if (TextUtils.isEmpty(apV)) {
                apV = "#";
                aVar.pA("#");
            }
            String str = apV;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.cYI) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.apV()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.pA(str);
                    this.cYI.add(aVar3);
                }
                this.cYI.add(aVar);
                Collections.sort(this.cYI, new ContactComparator());
                aDr();
            }
        }
    }

    public void bP(long j) {
        if (this.cYI != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.cYI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.apV();
                    this.cYI.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.cYI) {
                    if (str.equals(aVar.apV())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.cYI.removeAll(arrayList);
                }
            }
            aDr();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aDq() {
        return this.cYI;
    }

    private void aDr() {
        for (InterfaceC0273a interfaceC0273a : this.cYH) {
            interfaceC0273a.az(this.cYI);
        }
    }
}
