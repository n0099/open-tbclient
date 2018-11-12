package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static a bzv;
    private List<InterfaceC0178a> bzw = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> bzx;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0178a {
        void ae(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a Vn() {
        a aVar;
        synchronized (a.class) {
            if (bzv == null) {
                bzv = new a();
            }
            aVar = bzv;
        }
        return aVar;
    }

    public void a(InterfaceC0178a interfaceC0178a) {
        if (interfaceC0178a != null && !this.bzw.contains(interfaceC0178a)) {
            this.bzw.add(interfaceC0178a);
        }
    }

    public void b(InterfaceC0178a interfaceC0178a) {
        if (interfaceC0178a != null) {
            this.bzw.remove(interfaceC0178a);
        }
    }

    public void af(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bzx = list;
        if (this.bzx != null) {
            Collections.sort(this.bzx, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.bzx != null && aVar != null) {
            String IY = aVar.IY();
            if (TextUtils.isEmpty(IY)) {
                IY = "#";
                aVar.gH("#");
            }
            String str = IY;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.bzx) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.IY()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.gH(str);
                    this.bzx.add(aVar3);
                }
                this.bzx.add(aVar);
                Collections.sort(this.bzx, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void aP(long j) {
        if (this.bzx != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.bzx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.IY();
                    this.bzx.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.bzx) {
                    if (str.equals(aVar.IY())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.bzx.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Vo() {
        return this.bzx;
    }

    private void notifyObservers() {
        for (InterfaceC0178a interfaceC0178a : this.bzw) {
            interfaceC0178a.ae(this.bzx);
        }
    }
}
