package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static a giL;
    private List<com.baidu.tbadk.coreExtra.relationship.a> giM;
    private List<InterfaceC0593a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0593a {
        void bU(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bLL() {
        a aVar;
        synchronized (a.class) {
            if (giL == null) {
                giL = new a();
            }
            aVar = giL;
        }
        return aVar;
    }

    public void a(InterfaceC0593a interfaceC0593a) {
        if (interfaceC0593a != null && !this.mObservers.contains(interfaceC0593a)) {
            this.mObservers.add(interfaceC0593a);
        }
    }

    public void b(InterfaceC0593a interfaceC0593a) {
        if (interfaceC0593a != null) {
            this.mObservers.remove(interfaceC0593a);
        }
    }

    public void bV(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.giM = list;
        if (this.giM != null) {
            Collections.sort(this.giM, new ContactComparator());
        }
        bLN();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z;
        boolean z2 = false;
        if (this.giM != null && aVar != null) {
            String byZ = aVar.byZ();
            if (TextUtils.isEmpty(byZ)) {
                byZ = "#";
                aVar.Ci("#");
            }
            String str = byZ;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.giM.iterator();
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
                    this.giM.add(aVar2);
                }
                this.giM.add(aVar);
                Collections.sort(this.giM, new ContactComparator());
                bLN();
            }
        }
    }

    public void eS(long j) {
        if (this.giM != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.giM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.byZ();
                    this.giM.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.giM) {
                    if (str.equals(aVar.byZ())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.giM.removeAll(arrayList);
                }
            }
            bLN();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bLM() {
        return this.giM;
    }

    private void bLN() {
        for (InterfaceC0593a interfaceC0593a : this.mObservers) {
            interfaceC0593a.bU(this.giM);
        }
    }
}
