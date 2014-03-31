package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class bc extends com.baidu.adp.a.e {
    private final LinkedList<ImMessageCenterShowItemData> a = new LinkedList<>();

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

    public static void a(String str, com.baidu.tieba.im.a<Void> aVar) {
        if (!TextUtils.isEmpty(str)) {
            ImMessageCenterPojo a = com.baidu.tieba.im.b.j.a().a(str);
            if (a != null) {
                a.setIs_hidden(1);
                a.setUnread_count(0);
            }
            com.baidu.tieba.im.s.a(new bd(str), new be(str, aVar));
        }
    }

    public final LinkedList<ImMessageCenterShowItemData> a() {
        return this.a;
    }

    public final void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.pushNotify.a.d().b(false, new bf(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(bc bcVar) {
        if (bcVar.a == null || bcVar.a.size() == 0) {
            return;
        }
        Collections.sort(bcVar.a, new bg(bcVar));
    }
}
