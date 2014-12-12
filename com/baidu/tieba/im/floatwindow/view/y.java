package com.baidu.tieba.im.floatwindow.view;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class y extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FloatingPersonalChatActivity aYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(FloatingPersonalChatActivity floatingPersonalChatActivity, int i, boolean z) {
        super(i, z);
        this.aYF = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.coreExtra.relationship.f fVar;
        MsglistModel msglistModel;
        FloatingPersonalChatView floatingPersonalChatView;
        com.baidu.tbadk.coreExtra.relationship.f fVar2;
        com.baidu.tbadk.coreExtra.relationship.f fVar3;
        long fS;
        long j;
        com.baidu.tieba.im.chat.personaltalk.e eVar;
        String str;
        com.baidu.tbadk.coreExtra.relationship.f fVar4;
        Handler handler;
        Runnable runnable;
        long j2;
        MsglistModel msglistModel2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
            this.aYF.aRw = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            fVar = this.aYF.aRw;
            if (fVar != null) {
                UserData userData = null;
                msglistModel = this.aYF.mListModel;
                if (msglistModel instanceof PersonalMsglistModel) {
                    msglistModel2 = this.aYF.mListModel;
                    userData = ((PersonalMsglistModel) msglistModel2).getUser();
                }
                if (userData == null) {
                    return;
                }
                floatingPersonalChatView = this.aYF.aYD;
                String userName = userData.getUserName();
                fVar2 = this.aYF.aRw;
                floatingPersonalChatView.a(userName, fVar2);
                FloatingPersonalChatActivity floatingPersonalChatActivity = this.aYF;
                FloatingPersonalChatActivity floatingPersonalChatActivity2 = this.aYF;
                fVar3 = this.aYF.aRw;
                fS = floatingPersonalChatActivity2.fS(ba.m(fVar3.getTime()));
                floatingPersonalChatActivity.aRv = fS;
                j = this.aYF.aRv;
                if (j != 0) {
                    handler = this.aYF.mHandler;
                    runnable = this.aYF.aRB;
                    j2 = this.aYF.aRv;
                    handler.postDelayed(runnable, j2);
                }
                eVar = FloatingPersonalChatActivity.aRy;
                str = this.aYF.aRx;
                String str2 = String.valueOf(str) + "&" + userData.getUserId();
                fVar4 = this.aYF.aRw;
                eVar.a(str2, new com.baidu.tieba.im.chat.personaltalk.a(fVar4, System.currentTimeMillis()));
            }
            TbadkCoreApplication.m255getInst().getAlarmManager().lb();
        }
    }
}
