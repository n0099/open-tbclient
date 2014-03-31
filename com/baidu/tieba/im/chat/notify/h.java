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
import com.baidu.tieba.im.s;
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
        p pVar;
        p pVar2;
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
            pVar = this.a.j;
            long itemId = pVar.getItemId(i);
            if (itemId == -1) {
                i4 = this.a.d;
                if (i4 > 1) {
                    b bVar = this.a;
                    i5 = bVar.d;
                    bVar.d = i5 - 1;
                    b bVar2 = this.a;
                    i6 = this.a.d;
                    bVar2.a(i6, 2);
                }
            } else if (itemId != -2) {
                pVar2 = this.a.j;
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) pVar2.getItem(i);
                activity = this.a.c;
                TiebaStatic.a(activity, "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (imMessageCenterShowItemData != null) {
                    String ownerName = imMessageCenterShowItemData.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        b(imMessageCenterShowItemData);
                        return;
                    } else if (ownerName.equals("1")) {
                        com.baidu.tieba.im.pushNotify.a d = com.baidu.tieba.im.pushNotify.a.d();
                        aVar2 = this.a.t;
                        d.b(false, aVar2);
                        activity5 = this.a.c;
                        TiebaStatic.a(activity5, "chat_list_to_group", "click", 1, new Object[0]);
                        activity6 = this.a.c;
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.n(activity6, Integer.parseInt(imMessageCenterShowItemData.getFriendId()), imMessageCenterShowItemData.getFriendName(), 0L, "msg_lstb")));
                        return;
                    } else if (imMessageCenterShowItemData.getOwnerName().equals("2")) {
                        a(imMessageCenterShowItemData);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.a().p() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.a().p().d(0);
                        }
                        com.baidu.tieba.im.pushNotify.a d2 = com.baidu.tieba.im.pushNotify.a.d();
                        aVar = this.a.t;
                        d2.b(false, aVar);
                        activity4 = this.a.c;
                        ValidateActivity.a(activity4);
                        return;
                    } else if (imMessageCenterShowItemData.getOwnerName().equals("3")) {
                        a(imMessageCenterShowItemData);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.a().p() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.a().p().b(0);
                        }
                        activity3 = this.a.c;
                        UpdatesActivity.a(activity3);
                        return;
                    } else if (ownerName.equals("5")) {
                        activity2 = this.a.c;
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
                i2 = bVar3.d;
                bVar3.d = i2 + 1;
                b bVar4 = this.a;
                i3 = this.a.d;
                bVar4.a(i3, 1);
            }
        }
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        s.a(new i(this, imMessageCenterShowItemData), null);
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
            activity = this.a.c;
            com.baidu.tbadk.core.g.a(activity, "tab_msg_personal_chat_click");
            new ax("pchat", "1").start();
            activity2 = this.a.c;
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001005, new ah(activity2, parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
