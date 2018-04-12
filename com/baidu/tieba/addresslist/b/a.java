package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a beB;
    private List<InterfaceC0115a> beC = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> beD;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0115a {
        void S(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a Nn() {
        a aVar;
        synchronized (a.class) {
            if (beB == null) {
                beB = new a();
            }
            aVar = beB;
        }
        return aVar;
    }

    public void a(InterfaceC0115a interfaceC0115a) {
        if (interfaceC0115a != null && !this.beC.contains(interfaceC0115a)) {
            this.beC.add(interfaceC0115a);
        }
    }

    public void b(InterfaceC0115a interfaceC0115a) {
        if (interfaceC0115a != null) {
            this.beC.remove(interfaceC0115a);
        }
    }

    public void T(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.beD = list;
        if (this.beD != null) {
            Collections.sort(this.beD, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.beD != null && aVar != null) {
            String BI = aVar.BI();
            if (TextUtils.isEmpty(BI)) {
                BI = "#";
                aVar.fw("#");
            }
            String str = BI;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.beD) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.BI()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.fw(str);
                    this.beD.add(aVar3);
                }
                this.beD.add(aVar);
                Collections.sort(this.beD, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void az(long j) {
        if (this.beD != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.beD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.BI();
                    this.beD.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.beD) {
                    if (str.equals(aVar.BI())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.beD.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> No() {
        return this.beD;
    }

    private void notifyObservers() {
        for (InterfaceC0115a interfaceC0115a : this.beC) {
            interfaceC0115a.S(this.beD);
        }
    }
}
