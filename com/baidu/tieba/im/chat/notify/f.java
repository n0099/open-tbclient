package com.baidu.tieba.im.chat.notify;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bk;
import com.baidu.tbadk.core.atomData.ca;
import com.baidu.tbadk.core.atomData.y;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.live.livenotify.LiveNotifyActivity;
import com.baidu.tieba.im.validate.ValidateActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        n nVar;
        FragmentActivity fragmentActivity;
        FragmentActivity fragmentActivity2;
        FragmentActivity fragmentActivity3;
        FragmentActivity fragmentActivity4;
        FragmentActivity fragmentActivity5;
        FragmentActivity fragmentActivity6;
        FragmentActivity fragmentActivity7;
        FragmentActivity fragmentActivity8;
        if (i >= 0) {
            nVar = this.a.g;
            ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) nVar.getItem(i);
            fragmentActivity = this.a.d;
            TiebaStatic.eventStat(fragmentActivity, "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (imMessageCenterShowItemData != null) {
                String ownerName = imMessageCenterShowItemData.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    b(imMessageCenterShowItemData);
                } else if (ownerName.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK)) {
                    fragmentActivity7 = this.a.d;
                    TiebaStatic.eventStat(fragmentActivity7, "chat_list_to_group", "click", 1, new Object[0]);
                    fragmentActivity8 = this.a.d;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new y(fragmentActivity8, Integer.parseInt(imMessageCenterShowItemData.getFriendId()), imMessageCenterShowItemData.getFriendName(), 0L, "msg_lstb")));
                } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                    a(imMessageCenterShowItemData);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.a().u() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.a().u().c(0);
                    }
                    fragmentActivity6 = this.a.d;
                    ValidateActivity.a(fragmentActivity6);
                } else if (imMessageCenterShowItemData.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    a(imMessageCenterShowItemData);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.a().u() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.a().u().b(0);
                    }
                    fragmentActivity5 = this.a.d;
                    UpdatesActivity.a(fragmentActivity5);
                } else if (imMessageCenterShowItemData.getOwnerName().equals("6")) {
                    a(imMessageCenterShowItemData);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.a().u() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.a().u().l(0);
                    }
                    fragmentActivity4 = this.a.d;
                    LiveNotifyActivity.a(fragmentActivity4);
                } else if (ownerName.equals("5")) {
                    fragmentActivity3 = this.a.d;
                    OfficialBarTipActivity.a(fragmentActivity3);
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    fragmentActivity2 = this.a.d;
                    messageManager.sendMessage(new CustomMessage(2002001, new ca(fragmentActivity2)));
                } else {
                    b(imMessageCenterShowItemData);
                }
            }
        }
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new g(this, imMessageCenterShowItemData));
        customMessageTask.setParallel(com.baidu.tbadk.k.b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }

    private void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        FragmentActivity fragmentActivity;
        FragmentActivity fragmentActivity2;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().d(com.baidu.tbadk.coreExtra.messageCenter.a.a().o() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            fragmentActivity = this.a.d;
            com.baidu.tbadk.core.f.a(fragmentActivity, "tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            fragmentActivity2 = this.a.d;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new bk(fragmentActivity2, parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
