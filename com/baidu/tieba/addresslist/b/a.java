package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static a ebj;
    private List<com.baidu.tbadk.coreExtra.relationship.a> ebk;
    private List<InterfaceC0408a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0408a {
        void aX(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a aYE() {
        a aVar;
        synchronized (a.class) {
            if (ebj == null) {
                ebj = new a();
            }
            aVar = ebj;
        }
        return aVar;
    }

    public void a(InterfaceC0408a interfaceC0408a) {
        if (interfaceC0408a != null && !this.mObservers.contains(interfaceC0408a)) {
            this.mObservers.add(interfaceC0408a);
        }
    }

    public void b(InterfaceC0408a interfaceC0408a) {
        if (interfaceC0408a != null) {
            this.mObservers.remove(interfaceC0408a);
        }
    }

    public void aY(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ebk = list;
        if (this.ebk != null) {
            Collections.sort(this.ebk, new ContactComparator());
        }
        aYG();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.ebk != null && aVar != null) {
            String aMp = aVar.aMp();
            if (TextUtils.isEmpty(aMp)) {
                aMp = "#";
                aVar.uw("#");
            }
            String str = aMp;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.ebk) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.aMp()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.uw(str);
                    this.ebk.add(aVar3);
                }
                this.ebk.add(aVar);
                Collections.sort(this.ebk, new ContactComparator());
                aYG();
            }
        }
    }

    public void cr(long j) {
        if (this.ebk != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.ebk.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.aMp();
                    this.ebk.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.ebk) {
                    if (str.equals(aVar.aMp())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.ebk.removeAll(arrayList);
                }
            }
            aYG();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aYF() {
        return this.ebk;
    }

    private void aYG() {
        for (InterfaceC0408a interfaceC0408a : this.mObservers) {
            interfaceC0408a.aX(this.ebk);
        }
    }
}
