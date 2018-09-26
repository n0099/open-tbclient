package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a buH;
    private List<InterfaceC0130a> buI = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> buJ;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0130a {
        void W(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a Ti() {
        a aVar;
        synchronized (a.class) {
            if (buH == null) {
                buH = new a();
            }
            aVar = buH;
        }
        return aVar;
    }

    public void a(InterfaceC0130a interfaceC0130a) {
        if (interfaceC0130a != null && !this.buI.contains(interfaceC0130a)) {
            this.buI.add(interfaceC0130a);
        }
    }

    public void b(InterfaceC0130a interfaceC0130a) {
        if (interfaceC0130a != null) {
            this.buI.remove(interfaceC0130a);
        }
    }

    public void X(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.buJ = list;
        if (this.buJ != null) {
            Collections.sort(this.buJ, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.buJ != null && aVar != null) {
            String GL = aVar.GL();
            if (TextUtils.isEmpty(GL)) {
                GL = "#";
                aVar.gr("#");
            }
            String str = GL;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.buJ) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.GL()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.gr(str);
                    this.buJ.add(aVar3);
                }
                this.buJ.add(aVar);
                Collections.sort(this.buJ, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aL(long j) {
        if (this.buJ != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.buJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.GL();
                    this.buJ.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.buJ) {
                    if (str.equals(aVar.GL())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.buJ.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Tj() {
        return this.buJ;
    }

    private void notifyObservers() {
        for (InterfaceC0130a interfaceC0130a : this.buI) {
            interfaceC0130a.W(this.buJ);
        }
    }
}
