package com.baidu.tieba.im.chat.notify;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.au;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.live.livenotify.LiveNotifyActivity;
import com.baidu.tieba.im.validate.ValidateActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements AdapterView.OnItemClickListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar) {
        this.a = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        s sVar;
        s sVar2;
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        com.baidu.tieba.im.a<Void> aVar;
        Activity activity5;
        com.baidu.tieba.im.a<Void> aVar2;
        Activity activity6;
        Activity activity7;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i >= 0) {
            sVar = this.a.l;
            long itemId = sVar.getItemId(i);
            if (itemId == -1) {
                i4 = this.a.f;
                if (i4 > 1) {
                    b bVar = this.a;
                    i5 = bVar.f;
                    bVar.f = i5 - 1;
                    b bVar2 = this.a;
                    i6 = this.a.f;
                    bVar2.b(i6, 2);
                }
            } else if (itemId != -2) {
                sVar2 = this.a.l;
                ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) sVar2.getItem(i);
                activity = this.a.e;
                TiebaStatic.eventStat(activity, "list_to_chat", "chatlistclick", 1, new Object[0]);
                if (imMessageCenterShowItemData != null) {
                    String ownerName = imMessageCenterShowItemData.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        b(imMessageCenterShowItemData);
                        return;
                    } else if (ownerName.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK)) {
                        com.baidu.tieba.im.pushNotify.a f = com.baidu.tieba.im.pushNotify.a.f();
                        aVar2 = this.a.v;
                        f.b(false, aVar2);
                        activity6 = this.a.e;
                        TiebaStatic.eventStat(activity6, "chat_list_to_group", "click", 1, new Object[0]);
                        activity7 = this.a.e;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.p(activity7, Integer.parseInt(imMessageCenterShowItemData.getFriendId()), imMessageCenterShowItemData.getFriendName(), 0L, "msg_lstb")));
                        return;
                    } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                        a(imMessageCenterShowItemData);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.a().s() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.a().s().d(0);
                        }
                        com.baidu.tieba.im.pushNotify.a f2 = com.baidu.tieba.im.pushNotify.a.f();
                        aVar = this.a.v;
                        f2.b(false, aVar);
                        activity5 = this.a.e;
                        ValidateActivity.a(activity5);
                        return;
                    } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                        a(imMessageCenterShowItemData);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.a().s() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.a().s().b(0);
                        }
                        activity4 = this.a.e;
                        UpdatesActivity.a(activity4);
                        return;
                    } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                        a(imMessageCenterShowItemData);
                        if (com.baidu.tbadk.coreExtra.messageCenter.a.a().s() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.a().s().m(0);
                        }
                        activity3 = this.a.e;
                        LiveNotifyActivity.a(activity3);
                        return;
                    } else if (ownerName.equals("5")) {
                        a();
                        activity2 = this.a.e;
                        OfficialBarTipActivity.a(activity2);
                        return;
                    } else {
                        b(imMessageCenterShowItemData);
                        return;
                    }
                }
                BdLog.d(b.class.getName(), "onItemClick", " RecentChatFriendData data is null");
            } else {
                b bVar3 = this.a;
                i2 = bVar3.f;
                bVar3.f = i2 + 1;
                b bVar4 = this.a;
                i3 = this.a.f;
                bVar4.b(i3, 1);
            }
        }
    }

    private void a() {
        com.baidu.tieba.im.model.r.a(false);
        com.baidu.tieba.im.i.a(new l(this), null);
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        com.baidu.tieba.im.i.a(new m(this, imMessageCenterShowItemData), null);
    }

    private void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Activity activity;
        Activity activity2;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().e(com.baidu.tbadk.coreExtra.messageCenter.a.a().n() - imMessageCenterShowItemData.getUnReadCount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.START));
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            activity = this.a.e;
            com.baidu.tbadk.core.g.a(activity, "tab_msg_personal_chat_click");
            new az(TbConfig.ST_TYPE_PCHAT, TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK).start();
            activity2 = this.a.e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2003005, new au(activity2, parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
