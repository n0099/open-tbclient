package com.baidu.tieba.im.chat.notify;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.LiveNotifyActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.StrangerListActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ g aTD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aTD = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        BdBaseFragmentActivity bdBaseFragmentActivity;
        BdBaseFragmentActivity bdBaseFragmentActivity2;
        BdBaseFragmentActivity bdBaseFragmentActivity3;
        BdBaseFragmentActivity bdBaseFragmentActivity4;
        BdBaseFragmentActivity bdBaseFragmentActivity5;
        BdBaseFragmentActivity bdBaseFragmentActivity6;
        BdBaseFragmentActivity bdBaseFragmentActivity7;
        BdBaseFragmentActivity bdBaseFragmentActivity8;
        BdBaseFragmentActivity bdBaseFragmentActivity9;
        if (i >= 0) {
            imMessageCenterListAdapter = this.aTD.aTq;
            ImMessageCenterShowItemData fz = imMessageCenterListAdapter.getItem(i);
            bdBaseFragmentActivity = this.aTD.aTn;
            TiebaStatic.eventStat(bdBaseFragmentActivity.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (fz != null) {
                String ownerName = fz.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(fz);
                } else if (ownerName.equals("1")) {
                    bdBaseFragmentActivity8 = this.aTD.aTn;
                    TiebaStatic.eventStat(bdBaseFragmentActivity8.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                    bdBaseFragmentActivity9 = this.aTD.aTn;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(bdBaseFragmentActivity9.getPageContext().getPageActivity(), Integer.parseInt(fz.getFriendId()), fz.getFriendName(), 0L, "msg_lstb")));
                } else if (fz.getOwnerName().equals("2")) {
                    d(fz);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm().cH(0);
                    }
                    g gVar = this.aTD;
                    bdBaseFragmentActivity7 = this.aTD.aTn;
                    gVar.sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(bdBaseFragmentActivity7.getPageContext().getPageActivity())));
                } else if (fz.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    d(fz);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm().cG(0);
                    }
                    g gVar2 = this.aTD;
                    bdBaseFragmentActivity6 = this.aTD.aTn;
                    gVar2.sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(bdBaseFragmentActivity6.getPageContext().getPageActivity())));
                } else if (fz.getOwnerName().equals("6")) {
                    d(fz);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm().cQ(0);
                    }
                    g gVar3 = this.aTD;
                    bdBaseFragmentActivity5 = this.aTD.aTn;
                    gVar3.sendMessage(new CustomMessage(2002001, new LiveNotifyActivityConfig(bdBaseFragmentActivity5.getPageContext().getPageActivity())));
                } else if (ownerName.equals("5")) {
                    g gVar4 = this.aTD;
                    bdBaseFragmentActivity4 = this.aTD.aTn;
                    gVar4.sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(bdBaseFragmentActivity4.getPageContext().getPageActivity())));
                } else if (ownerName.equals("8")) {
                    long a = com.baidu.adp.lib.g.c.a(fz.getFriendId(), 0L);
                    int userType = fz.getUserType();
                    bdBaseFragmentActivity3 = this.aTD.aTn;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(bdBaseFragmentActivity3.getPageContext().getPageActivity(), a, fz.getFriendName(), fz.getFriendPortrait(), 0, userType)));
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    bdBaseFragmentActivity2 = this.aTD.aTn;
                    messageManager.sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(bdBaseFragmentActivity2.getPageContext().getPageActivity())));
                } else {
                    e(fz);
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
        BdBaseFragmentActivity bdBaseFragmentActivity;
        BdBaseFragmentActivity bdBaseFragmentActivity2;
        if (imMessageCenterShowItemData.getUnReadCount() > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.a.rS().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            bdBaseFragmentActivity = this.aTD.aTn;
            com.baidu.tbadk.core.i.A(bdBaseFragmentActivity.getPageContext().getContext(), "tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            bdBaseFragmentActivity2 = this.aTD.aTn;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bdBaseFragmentActivity2.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
