package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private static a fFI;
    private List<com.baidu.tbadk.coreExtra.relationship.a> fFJ;
    private List<InterfaceC0584a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0584a {
        void by(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bFw() {
        a aVar;
        synchronized (a.class) {
            if (fFI == null) {
                fFI = new a();
            }
            aVar = fFI;
        }
        return aVar;
    }

    public void a(InterfaceC0584a interfaceC0584a) {
        if (interfaceC0584a != null && !this.mObservers.contains(interfaceC0584a)) {
            this.mObservers.add(interfaceC0584a);
        }
    }

    public void b(InterfaceC0584a interfaceC0584a) {
        if (interfaceC0584a != null) {
            this.mObservers.remove(interfaceC0584a);
        }
    }

    public void bz(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fFJ = list;
        if (this.fFJ != null) {
            Collections.sort(this.fFJ, new ContactComparator());
        }
        bFy();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.fFJ != null && aVar != null) {
            String bsY = aVar.bsY();
            if (TextUtils.isEmpty(bsY)) {
                bsY = "#";
                aVar.Cr("#");
            }
            String str = bsY;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.fFJ) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.bsY()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.Cr(str);
                    this.fFJ.add(aVar3);
                }
                this.fFJ.add(aVar);
                Collections.sort(this.fFJ, new ContactComparator());
                bFy();
            }
        }
    }

    public void dL(long j) {
        if (this.fFJ != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.fFJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.bsY();
                    this.fFJ.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.fFJ) {
                    if (str.equals(aVar.bsY())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.fFJ.removeAll(arrayList);
                }
            }
            bFy();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bFx() {
        return this.fFJ;
    }

    private void bFy() {
        for (InterfaceC0584a interfaceC0584a : this.mObservers) {
            interfaceC0584a.by(this.fFJ);
        }
    }
}
