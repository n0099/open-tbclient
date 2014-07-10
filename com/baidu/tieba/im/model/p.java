package com.baidu.tieba.im.model;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.e {
    private static boolean c;
    private static boolean d;
    private final List<ImMessageCenterShowItemData> a = new LinkedList();
    private final List<ImMessageCenterShowItemData> b = new LinkedList();

    public static synchronized boolean a() {
        boolean z;
        synchronized (p.class) {
            z = c;
        }
        return z;
    }

    public static synchronized void a(boolean z) {
        synchronized (p.class) {
            c = z;
        }
    }

    public static boolean b() {
        return d;
    }

    public static void b(boolean z) {
        d = z;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, com.baidu.tieba.im.a<Void> aVar) {
        if (imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(2))) {
                com.baidu.tbadk.core.sharedPref.b.a().c("is_show_validate", false);
                a(TbadkApplication.getCurrentAccount(), String.valueOf(2), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(3))) {
                com.baidu.tbadk.core.sharedPref.b.a().c("is_show_updates", false);
                a(TbadkApplication.getCurrentAccount(), String.valueOf(3), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(6))) {
                com.baidu.tbadk.core.sharedPref.b.a().c("is_show_live_notify", false);
                a(TbadkApplication.getCurrentAccount(), String.valueOf(6), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(1))) {
                a(TbadkApplication.getCurrentAccount(), imMessageCenterShowItemData.getFriendId(), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(5))) {
                b(aVar);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(4))) {
                a(TbadkApplication.getCurrentAccount(), imMessageCenterShowItemData.getFriendId(), aVar, true);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(7))) {
                c(aVar);
            }
        }
    }

    private void b(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tbadk.coreExtra.messageCenter.a.a().e();
        LinkedList<ImMessageCenterShowItemData> p = com.baidu.tieba.im.pushNotify.a.i().p();
        Iterator<ImMessageCenterShowItemData> it = p.iterator();
        while (it.hasNext()) {
            ImMessageCenterPojo a = com.baidu.tieba.im.b.j.a().a(it.next().getFriendId());
            if (a != null) {
                a.setIs_hidden(1);
            }
        }
        com.baidu.tieba.im.pushNotify.a.i().u();
        com.baidu.tieba.im.i.a(new q(this, p), new r(this, aVar));
    }

    private void c(com.baidu.tieba.im.a<Void> aVar) {
        LinkedList<ImMessageCenterShowItemData> q = com.baidu.tieba.im.pushNotify.a.i().q();
        Iterator<ImMessageCenterShowItemData> it = q.iterator();
        while (it.hasNext()) {
            ImMessageCenterPojo a = com.baidu.tieba.im.b.k.a().a(it.next().getFriendId());
            if (a != null) {
                a.setIs_hidden(1);
            }
        }
        com.baidu.tieba.im.pushNotify.a.i().w();
        com.baidu.tieba.im.i.a(new s(this, q), new t(this, aVar));
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

    public List<ImMessageCenterShowItemData> c() {
        return this.a;
    }

    public void d() {
        this.a.clear();
        this.b.clear();
    }

    public static void a(String str) {
        com.baidu.tieba.im.pushNotify.a.i().b(false, (com.baidu.tieba.im.a<Void>) null);
    }

    public static void b(String str) {
        ImMessageCenterPojo a = com.baidu.tieba.im.b.k.a().a(str);
        if (a != null) {
            a.setUnread_count(0);
        }
    }

    public void a(com.baidu.tieba.im.a<Void> aVar) {
        d(aVar);
    }

    private void d(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.pushNotify.a.i().b(false, (com.baidu.tieba.im.a<Void>) new w(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        this.a.clear();
        if (this.b != null) {
            this.a.addAll(this.b);
        }
        if (com.baidu.tieba.im.pushNotify.a.i().x()) {
            ImMessageCenterShowItemData n = com.baidu.tieba.im.pushNotify.a.i().n();
            if (n != null) {
                this.a.add(n);
            } else {
                com.baidu.tieba.im.pushNotify.a.h();
                ImMessageCenterShowItemData n2 = com.baidu.tieba.im.pushNotify.a.i().n();
                if (n2 != null) {
                    this.a.add(n2);
                }
            }
        }
        if (com.baidu.tieba.im.pushNotify.a.i().y()) {
            ImMessageCenterShowItemData r = com.baidu.tieba.im.pushNotify.a.i().r();
            if (r != null) {
                this.a.add(r);
            } else {
                com.baidu.tieba.im.pushNotify.a.a((String) null, false);
                ImMessageCenterShowItemData r2 = com.baidu.tieba.im.pushNotify.a.i().r();
                if (r2 != null) {
                    this.a.add(r2);
                }
            }
        }
        if (com.baidu.tieba.im.pushNotify.a.i().z()) {
            ImMessageCenterShowItemData s = com.baidu.tieba.im.pushNotify.a.i().s();
            if (s != null) {
                this.a.add(s);
            } else {
                com.baidu.tieba.im.pushNotify.a.a((String) null);
                ImMessageCenterShowItemData s2 = com.baidu.tieba.im.pushNotify.a.i().s();
                if (s2 != null) {
                    this.a.add(s2);
                }
            }
        }
        ImMessageCenterShowItemData t = com.baidu.tieba.im.pushNotify.a.i().t();
        if (t != null) {
            this.a.add(t);
        }
        ImMessageCenterShowItemData v = com.baidu.tieba.im.pushNotify.a.i().v();
        if (v != null) {
            this.a.add(v);
        }
        Collections.sort(this.a, new x(this));
    }
}
