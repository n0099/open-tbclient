package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes20.dex */
public class a {
    private static a ftz;
    private List<com.baidu.tbadk.coreExtra.relationship.a> ftA;
    private List<InterfaceC0567a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0567a {
        void bv(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bCK() {
        a aVar;
        synchronized (a.class) {
            if (ftz == null) {
                ftz = new a();
            }
            aVar = ftz;
        }
        return aVar;
    }

    public void a(InterfaceC0567a interfaceC0567a) {
        if (interfaceC0567a != null && !this.mObservers.contains(interfaceC0567a)) {
            this.mObservers.add(interfaceC0567a);
        }
    }

    public void b(InterfaceC0567a interfaceC0567a) {
        if (interfaceC0567a != null) {
            this.mObservers.remove(interfaceC0567a);
        }
    }

    public void bw(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ftA = list;
        if (this.ftA != null) {
            Collections.sort(this.ftA, new ContactComparator());
        }
        bCM();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.ftA != null && aVar != null) {
            String bqo = aVar.bqo();
            if (TextUtils.isEmpty(bqo)) {
                bqo = "#";
                aVar.BF("#");
            }
            String str = bqo;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.ftA) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.bqo()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.BF(str);
                    this.ftA.add(aVar3);
                }
                this.ftA.add(aVar);
                Collections.sort(this.ftA, new ContactComparator());
                bCM();
            }
        }
    }

    public void dC(long j) {
        if (this.ftA != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.ftA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.bqo();
                    this.ftA.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.ftA) {
                    if (str.equals(aVar.bqo())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.ftA.removeAll(arrayList);
                }
            }
            bCM();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bCL() {
        return this.ftA;
    }

    private void bCM() {
        for (InterfaceC0567a interfaceC0567a : this.mObservers) {
            interfaceC0567a.bv(this.ftA);
        }
    }
}
