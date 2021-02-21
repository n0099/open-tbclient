package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static a giZ;
    private List<com.baidu.tbadk.coreExtra.relationship.a> gja;
    private List<InterfaceC0594a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0594a {
        void bU(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bLS() {
        a aVar;
        synchronized (a.class) {
            if (giZ == null) {
                giZ = new a();
            }
            aVar = giZ;
        }
        return aVar;
    }

    public void a(InterfaceC0594a interfaceC0594a) {
        if (interfaceC0594a != null && !this.mObservers.contains(interfaceC0594a)) {
            this.mObservers.add(interfaceC0594a);
        }
    }

    public void b(InterfaceC0594a interfaceC0594a) {
        if (interfaceC0594a != null) {
            this.mObservers.remove(interfaceC0594a);
        }
    }

    public void bV(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gja = list;
        if (this.gja != null) {
            Collections.sort(this.gja, new ContactComparator());
        }
        bLU();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z;
        boolean z2 = false;
        if (this.gja != null && aVar != null) {
            String byZ = aVar.byZ();
            if (TextUtils.isEmpty(byZ)) {
                byZ = "#";
                aVar.Ci("#");
            }
            String str = byZ;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.gja.iterator();
            boolean z3 = false;
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (str2.equals(next.getUserName())) {
                    z3 = true;
                }
                z2 = str.equals(next.byZ()) ? true : z;
            }
            if (!z3) {
                if (!z) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar2.Ci(str);
                    this.gja.add(aVar2);
                }
                this.gja.add(aVar);
                Collections.sort(this.gja, new ContactComparator());
                bLU();
            }
        }
    }

    public void eS(long j) {
        if (this.gja != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.gja.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.byZ();
                    this.gja.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.gja) {
                    if (str.equals(aVar.byZ())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.gja.removeAll(arrayList);
                }
            }
            bLU();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bLT() {
        return this.gja;
    }

    private void bLU() {
        for (InterfaceC0594a interfaceC0594a : this.mObservers) {
            interfaceC0594a.bU(this.gja);
        }
    }
}
