package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tieba.im.message.GroupDeleteMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
/* loaded from: classes.dex */
class i implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ g aSF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.aSF = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        long j;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        long j2;
        personalTalkSettingActivity = this.aSF.aSE;
        personalTalkSettingActivity.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new GroupDeleteMsgResponsedMessage());
        personalTalkSettingActivity2 = this.aSF.aSE;
        j = personalTalkSettingActivity2.userId;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.f(String.valueOf(j), 2, null, 1)));
        StringBuilder sb = new StringBuilder("clear cache by person:");
        personalTalkSettingActivity3 = this.aSF.aSE;
        j2 = personalTalkSettingActivity3.userId;
        BdSocketLinkService.startService(true, sb.append(j2).toString());
    }
}
