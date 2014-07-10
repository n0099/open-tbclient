package com.baidu.tieba.im.chat.notify;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bc;
import com.baidu.tbadk.core.atomData.bq;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.live.livenotify.LiveNotifyActivity;
import com.baidu.tieba.im.validate.ValidateActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(d dVar) {
        this.a = dVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        u uVar;
        FragmentActivity fragmentActivity;
        FragmentActivity fragmentActivity2;
        FragmentActivity fragmentActivity3;
        FragmentActivity fragmentActivity4;
        FragmentActivity fragmentActivity5;
        com.baidu.tieba.im.a<Void> aVar;
        FragmentActivity fragmentActivity6;
        com.baidu.tieba.im.a<Void> aVar2;
        FragmentActivity fragmentActivity7;
        FragmentActivity fragmentActivity8;
        if (i >= 0) {
            uVar = this.a.h;
            ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) uVar.getItem(i);
            fragmentActivity = this.a.e;
            TiebaStatic.eventStat(fragmentActivity, "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (imMessageCenterShowItemData != null) {
                String ownerName = imMessageCenterShowItemData.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    b(imMessageCenterShowItemData);
                } else if (ownerName.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK)) {
                    com.baidu.tieba.im.pushNotify.a i2 = com.baidu.tieba.im.pushNotify.a.i();
                    aVar2 = this.a.s;
                    i2.b(false, aVar2);
                    fragmentActivity7 = this.a.e;
                    TiebaStatic.eventStat(fragmentActivity7, "chat_list_to_group", "click", 1, new Object[0]);
                    fragmentActivity8 = this.a.e;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.u(fragmentActivity8, Integer.parseInt(imMessageCenterShowItemData.getFriendId()), imMessageCenterShowItemData.getFriendName(), 0L, "msg_lstb")));
                } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                    a(imMessageCenterShowItemData);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.a().r() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.a().r().d(0);
                    }
                    com.baidu.tieba.im.pushNotify.a i3 = com.baidu.tieba.im.pushNotify.a.i();
                    aVar = this.a.s;
                    i3.b(false, aVar);
                    fragmentActivity6 = this.a.e;
                    ValidateActivity.a(fragmentActivity6);
                } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    a(imMessageCenterShowItemData);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.a().r() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.a().r().b(0);
                    }
                    fragmentActivity5 = this.a.e;
                    UpdatesActivity.a(fragmentActivity5);
                } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                    a(imMessageCenterShowItemData);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.a().r() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.a().r().m(0);
                    }
                    fragmentActivity4 = this.a.e;
                    LiveNotifyActivity.a(fragmentActivity4);
                } else if (ownerName.equals("5")) {
                    a();
                    fragmentActivity3 = this.a.e;
                    OfficialBarTipActivity.a(fragmentActivity3);
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    b();
                    MessageManager messageManager = MessageManager.getInstance();
                    fragmentActivity2 = this.a.e;
                    messageManager.sendMessage(new CustomMessage(2002001, new bq(fragmentActivity2)));
                } else {
                    b(imMessageCenterShowItemData);
                }
            }
        }
    }

    private void a() {
        com.baidu.tieba.im.model.p.a(false);
        com.baidu.tieba.im.i.a(new m(this), null);
    }

    private void b() {
        com.baidu.tieba.im.model.p.b(false);
        com.baidu.tieba.im.i.a(new n(this), null);
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        com.baidu.tieba.im.i.a(new o(this, imMessageCenterShowItemData), null);
    }

    private void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        FragmentActivity fragmentActivity;
        FragmentActivity fragmentActivity2;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().d(com.baidu.tbadk.coreExtra.messageCenter.a.a().m() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            fragmentActivity = this.a.e;
            com.baidu.tbadk.core.f.a(fragmentActivity, "tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            fragmentActivity2 = this.a.e;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new bc(fragmentActivity2, parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
