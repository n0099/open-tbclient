package com.baidu.tieba.im.chat;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class cg extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonalChatActivity aSM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cg(PersonalChatActivity personalChatActivity, int i, boolean z) {
        super(i, z);
        this.aSM = personalChatActivity;
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
            this.aSM.aSE = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            fVar = this.aSM.aSE;
            if (fVar != null) {
                UserData user = ((PersonalMsglistModel) this.aSM.mListModel).getUser();
                if (user != null) {
                    AbsMsglistView absMsglistView = this.aSM.mListView;
                    String userName = user.getUserName();
                    fVar2 = this.aSM.aSE;
                    absMsglistView.refreshPersonalHeadFooter(userName, fVar2);
                    PersonalChatActivity personalChatActivity = this.aSM;
                    PersonalChatActivity personalChatActivity2 = this.aSM;
                    fVar3 = this.aSM.aSE;
                    personalChatActivity.aSD = personalChatActivity2.fU(com.baidu.tbadk.core.util.bf.m(fVar3.getTime()));
                    j = this.aSM.aSD;
                    if (j != 0) {
                        handler = this.aSM.mHandler;
                        runnable = this.aSM.aSJ;
                        j2 = this.aSM.aSD;
                        handler.postDelayed(runnable, j2);
                    }
                    eVar = PersonalChatActivity.aSG;
                    str = this.aSM.aSF;
                    String str2 = String.valueOf(str) + "&" + user.getUserId();
                    fVar4 = this.aSM.aSE;
                    eVar.a(str2, new com.baidu.tieba.im.chat.personaltalk.a(fVar4, System.currentTimeMillis()));
                } else {
                    return;
                }
            }
            TbadkCoreApplication.m255getInst().getAlarmManager().kU();
        }
    }
}
