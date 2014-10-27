package com.baidu.tieba.im.chat;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class dg extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonalChatActivity aPI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg(PersonalChatActivity personalChatActivity, int i, boolean z) {
        super(i, z);
        this.aPI = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.coreExtra.relationship.f fVar;
        com.baidu.tbadk.coreExtra.relationship.f fVar2;
        com.baidu.tbadk.coreExtra.relationship.f fVar3;
        long j;
        com.baidu.tieba.im.chat.personaltalk.b bVar;
        String str;
        com.baidu.tbadk.coreExtra.relationship.f fVar4;
        Handler handler;
        Runnable runnable;
        long j2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
            this.aPI.aPC = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            fVar = this.aPI.aPC;
            if (fVar != null) {
                UserData user = ((PersonalMsglistModel) this.aPI.aPQ).getUser();
                if (user != null) {
                    AbsMsglistView absMsglistView = this.aPI.aPP;
                    String userName = user.getUserName();
                    fVar2 = this.aPI.aPC;
                    absMsglistView.refreshPersonalHeadFooter(userName, fVar2);
                    PersonalChatActivity personalChatActivity = this.aPI;
                    PersonalChatActivity personalChatActivity2 = this.aPI;
                    fVar3 = this.aPI.aPC;
                    personalChatActivity.aPB = personalChatActivity2.fA(com.baidu.tbadk.core.util.ay.i(fVar3.getTime()));
                    j = this.aPI.aPB;
                    if (j != 0) {
                        handler = this.aPI.mHandler;
                        runnable = this.aPI.aPF;
                        j2 = this.aPI.aPB;
                        handler.postDelayed(runnable, j2);
                    }
                    bVar = PersonalChatActivity.aPE;
                    str = this.aPI.aPD;
                    String str2 = String.valueOf(str) + "&" + user.getUserId();
                    fVar4 = this.aPI.aPC;
                    bVar.a(str2, new com.baidu.tieba.im.chat.personaltalk.a(fVar4, System.currentTimeMillis()));
                } else {
                    return;
                }
            }
            TbadkApplication.m251getInst().getAlarmManager().iP();
        }
    }
}
