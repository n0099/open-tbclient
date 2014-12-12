package com.baidu.tieba.im.chat;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class cd extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonalChatActivity aRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd(PersonalChatActivity personalChatActivity, int i, boolean z) {
        super(i, z);
        this.aRE = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.coreExtra.relationship.f fVar;
        com.baidu.tbadk.coreExtra.relationship.f fVar2;
        com.baidu.tbadk.coreExtra.relationship.f fVar3;
        long j;
        com.baidu.tieba.im.chat.personaltalk.e eVar;
        String str;
        com.baidu.tbadk.coreExtra.relationship.f fVar4;
        Handler handler;
        Runnable runnable;
        long j2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
            this.aRE.aRw = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            fVar = this.aRE.aRw;
            if (fVar != null) {
                UserData user = ((PersonalMsglistModel) this.aRE.mListModel).getUser();
                if (user != null) {
                    AbsMsglistView absMsglistView = this.aRE.mListView;
                    String userName = user.getUserName();
                    fVar2 = this.aRE.aRw;
                    absMsglistView.refreshPersonalHeadFooter(userName, fVar2);
                    PersonalChatActivity personalChatActivity = this.aRE;
                    PersonalChatActivity personalChatActivity2 = this.aRE;
                    fVar3 = this.aRE.aRw;
                    personalChatActivity.aRv = personalChatActivity2.fS(com.baidu.tbadk.core.util.ba.m(fVar3.getTime()));
                    j = this.aRE.aRv;
                    if (j != 0) {
                        handler = this.aRE.mHandler;
                        runnable = this.aRE.aRB;
                        j2 = this.aRE.aRv;
                        handler.postDelayed(runnable, j2);
                    }
                    eVar = PersonalChatActivity.aRy;
                    str = this.aRE.aRx;
                    String str2 = String.valueOf(str) + "&" + user.getUserId();
                    fVar4 = this.aRE.aRw;
                    eVar.a(str2, new com.baidu.tieba.im.chat.personaltalk.a(fVar4, System.currentTimeMillis()));
                } else {
                    return;
                }
            }
            TbadkCoreApplication.m255getInst().getAlarmManager().lb();
        }
    }
}
