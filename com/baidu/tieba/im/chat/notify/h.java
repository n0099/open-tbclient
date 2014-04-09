package com.baidu.tieba.im.chat.notify;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.b.ah;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.validate.ValidateActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.a = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        q qVar;
        q qVar2;
        Activity activity;
        Activity activity2;
        Activity activity3;
        com.baidu.tieba.im.a<Void> aVar;
        Activity activity4;
        com.baidu.tieba.im.a<Void> aVar2;
        Activity activity5;
        Activity activity6;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i >= 0) {
            qVar = this.a.k;
            long itemId = qVar.getItemId(i);
            if (itemId == -1) {
                i4 = this.a.e;
                if (i4 > 1) {
                    b bVar = this.a;
                    i5 = bVar.e;
                    bVar.e = i5 - 1;
                    b bVar2 = this.a;
                    i6 = this.a.e;
                    bVar2.a(i6, 2);
                }
            } else if (itemId != -2) {
                qVar2 = this.a.k;
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) qVar2.getItem(i);
                activity = this.a.d;
                TiebaStatic.a(activity, "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (imMessageCenterShowItemData != null) {
                    String ownerName = imMessageCenterShowItemData.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        b(imMessageCenterShowItemData);
                        return;
                    } else if (ownerName.equals("1")) {
                        com.baidu.tieba.im.pushNotify.a d = com.baidu.tieba.im.pushNotify.a.d();
                        aVar2 = this.a.u;
                        d.b(false, aVar2);
                        activity5 = this.a.d;
                        TiebaStatic.a(activity5, "chat_list_to_group", "click", 1, new Object[0]);
                        activity6 = this.a.d;
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.n(activity6, Integer.parseInt(imMessageCenterShowItemData.getFriendId()), imMessageCenterShowItemData.getFriendName(), 0L, "msg_lstb")));
                        return;
                    } else if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                        a(imMessageCenterShowItemData);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.a().p() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.a().p().d(0);
                        }
                        com.baidu.tieba.im.pushNotify.a d2 = com.baidu.tieba.im.pushNotify.a.d();
                        aVar = this.a.u;
                        d2.b(false, aVar);
                        activity4 = this.a.d;
                        ValidateActivity.a(activity4);
                        return;
                    } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                        a(imMessageCenterShowItemData);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.a().p() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.a().p().b(0);
                        }
                        activity3 = this.a.d;
                        UpdatesActivity.a(activity3);
                        return;
                    } else if (ownerName.equals("5")) {
                        com.baidu.tieba.im.model.p.a(false);
                        com.baidu.tieba.im.r.a(new i(this), null);
                        activity2 = this.a.d;
                        OfficialBarTipActivity.a(activity2);
                        return;
                    } else {
                        b(imMessageCenterShowItemData);
                        return;
                    }
                }
                com.baidu.adp.lib.util.f.e(b.class.getName(), "onItemClick", " RecentChatFriendData data is null");
            } else {
                b bVar3 = this.a;
                i2 = bVar3.e;
                bVar3.e = i2 + 1;
                b bVar4 = this.a;
                i3 = this.a.e;
                bVar4.a(i3, 1);
            }
        }
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        com.baidu.tieba.im.r.a(new j(this, imMessageCenterShowItemData), null);
    }

    private void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Activity activity;
        Activity activity2;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().e(com.baidu.tbadk.coreExtra.messageCenter.a.a().l() - imMessageCenterShowItemData.getUnReadCount());
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start"));
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            activity = this.a.d;
            com.baidu.tbadk.core.g.a(activity, "tab_msg_personal_chat_click");
            new ax("pchat", "1").start();
            activity2 = this.a.d;
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001005, new ah(activity2, parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
