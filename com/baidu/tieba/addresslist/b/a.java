package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a bDJ;
    private List<InterfaceC0188a> bDK = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> bDL;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0188a {
        void af(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a WS() {
        a aVar;
        synchronized (a.class) {
            if (bDJ == null) {
                bDJ = new a();
            }
            aVar = bDJ;
        }
        return aVar;
    }

    public void a(InterfaceC0188a interfaceC0188a) {
        if (interfaceC0188a != null && !this.bDK.contains(interfaceC0188a)) {
            this.bDK.add(interfaceC0188a);
        }
    }

    public void b(InterfaceC0188a interfaceC0188a) {
        if (interfaceC0188a != null) {
            this.bDK.remove(interfaceC0188a);
        }
    }

    public void ag(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bDL = list;
        if (this.bDL != null) {
            Collections.sort(this.bDL, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.bDL != null && aVar != null) {
            String Ks = aVar.Ks();
            if (TextUtils.isEmpty(Ks)) {
                Ks = "#";
                aVar.hn("#");
            }
            String str = Ks;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.bDL) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.Ks()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.hn(str);
                    this.bDL.add(aVar3);
                }
                this.bDL.add(aVar);
                Collections.sort(this.bDL, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aX(long j) {
        if (this.bDL != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.bDL.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.Ks();
                    this.bDL.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bDL) {
                    if (str.equals(aVar.Ks())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.bDL.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> WT() {
        return this.bDL;
    }

    private void notifyObservers() {
        for (InterfaceC0188a interfaceC0188a : this.bDK) {
            interfaceC0188a.af(this.bDL);
        }
    }
}
