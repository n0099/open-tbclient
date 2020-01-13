package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static a dWR;
    private List<com.baidu.tbadk.coreExtra.relationship.a> dWS;
    private List<InterfaceC0397a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0397a {
        void aX(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a aWm() {
        a aVar;
        synchronized (a.class) {
            if (dWR == null) {
                dWR = new a();
            }
            aVar = dWR;
        }
        return aVar;
    }

    public void a(InterfaceC0397a interfaceC0397a) {
        if (interfaceC0397a != null && !this.mObservers.contains(interfaceC0397a)) {
            this.mObservers.add(interfaceC0397a);
        }
    }

    public void b(InterfaceC0397a interfaceC0397a) {
        if (interfaceC0397a != null) {
            this.mObservers.remove(interfaceC0397a);
        }
    }

    public void aY(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dWS = list;
        if (this.dWS != null) {
            Collections.sort(this.dWS, new ContactComparator());
        }
        aWo();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.dWS != null && aVar != null) {
            String aJS = aVar.aJS();
            if (TextUtils.isEmpty(aJS)) {
                aJS = "#";
                aVar.ue("#");
            }
            String str = aJS;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.dWS) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.aJS()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.ue(str);
                    this.dWS.add(aVar3);
                }
                this.dWS.add(aVar);
                Collections.sort(this.dWS, new ContactComparator());
                aWo();
            }
        }
    }

    public void cn(long j) {
        if (this.dWS != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.dWS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.aJS();
                    this.dWS.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.dWS) {
                    if (str.equals(aVar.aJS())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.dWS.removeAll(arrayList);
                }
            }
            aWo();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aWn() {
        return this.dWS;
    }

    private void aWo() {
        for (InterfaceC0397a interfaceC0397a : this.mObservers) {
            interfaceC0397a.aX(this.dWS);
        }
    }
}
