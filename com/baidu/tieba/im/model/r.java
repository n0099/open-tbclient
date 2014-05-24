package com.baidu.tieba.im.model;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.b {
    private static boolean c;
    private final List<ImMessageCenterShowItemData> a = new LinkedList();
    private final List<ImMessageCenterShowItemData> b = new LinkedList();

    public static synchronized boolean a() {
        boolean z;
        synchronized (r.class) {
            z = c;
        }
        return z;
    }

    public static synchronized void a(boolean z) {
        synchronized (r.class) {
            c = z;
        }
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, com.baidu.tieba.im.a<Void> aVar) {
        if (imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(2))) {
                com.baidu.tbadk.core.sharedPref.b.a().b("is_show_validate", false);
                a(TbadkApplication.getCurrentAccount(), String.valueOf(2), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(3))) {
                com.baidu.tbadk.core.sharedPref.b.a().b("is_show_updates", false);
                a(TbadkApplication.getCurrentAccount(), String.valueOf(3), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(6))) {
                com.baidu.tbadk.core.sharedPref.b.a().b("is_show_live_notify", false);
                a(TbadkApplication.getCurrentAccount(), String.valueOf(6), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(1))) {
                a(TbadkApplication.getCurrentAccount(), imMessageCenterShowItemData.getFriendId(), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(5))) {
                b(aVar);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(4))) {
                a(TbadkApplication.getCurrentAccount(), imMessageCenterShowItemData.getFriendId(), aVar, true);
            }
        }
    }

    private void b(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tbadk.coreExtra.messageCenter.a.a().f();
        LinkedList<ImMessageCenterShowItemData> m = com.baidu.tieba.im.pushNotify.a.f().m();
        Iterator<ImMessageCenterShowItemData> it = m.iterator();
        while (it.hasNext()) {
            ImMessageCenterPojo a = com.baidu.tieba.im.b.j.a().a(it.next().getFriendId());
            if (a != null) {
                a.setIs_hidden(1);
            }
        }
        com.baidu.tieba.im.pushNotify.a.f().q();
        com.baidu.tieba.im.i.a(new s(this, m), new t(this, aVar));
    }

    private void a(String str, String str2, com.baidu.tieba.im.a<Void> aVar, boolean z) {
        ImMessageCenterPojo a;
        if (z) {
            a = com.baidu.tieba.im.b.k.a().a(str2);
        } else {
            a = com.baidu.tieba.im.b.a.a().a(str2);
        }
        if (a != null) {
            a.setIs_hidden(1);
        }
        com.baidu.tieba.im.i.a(new u(this, z, str2), new v(this, str2, aVar));
    }

    public List<ImMessageCenterShowItemData> b() {
        return this.a;
    }

    public void c() {
        this.a.clear();
        this.b.clear();
    }

    public static void a(String str) {
        com.baidu.tieba.im.pushNotify.a.f().b(false, (com.baidu.tieba.im.a<Void>) null);
    }

    public static void b(String str) {
        ImMessageCenterPojo a = com.baidu.tieba.im.b.k.a().a(str);
        if (a != null) {
            a.setUnread_count(0);
        }
    }

    public void a(com.baidu.tieba.im.a<Void> aVar) {
        c(aVar);
    }

    private void c(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.pushNotify.a.f().b(false, (com.baidu.tieba.im.a<Void>) new w(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        this.a.clear();
        if (this.b != null) {
            this.a.addAll(this.b);
        }
        if (com.baidu.tieba.im.pushNotify.a.f().r()) {
            ImMessageCenterShowItemData k = com.baidu.tieba.im.pushNotify.a.f().k();
            if (k != null) {
                this.a.add(k);
            } else {
                com.baidu.tieba.im.pushNotify.a.e();
                ImMessageCenterShowItemData k2 = com.baidu.tieba.im.pushNotify.a.f().k();
                if (k2 != null) {
                    this.a.add(k2);
                }
            }
        }
        if (com.baidu.tieba.im.pushNotify.a.f().s()) {
            ImMessageCenterShowItemData n = com.baidu.tieba.im.pushNotify.a.f().n();
            if (n != null) {
                this.a.add(n);
            } else {
                com.baidu.tieba.im.pushNotify.a.a((String) null, false);
                ImMessageCenterShowItemData n2 = com.baidu.tieba.im.pushNotify.a.f().n();
                if (n2 != null) {
                    this.a.add(n2);
                }
            }
        }
        if (com.baidu.tieba.im.pushNotify.a.f().t()) {
            ImMessageCenterShowItemData o = com.baidu.tieba.im.pushNotify.a.f().o();
            if (o != null) {
                this.a.add(o);
            } else {
                com.baidu.tieba.im.pushNotify.a.a((String) null);
                ImMessageCenterShowItemData o2 = com.baidu.tieba.im.pushNotify.a.f().o();
                if (o2 != null) {
                    this.a.add(o2);
                }
            }
        }
        ImMessageCenterShowItemData p = com.baidu.tieba.im.pushNotify.a.f().p();
        if (p != null) {
            this.a.add(p);
        }
        Collections.sort(this.a, new x(this));
    }
}
