package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    private static a dWI;
    private List<com.baidu.tbadk.coreExtra.relationship.a> dWJ;
    private List<InterfaceC0395a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0395a {
        void aY(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a aVT() {
        a aVar;
        synchronized (a.class) {
            if (dWI == null) {
                dWI = new a();
            }
            aVar = dWI;
        }
        return aVar;
    }

    public void a(InterfaceC0395a interfaceC0395a) {
        if (interfaceC0395a != null && !this.mObservers.contains(interfaceC0395a)) {
            this.mObservers.add(interfaceC0395a);
        }
    }

    public void b(InterfaceC0395a interfaceC0395a) {
        if (interfaceC0395a != null) {
            this.mObservers.remove(interfaceC0395a);
        }
    }

    public void aZ(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dWJ = list;
        if (this.dWJ != null) {
            Collections.sort(this.dWJ, new ContactComparator());
        }
        aVV();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.dWJ != null && aVar != null) {
            String aJy = aVar.aJy();
            if (TextUtils.isEmpty(aJy)) {
                aJy = "#";
                aVar.tZ("#");
            }
            String str = aJy;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.dWJ) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.aJy()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.tZ(str);
                    this.dWJ.add(aVar3);
                }
                this.dWJ.add(aVar);
                Collections.sort(this.dWJ, new ContactComparator());
                aVV();
            }
        }
    }

    public void ci(long j) {
        if (this.dWJ != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.dWJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.aJy();
                    this.dWJ.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.dWJ) {
                    if (str.equals(aVar.aJy())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.dWJ.removeAll(arrayList);
                }
            }
            aVV();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aVU() {
        return this.dWJ;
    }

    private void aVV() {
        for (InterfaceC0395a interfaceC0395a : this.mObservers) {
            interfaceC0395a.aY(this.dWJ);
        }
    }
}
