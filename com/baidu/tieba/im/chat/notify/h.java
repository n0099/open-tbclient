package com.baidu.tieba.im.chat.notify;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.StrangerListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.validate.ValidateActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ g aQC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aQC = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        FragmentActivity fragmentActivity;
        FragmentActivity fragmentActivity2;
        FragmentActivity fragmentActivity3;
        FragmentActivity fragmentActivity4;
        FragmentActivity fragmentActivity5;
        FragmentActivity fragmentActivity6;
        FragmentActivity fragmentActivity7;
        FragmentActivity fragmentActivity8;
        FragmentActivity fragmentActivity9;
        if (i >= 0) {
            imMessageCenterListAdapter = this.aQC.aQp;
            ImMessageCenterShowItemData fr = imMessageCenterListAdapter.getItem(i);
            fragmentActivity = this.aQC.mActivity;
            TiebaStatic.eventStat(fragmentActivity, "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (fr != null) {
                String ownerName = fr.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(fr);
                } else if (ownerName.equals("1")) {
                    fragmentActivity8 = this.aQC.mActivity;
                    TiebaStatic.eventStat(fragmentActivity8, "chat_list_to_group", "click", 1, new Object[0]);
                    fragmentActivity9 = this.aQC.mActivity;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(fragmentActivity9, Integer.parseInt(fr.getFriendId()), fr.getFriendName(), 0L, "msg_lstb")));
                } else if (fr.getOwnerName().equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                    d(fr);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.oB().oU() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.oB().oU().cc(0);
                    }
                    fragmentActivity7 = this.aQC.mActivity;
                    ValidateActivity.ae(fragmentActivity7);
                } else if (fr.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    d(fr);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.oB().oU() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.oB().oU().cb(0);
                    }
                    fragmentActivity6 = this.aQC.mActivity;
                    UpdatesActivity.ae(fragmentActivity6);
                } else if (fr.getOwnerName().equals("6")) {
                    d(fr);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.oB().oU() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.oB().oU().cl(0);
                    }
                    if (TbadkApplication.m251getInst().isLiveSDKOpen()) {
                        Intent intent = new Intent("com.baidu.tieba.live.LIVENOTIFY");
                        intent.setFlags(268435456);
                        fragmentActivity5 = this.aQC.mActivity;
                        fragmentActivity5.startActivity(intent);
                        return;
                    }
                    Intent intent2 = new Intent("com.baidu.tieba.live.BACKUPLIVENOTIFY");
                    intent2.setFlags(268435456);
                    fragmentActivity4 = this.aQC.mActivity;
                    fragmentActivity4.startActivity(intent2);
                } else if (ownerName.equals("5")) {
                    fragmentActivity3 = this.aQC.mActivity;
                    OfficialBarTipActivity.ac(fragmentActivity3);
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    fragmentActivity2 = this.aQC.mActivity;
                    messageManager.sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(fragmentActivity2)));
                } else {
                    e(fr);
                }
            }
        }
    }

    private void d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new i(this, imMessageCenterShowItemData));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }

    private void e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        FragmentActivity fragmentActivity;
        FragmentActivity fragmentActivity2;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.oB().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            fragmentActivity = this.aQC.mActivity;
            com.baidu.tbadk.core.i.l(fragmentActivity, "tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            fragmentActivity2 = this.aQC.mActivity;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(fragmentActivity2, parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
