package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ h aTR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.aTR = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        long j;
        PersonalTalkSettingActivity personalTalkSettingActivity4;
        long j2;
        personalTalkSettingActivity = this.aTR.aTQ;
        personalTalkSettingActivity.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
        personalTalkSettingActivity2 = this.aTR.aTQ;
        personalTalkSettingActivity2.showToast(z.cash_del_suc, false);
        personalTalkSettingActivity3 = this.aTR.aTQ;
        j = personalTalkSettingActivity3.userId;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.f(String.valueOf(j), 2, null, 1)));
        StringBuilder sb = new StringBuilder("clear cache by person:");
        personalTalkSettingActivity4 = this.aTR.aTQ;
        j2 = personalTalkSettingActivity4.userId;
        BdSocketLinkService.startService(true, sb.append(j2).toString());
    }
}
