package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.GroupDeleteMsgResponsedMessage;
/* loaded from: classes.dex */
class bk implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ bi aOD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bi biVar) {
        this.aOD = biVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        GroupSettingActivity groupSettingActivity;
        GroupSettingActivity groupSettingActivity2;
        groupSettingActivity = this.aOD.aOC;
        groupSettingActivity.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new GroupDeleteMsgResponsedMessage());
        groupSettingActivity2 = this.aOD.aOC;
        groupSettingActivity2.showToast(com.baidu.tieba.y.cash_del_suc, false);
    }
}
