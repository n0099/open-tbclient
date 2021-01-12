package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private static a ggv;
    private List<com.baidu.tbadk.coreExtra.relationship.a> ggw;
    private List<InterfaceC0596a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0596a {
        void bZ(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bLr() {
        a aVar;
        synchronized (a.class) {
            if (ggv == null) {
                ggv = new a();
            }
            aVar = ggv;
        }
        return aVar;
    }

    public void a(InterfaceC0596a interfaceC0596a) {
        if (interfaceC0596a != null && !this.mObservers.contains(interfaceC0596a)) {
            this.mObservers.add(interfaceC0596a);
        }
    }

    public void b(InterfaceC0596a interfaceC0596a) {
        if (interfaceC0596a != null) {
            this.mObservers.remove(interfaceC0596a);
        }
    }

    public void ca(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.ggw = list;
        if (this.ggw != null) {
            Collections.sort(this.ggw, new ContactComparator());
        }
        bLt();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z;
        boolean z2 = false;
        if (this.ggw != null && aVar != null) {
            String byH = aVar.byH();
            if (TextUtils.isEmpty(byH)) {
                byH = "#";
                aVar.BR("#");
            }
            String str = byH;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.ggw.iterator();
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
                z2 = str.equals(next.byH()) ? true : z;
            }
            if (!z3) {
                if (!z) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar2.BR(str);
                    this.ggw.add(aVar2);
                }
                this.ggw.add(aVar);
                Collections.sort(this.ggw, new ContactComparator());
                bLt();
            }
        }
    }

    public void eM(long j) {
        if (this.ggw != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.ggw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.byH();
                    this.ggw.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.ggw) {
                    if (str.equals(aVar.byH())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.ggw.removeAll(arrayList);
                }
            }
            bLt();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bLs() {
        return this.ggw;
    }

    private void bLt() {
        for (InterfaceC0596a interfaceC0596a : this.mObservers) {
            interfaceC0596a.bZ(this.ggw);
        }
    }
}
