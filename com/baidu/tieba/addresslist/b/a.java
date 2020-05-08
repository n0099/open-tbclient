package com.baidu.tieba.addresslist.b;

import android.text.TextUtils;
import com.baidu.tieba.addresslist.relationship.ContactComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private static a eBr;
    private List<com.baidu.tbadk.coreExtra.relationship.a> eBs;
    private List<InterfaceC0460a> mObservers = new ArrayList();

    /* renamed from: com.baidu.tieba.addresslist.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0460a {
        void bh(List<com.baidu.tbadk.coreExtra.relationship.a> list);
    }

    private a() {
    }

    public static synchronized a bgK() {
        a aVar;
        synchronized (a.class) {
            if (eBr == null) {
                eBr = new a();
            }
            aVar = eBr;
        }
        return aVar;
    }

    public void a(InterfaceC0460a interfaceC0460a) {
        if (interfaceC0460a != null && !this.mObservers.contains(interfaceC0460a)) {
            this.mObservers.add(interfaceC0460a);
        }
    }

    public void b(InterfaceC0460a interfaceC0460a) {
        if (interfaceC0460a != null) {
            this.mObservers.remove(interfaceC0460a);
        }
    }

    public void bi(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.eBs = list;
        if (this.eBs != null) {
            Collections.sort(this.eBs, new ContactComparator());
        }
        bgM();
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        boolean z = false;
        if (this.eBs != null && aVar != null) {
            String aUO = aVar.aUO();
            if (TextUtils.isEmpty(aUO)) {
                aUO = "#";
                aVar.vN("#");
            }
            String str = aUO;
            String userName = aVar.getUserName();
            String str2 = userName == null ? "" : userName;
            boolean z2 = false;
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : this.eBs) {
                if (str2.equals(aVar2.getUserName())) {
                    z = true;
                }
                z2 = str.equals(aVar2.aUO()) ? true : z2;
            }
            if (!z) {
                if (!z2) {
                    com.baidu.tbadk.coreExtra.relationship.a aVar3 = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar3.vN(str);
                    this.eBs.add(aVar3);
                }
                this.eBs.add(aVar);
                Collections.sort(this.eBs, new ContactComparator());
                bgM();
            }
        }
    }

    public void cY(long j) {
        if (this.eBs != null) {
            String str = null;
            Iterator<com.baidu.tbadk.coreExtra.relationship.a> it = this.eBs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.coreExtra.relationship.a next = it.next();
                if (next.getUserId() == j) {
                    str = next.aUO();
                    this.eBs.remove(next);
                    break;
                }
            }
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : this.eBs) {
                    if (str.equals(aVar.aUO())) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    this.eBs.removeAll(arrayList);
                }
            }
            bgM();
        }
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bgL() {
        return this.eBs;
    }

    private void bgM() {
        for (InterfaceC0460a interfaceC0460a : this.mObservers) {
            interfaceC0460a.bh(this.eBs);
        }
    }
}
