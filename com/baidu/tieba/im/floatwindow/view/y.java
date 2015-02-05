package com.baidu.tieba.im.floatwindow.view;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class y extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FloatingPersonalChatActivity baa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(FloatingPersonalChatActivity floatingPersonalChatActivity, int i, boolean z) {
        super(i, z);
        this.baa = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.coreExtra.relationship.f fVar;
        MsglistModel msglistModel;
        FloatingPersonalChatView floatingPersonalChatView;
        com.baidu.tbadk.coreExtra.relationship.f fVar2;
        com.baidu.tbadk.coreExtra.relationship.f fVar3;
        long fU;
        long j;
        com.baidu.tieba.im.chat.personaltalk.e eVar;
        String str;
        com.baidu.tbadk.coreExtra.relationship.f fVar4;
        Handler handler;
        Runnable runnable;
        long j2;
        MsglistModel msglistModel2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
            this.baa.aSE = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            fVar = this.baa.aSE;
            if (fVar != null) {
                UserData userData = null;
                msglistModel = this.baa.mListModel;
                if (msglistModel instanceof PersonalMsglistModel) {
                    msglistModel2 = this.baa.mListModel;
                    userData = ((PersonalMsglistModel) msglistModel2).getUser();
                }
                if (userData == null) {
                    return;
                }
                floatingPersonalChatView = this.baa.aZY;
                String userName = userData.getUserName();
                fVar2 = this.baa.aSE;
                floatingPersonalChatView.a(userName, fVar2);
                FloatingPersonalChatActivity floatingPersonalChatActivity = this.baa;
                FloatingPersonalChatActivity floatingPersonalChatActivity2 = this.baa;
                fVar3 = this.baa.aSE;
                fU = floatingPersonalChatActivity2.fU(bf.m(fVar3.getTime()));
                floatingPersonalChatActivity.aSD = fU;
                j = this.baa.aSD;
                if (j != 0) {
                    handler = this.baa.mHandler;
                    runnable = this.baa.aSJ;
                    j2 = this.baa.aSD;
                    handler.postDelayed(runnable, j2);
                }
                eVar = FloatingPersonalChatActivity.aSG;
                str = this.baa.aSF;
                String str2 = String.valueOf(str) + "&" + userData.getUserId();
                fVar4 = this.baa.aSE;
                eVar.a(str2, new com.baidu.tieba.im.chat.personaltalk.a(fVar4, System.currentTimeMillis()));
            }
            TbadkCoreApplication.m255getInst().getAlarmManager().kU();
        }
    }
}
