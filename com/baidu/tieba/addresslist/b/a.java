package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a bDI;
    private List<InterfaceC0188a> bDJ = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> bDK;

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
            if (bDI == null) {
                bDI = new a();
            }
            aVar = bDI;
        }
        return aVar;
    }

    public void a(InterfaceC0188a interfaceC0188a) {
        if (interfaceC0188a != null && !this.bDJ.contains(interfaceC0188a)) {
            this.bDJ.add(interfaceC0188a);
        }
    }

    public void b(InterfaceC0188a interfaceC0188a) {
        if (interfaceC0188a != null) {
            this.bDJ.remove(interfaceC0188a);
        }
    }

    public void ag(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bDK = list;
        if (this.bDK != null) {
            Collections.sort(this.bDK, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.bDK != null && aVar != null) {
            String Ks = aVar.Ks();
            if (TextUtils.isEmpty(Ks)) {
                Ks = "#";
                aVar.hn("#");
            }
            String str = Ks;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.bDK) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.Ks()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.hn(str);
                    this.bDK.add(aVar3);
                }
                this.bDK.add(aVar);
                Collections.sort(this.bDK, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aX(long j) {
        if (this.bDK != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.bDK.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.Ks();
                    this.bDK.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bDK) {
                    if (str.equals(aVar.Ks())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.bDK.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> WT() {
        return this.bDK;
    }

    private void notifyObservers() {
        for (InterfaceC0188a interfaceC0188a : this.bDJ) {
            interfaceC0188a.af(this.bDK);
        }
    }
}
