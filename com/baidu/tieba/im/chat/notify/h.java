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
    final /* synthetic */ g aSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aSu = gVar;
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
            imMessageCenterListAdapter = this.aSu.aSi;
            ImMessageCenterShowItemData fu = imMessageCenterListAdapter.getItem(i);
            bdBaseFragmentActivity = this.aSu.aSf;
            TiebaStatic.eventStat(bdBaseFragmentActivity.getPageContext().getContext(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            if (fu != null) {
                String ownerName = fu.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    e(fu);
                } else if (ownerName.equals("1")) {
                    bdBaseFragmentActivity8 = this.aSu.aSf;
                    TiebaStatic.eventStat(bdBaseFragmentActivity8.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                    bdBaseFragmentActivity9 = this.aSu.aSf;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(bdBaseFragmentActivity9.getPageContext().getPageActivity(), Integer.parseInt(fu.getFriendId()), fu.getFriendName(), 0L, "msg_lstb")));
                } else if (fu.getOwnerName().equals("2")) {
                    d(fu);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc().cA(0);
                    }
                    g gVar = this.aSu;
                    bdBaseFragmentActivity7 = this.aSu.aSf;
                    gVar.sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(bdBaseFragmentActivity7.getPageContext().getPageActivity())));
                } else if (fu.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                    d(fu);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc().cz(0);
                    }
                    g gVar2 = this.aSu;
                    bdBaseFragmentActivity6 = this.aSu.aSf;
                    gVar2.sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(bdBaseFragmentActivity6.getPageContext().getPageActivity())));
                } else if (fu.getOwnerName().equals("6")) {
                    d(fu);
                    if (com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc() != null) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc().cJ(0);
                    }
                    g gVar3 = this.aSu;
                    bdBaseFragmentActivity5 = this.aSu.aSf;
                    gVar3.sendMessage(new CustomMessage(2002001, new LiveNotifyActivityConfig(bdBaseFragmentActivity5.getPageContext().getPageActivity())));
                } else if (ownerName.equals("5")) {
                    g gVar4 = this.aSu;
                    bdBaseFragmentActivity4 = this.aSu.aSf;
                    gVar4.sendMessage(new CustomMessage(2008022, new OfficialBarTipActivityConfig(bdBaseFragmentActivity4.getPageContext().getPageActivity())));
                } else if (ownerName.equals("8")) {
                    long a = com.baidu.adp.lib.g.c.a(fu.getFriendId(), 0L);
                    int userType = fu.getUserType();
                    bdBaseFragmentActivity3 = this.aSu.aSf;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(bdBaseFragmentActivity3.getPageContext().getPageActivity(), a, fu.getFriendName(), fu.getFriendPortrait(), 0, userType)));
                } else if (ownerName.equals(WriteData.THREAD_TYPE_LBS)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    bdBaseFragmentActivity2 = this.aSu.aSf;
                    messageManager.sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(bdBaseFragmentActivity2.getPageContext().getPageActivity())));
                } else {
                    e(fu);
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
            com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgChat(com.baidu.tbadk.coreExtra.messageCenter.a.rI().getMsgChat() - imMessageCenterShowItemData.getUnReadCount());
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
            bdBaseFragmentActivity = this.aSu.aSf;
            com.baidu.tbadk.core.i.B(bdBaseFragmentActivity.getPageContext().getContext(), "tab_msg_personal_chat_click");
            TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            bdBaseFragmentActivity2 = this.aSu.aSf;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bdBaseFragmentActivity2.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
