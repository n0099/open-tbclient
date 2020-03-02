package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static a eaW;
    private List<com.baidu.tbadk.coreExtra.relationship.a> eaX;
    private List<InterfaceC0408a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0408a {
        void aX(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a aYD() {
        a aVar;
        synchronized (a.class) {
            if (eaW == null) {
                eaW = new a();
            }
            aVar = eaW;
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
        this.eaX = list;
        if (this.eaX != null) {
            Collections.sort(this.eaX, new ContactComparator());
        }
        aYF();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.eaX != null && aVar != null) {
            String aMo = aVar.aMo();
            if (TextUtils.isEmpty(aMo)) {
                aMo = "#";
                aVar.uv("#");
            }
            String str = aMo;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.eaX) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.aMo()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.uv(str);
                    this.eaX.add(aVar3);
                }
                this.eaX.add(aVar);
                Collections.sort(this.eaX, new ContactComparator());
                aYF();
            }
        }
    }

    public void cr(long j) {
        if (this.eaX != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.eaX.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.aMo();
                    this.eaX.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.eaX) {
                    if (str.equals(aVar.aMo())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.eaX.removeAll(arrayList);
                }
            }
            aYF();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aYE() {
        return this.eaX;
    }

    private void aYF() {
        for (InterfaceC0408a interfaceC0408a : this.mObservers) {
            interfaceC0408a.aX(this.eaX);
        }
    }
}
