package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a aIn;
    private List<InterfaceC0059a> aIo = new ArrayList();
    private List<com.baidu.tbadk.coreExtra.relationship.a> aIp;

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void v(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a Hi() {
        a aVar;
        synchronized (a.class) {
            if (aIn == null) {
                aIn = new a();
            }
            aVar = aIn;
        }
        return aVar;
    }

    public void a(InterfaceC0059a interfaceC0059a) {
        if (interfaceC0059a != null && !this.aIo.contains(interfaceC0059a)) {
            this.aIo.add(interfaceC0059a);
        }
    }

    public void b(InterfaceC0059a interfaceC0059a) {
        if (interfaceC0059a != null) {
            this.aIo.remove(interfaceC0059a);
        }
    }

    public void w(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aIp = list;
        if (this.aIp != null) {
            Collections.sort(this.aIp, new ContactComparator());
        }
        notifyObservers();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.aIp != null && aVar != null) {
            String zv = aVar.zv();
            if (TextUtils.isEmpty(zv)) {
                zv = "#";
                aVar.ew("#");
            }
            String str = zv;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.aIp) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                if (str.equals(aVar2.zv())) {
                    z2 = true;
                }
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.ew(str);
                    this.aIp.add(aVar3);
                }
                this.aIp.add(aVar);
                Collections.sort(this.aIp, new ContactComparator());
                notifyObservers();
            }
        }
    }

    public void ag(long j) {
        if (this.aIp != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.aIp.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.zv();
                    this.aIp.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.aIp) {
                    if (str.equals(aVar.zv())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.aIp.removeAll(arrayList);
                }
            }
            notifyObservers();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Hj() {
        return this.aIp;
    }

    private void notifyObservers() {
        for (InterfaceC0059a interfaceC0059a : this.aIo) {
            interfaceC0059a.v(this.aIp);
        }
    }
}
