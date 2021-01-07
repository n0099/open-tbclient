package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static a gld;
    private List<com.baidu.tbadk.coreExtra.relationship.a> gle;
    private List<InterfaceC0613a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0613a {
        void bZ(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bPj() {
        a aVar;
        synchronized (a.class) {
            if (gld == null) {
                gld = new a();
            }
            aVar = gld;
        }
        return aVar;
    }

    public void a(InterfaceC0613a interfaceC0613a) {
        if (interfaceC0613a != null && !this.mObservers.contains(interfaceC0613a)) {
            this.mObservers.add(interfaceC0613a);
        }
    }

    public void b(InterfaceC0613a interfaceC0613a) {
        if (interfaceC0613a != null) {
            this.mObservers.remove(interfaceC0613a);
        }
    }

    public void ca(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.gle = list;
        if (this.gle != null) {
            Collections.sort(this.gle, new ContactComparator());
        }
        bPl();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z;
        boolean z2 = false;
        if (this.gle != null && aVar != null) {
            String bCB = aVar.bCB();
            if (TextUtils.isEmpty(bCB)) {
                bCB = "#";
                aVar.Dc("#");
            }
            String str = bCB;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.gle.iterator();
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
                z2 = str.equals(next.bCB()) ? true : z;
            }
            if (!z3) {
                if (!z) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar2.Dc(str);
                    this.gle.add(aVar2);
                }
                this.gle.add(aVar);
                Collections.sort(this.gle, new ContactComparator());
                bPl();
            }
        }
    }

    public void eM(long j) {
        if (this.gle != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.gle.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.bCB();
                    this.gle.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.gle) {
                    if (str.equals(aVar.bCB())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.gle.removeAll(arrayList);
                }
            }
            bPl();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bPk() {
        return this.gle;
    }

    private void bPl() {
        for (InterfaceC0613a interfaceC0613a : this.mObservers) {
            interfaceC0613a.bZ(this.gle);
        }
    }
}
