package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a beC;
    private List<InterfaceC0115a> beD = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> beE;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0115a {
        void S(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a Nl() {
        a aVar;
        synchronized (a.class) {
            if (beC == null) {
                beC = new a();
            }
            aVar = beC;
        }
        return aVar;
    }

    public void a(InterfaceC0115a interfaceC0115a) {
        if (interfaceC0115a != null && !this.beD.contains(interfaceC0115a)) {
            this.beD.add(interfaceC0115a);
        }
    }

    public void b(InterfaceC0115a interfaceC0115a) {
        if (interfaceC0115a != null) {
            this.beD.remove(interfaceC0115a);
        }
    }

    public void T(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.beE = list;
        if (this.beE != null) {
            Collections.sort(this.beE, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.beE != null && aVar != null) {
            String BG = aVar.BG();
            if (TextUtils.isEmpty(BG)) {
                BG = "#";
                aVar.fw("#");
            }
            String str = BG;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.beE) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.BG()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.fw(str);
                    this.beE.add(aVar3);
                }
                this.beE.add(aVar);
                Collections.sort(this.beE, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void az(long j) {
        if (this.beE != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.beE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.BG();
                    this.beE.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.beE) {
                    if (str.equals(aVar.BG())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.beE.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Nm() {
        return this.beE;
    }

    private void notifyObservers() {
        for (InterfaceC0115a interfaceC0115a : this.beD) {
            interfaceC0115a.S(this.beE);
        }
    }
}
