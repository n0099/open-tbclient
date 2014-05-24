package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bj extends com.baidu.adp.base.b {
    private final LinkedList<ImMessageCenterShowItemData> a = new LinkedList<>();

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
            String friendId = imMessageCenterShowItemData.getFriendId();
            if (!TextUtils.isEmpty(friendId)) {
                a(friendId, aVar);
                Iterator<ImMessageCenterShowItemData> it = this.a.iterator();
                while (it.hasNext()) {
                    if (friendId.equals(it.next().getFriendId())) {
                        it.remove();
                    }
                }
            }
        }
    }

    public static void a(String str) {
        ImMessageCenterPojo a = com.baidu.tieba.im.b.j.a().a(str);
        if (a != null) {
            a.setUnread_count(0);
        }
    }

    public static void a(String str, com.baidu.tieba.im.a<Void> aVar) {
        if (!TextUtils.isEmpty(str)) {
            ImMessageCenterPojo a = com.baidu.tieba.im.b.j.a().a(str);
            if (a != null) {
                a.setIs_hidden(1);
                a.setUnread_count(0);
            }
            com.baidu.tieba.im.i.a(new bk(str), new bl(str, aVar));
        }
    }

    public LinkedList<ImMessageCenterShowItemData> a() {
        return this.a;
    }

    public void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.pushNotify.a.f().b(false, (com.baidu.tieba.im.a<Void>) new bm(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.a != null && this.a.size() != 0) {
            Collections.sort(this.a, new bn(this));
        }
    }
}
