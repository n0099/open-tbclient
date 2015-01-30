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
    final /* synthetic */ FloatingPersonalChatActivity bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(FloatingPersonalChatActivity floatingPersonalChatActivity, int i, boolean z) {
        super(i, z);
        this.bab = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.coreExtra.relationship.f fVar;
        MsglistModel msglistModel;
        FloatingPersonalChatView floatingPersonalChatView;
        com.baidu.tbadk.coreExtra.relationship.f fVar2;
        com.baidu.tbadk.coreExtra.relationship.f fVar3;
        long fX;
        long j;
        com.baidu.tieba.im.chat.personaltalk.e eVar;
        String str;
        com.baidu.tbadk.coreExtra.relationship.f fVar4;
        Handler handler;
        Runnable runnable;
        long j2;
        MsglistModel msglistModel2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
            this.bab.aSF = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            fVar = this.bab.aSF;
            if (fVar != null) {
                UserData userData = null;
                msglistModel = this.bab.mListModel;
                if (msglistModel instanceof PersonalMsglistModel) {
                    msglistModel2 = this.bab.mListModel;
                    userData = ((PersonalMsglistModel) msglistModel2).getUser();
                }
                if (userData == null) {
                    return;
                }
                floatingPersonalChatView = this.bab.aZZ;
                String userName = userData.getUserName();
                fVar2 = this.bab.aSF;
                floatingPersonalChatView.a(userName, fVar2);
                FloatingPersonalChatActivity floatingPersonalChatActivity = this.bab;
                FloatingPersonalChatActivity floatingPersonalChatActivity2 = this.bab;
                fVar3 = this.bab.aSF;
                fX = floatingPersonalChatActivity2.fX(bf.m(fVar3.getTime()));
                floatingPersonalChatActivity.aSE = fX;
                j = this.bab.aSE;
                if (j != 0) {
                    handler = this.bab.mHandler;
                    runnable = this.bab.aSK;
                    j2 = this.bab.aSE;
                    handler.postDelayed(runnable, j2);
                }
                eVar = FloatingPersonalChatActivity.aSH;
                str = this.bab.aSG;
                String str2 = String.valueOf(str) + "&" + userData.getUserId();
                fVar4 = this.bab.aSF;
                eVar.a(str2, new com.baidu.tieba.im.chat.personaltalk.a(fVar4, System.currentTimeMillis()));
            }
            TbadkCoreApplication.m255getInst().getAlarmManager().lb();
        }
    }
}
