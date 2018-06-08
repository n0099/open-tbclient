package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a bmK;
    private List<InterfaceC0131a> bmL = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> bmM;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0131a {
        void V(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a QL() {
        a aVar;
        synchronized (a.class) {
            if (bmK == null) {
                bmK = new a();
            }
            aVar = bmK;
        }
        return aVar;
    }

    public void a(InterfaceC0131a interfaceC0131a) {
        if (interfaceC0131a != null && !this.bmL.contains(interfaceC0131a)) {
            this.bmL.add(interfaceC0131a);
        }
    }

    public void b(InterfaceC0131a interfaceC0131a) {
        if (interfaceC0131a != null) {
            this.bmL.remove(interfaceC0131a);
        }
    }

    public void W(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bmM = list;
        if (this.bmM != null) {
            Collections.sort(this.bmM, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.bmM != null && aVar != null) {
            String Fh = aVar.Fh();
            if (TextUtils.isEmpty(Fh)) {
                Fh = "#";
                aVar.fT("#");
            }
            String str = Fh;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.bmM) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.Fh()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.fT(str);
                    this.bmM.add(aVar3);
                }
                this.bmM.add(aVar);
                Collections.sort(this.bmM, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aD(long j) {
        if (this.bmM != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.bmM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.Fh();
                    this.bmM.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bmM) {
                    if (str.equals(aVar.Fh())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.bmM.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> QM() {
        return this.bmM;
    }

    private void notifyObservers() {
        for (InterfaceC0131a interfaceC0131a : this.bmL) {
            interfaceC0131a.V(this.bmM);
        }
    }
}
