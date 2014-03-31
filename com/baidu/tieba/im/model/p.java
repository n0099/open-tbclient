package com.baidu.tieba.im.model;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class p extends com.baidu.adp.a.e {
    private final List<ImMessageCenterShowItemData> a = new LinkedList();
    private final List<ImMessageCenterShowItemData> b = new LinkedList();

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData, com.baidu.tieba.im.a<Void> aVar) {
        if (imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(2))) {
                com.baidu.tbadk.core.sharedPref.b.a().b("is_show_validate", false);
                TbadkApplication.E();
                a(String.valueOf(2), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(3))) {
                com.baidu.tbadk.core.sharedPref.b.a().b("is_show_updates", false);
                TbadkApplication.E();
                a(String.valueOf(3), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(1))) {
                TbadkApplication.E();
                a(imMessageCenterShowItemData.getFriendId(), aVar, false);
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(5))) {
                com.baidu.tbadk.coreExtra.messageCenter.a.a().e();
                LinkedList<ImMessageCenterShowItemData> h = com.baidu.tieba.im.pushNotify.a.d().h();
                Iterator<ImMessageCenterShowItemData> it = h.iterator();
                while (it.hasNext()) {
                    ImMessageCenterPojo a = com.baidu.tieba.im.b.j.a().a(it.next().getFriendId());
                    if (a != null) {
                        a.setIs_hidden(1);
                    }
                }
                com.baidu.tieba.im.pushNotify.a.d().k();
                com.baidu.tieba.im.s.a(new q(this, h), new r(this, aVar));
            } else if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(4))) {
                TbadkApplication.E();
                a(imMessageCenterShowItemData.getFriendId(), aVar, true);
            }
        }
    }

    private void a(String str, com.baidu.tieba.im.a<Void> aVar, boolean z) {
        ImMessageCenterPojo a;
        if (z) {
            a = com.baidu.tieba.im.b.k.a().a(str);
        } else {
            a = com.baidu.tieba.im.b.a.a().a(str);
        }
        if (a != null) {
            a.setIs_hidden(1);
        }
        com.baidu.tieba.im.s.a(new s(this, z, str), new t(this, str, aVar));
    }

    public final List<ImMessageCenterShowItemData> a() {
        return this.a;
    }

    public final void b() {
        this.a.clear();
        this.b.clear();
    }

    public final void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.pushNotify.a.d().b(false, new u(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        this.a.clear();
        if (this.b != null) {
            this.a.addAll(this.b);
        }
        com.baidu.tieba.im.pushNotify.a.d();
        if (com.baidu.tieba.im.pushNotify.a.l()) {
            ImMessageCenterShowItemData f = com.baidu.tieba.im.pushNotify.a.d().f();
            if (f != null) {
                this.a.add(f);
            } else {
                com.baidu.tieba.im.pushNotify.a.c();
                ImMessageCenterShowItemData f2 = com.baidu.tieba.im.pushNotify.a.d().f();
                if (f2 != null) {
                    this.a.add(f2);
                }
            }
        }
        com.baidu.tieba.im.pushNotify.a.d();
        if (com.baidu.tieba.im.pushNotify.a.m()) {
            ImMessageCenterShowItemData i = com.baidu.tieba.im.pushNotify.a.d().i();
            if (i != null) {
                this.a.add(i);
            } else {
                com.baidu.tieba.im.pushNotify.a.a((String) null, false);
                ImMessageCenterShowItemData i2 = com.baidu.tieba.im.pushNotify.a.d().i();
                if (i2 != null) {
                    this.a.add(i2);
                }
            }
        }
        ImMessageCenterShowItemData j = com.baidu.tieba.im.pushNotify.a.d().j();
        if (j != null) {
            this.a.add(j);
        }
        Collections.sort(this.a, new v(this));
    }
}
