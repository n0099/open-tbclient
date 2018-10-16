package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a byK;
    private List<InterfaceC0154a> byL = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> byM;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0154a {
        void af(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a Ve() {
        a aVar;
        synchronized (a.class) {
            if (byK == null) {
                byK = new a();
            }
            aVar = byK;
        }
        return aVar;
    }

    public void a(InterfaceC0154a interfaceC0154a) {
        if (interfaceC0154a != null && !this.byL.contains(interfaceC0154a)) {
            this.byL.add(interfaceC0154a);
        }
    }

    public void b(InterfaceC0154a interfaceC0154a) {
        if (interfaceC0154a != null) {
            this.byL.remove(interfaceC0154a);
        }
    }

    public void ag(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.byM = list;
        if (this.byM != null) {
            Collections.sort(this.byM, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.byM != null && aVar != null) {
            String IM = aVar.IM();
            if (TextUtils.isEmpty(IM)) {
                IM = "#";
                aVar.gG("#");
            }
            String str = IM;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.byM) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.IM()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.gG(str);
                    this.byM.add(aVar3);
                }
                this.byM.add(aVar);
                Collections.sort(this.byM, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aN(long j) {
        if (this.byM != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.byM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.IM();
                    this.byM.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.byM) {
                    if (str.equals(aVar.IM())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.byM.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Vf() {
        return this.byM;
    }

    private void notifyObservers() {
        for (InterfaceC0154a interfaceC0154a : this.byL) {
            interfaceC0154a.af(this.byM);
        }
    }
}
