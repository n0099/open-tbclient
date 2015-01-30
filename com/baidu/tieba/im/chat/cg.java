package com.baidu.tieba.im.chat;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class cg extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonalChatActivity aSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cg(PersonalChatActivity personalChatActivity, int i, boolean z) {
        super(i, z);
        this.aSN = personalChatActivity;
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
            this.aSN.aSF = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            fVar = this.aSN.aSF;
            if (fVar != null) {
                UserData user = ((PersonalMsglistModel) this.aSN.mListModel).getUser();
                if (user != null) {
                    AbsMsglistView absMsglistView = this.aSN.mListView;
                    String userName = user.getUserName();
                    fVar2 = this.aSN.aSF;
                    absMsglistView.refreshPersonalHeadFooter(userName, fVar2);
                    PersonalChatActivity personalChatActivity = this.aSN;
                    PersonalChatActivity personalChatActivity2 = this.aSN;
                    fVar3 = this.aSN.aSF;
                    personalChatActivity.aSE = personalChatActivity2.fX(com.baidu.tbadk.core.util.bf.m(fVar3.getTime()));
                    j = this.aSN.aSE;
                    if (j != 0) {
                        handler = this.aSN.mHandler;
                        runnable = this.aSN.aSK;
                        j2 = this.aSN.aSE;
                        handler.postDelayed(runnable, j2);
                    }
                    eVar = PersonalChatActivity.aSH;
                    str = this.aSN.aSG;
                    String str2 = String.valueOf(str) + "&" + user.getUserId();
                    fVar4 = this.aSN.aSF;
                    eVar.a(str2, new com.baidu.tieba.im.chat.personaltalk.a(fVar4, System.currentTimeMillis()));
                } else {
                    return;
                }
            }
            TbadkCoreApplication.m255getInst().getAlarmManager().lb();
        }
    }
}
