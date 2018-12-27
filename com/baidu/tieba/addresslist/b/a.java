package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a bCV;
    private List<InterfaceC0188a> bCW = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> bCX;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0188a {
        void ae(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a Wv() {
        a aVar;
        synchronized (a.class) {
            if (bCV == null) {
                bCV = new a();
            }
            aVar = bCV;
        }
        return aVar;
    }

    public void a(InterfaceC0188a interfaceC0188a) {
        if (interfaceC0188a != null && !this.bCW.contains(interfaceC0188a)) {
            this.bCW.add(interfaceC0188a);
        }
    }

    public void b(InterfaceC0188a interfaceC0188a) {
        if (interfaceC0188a != null) {
            this.bCW.remove(interfaceC0188a);
        }
    }

    public void af(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bCX = list;
        if (this.bCX != null) {
            Collections.sort(this.bCX, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.bCX != null && aVar != null) {
            String Kd = aVar.Kd();
            if (TextUtils.isEmpty(Kd)) {
                Kd = "#";
                aVar.ha("#");
            }
            String str = Kd;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.bCX) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.Kd()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.ha(str);
                    this.bCX.add(aVar3);
                }
                this.bCX.add(aVar);
                Collections.sort(this.bCX, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aX(long j) {
        if (this.bCX != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.bCX.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.Kd();
                    this.bCX.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bCX) {
                    if (str.equals(aVar.Kd())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.bCX.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Ww() {
        return this.bCX;
    }

    private void notifyObservers() {
        for (InterfaceC0188a interfaceC0188a : this.bCW) {
            interfaceC0188a.ae(this.bCX);
        }
    }
}
