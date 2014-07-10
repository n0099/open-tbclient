package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.GroupDeleteMsgResponsedMessage;
/* loaded from: classes.dex */
class bl implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ bj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bj bjVar) {
        this.a = bjVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        GroupSettingActivity groupSettingActivity;
        GroupSettingActivity groupSettingActivity2;
        groupSettingActivity = this.a.a;
        groupSettingActivity.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new GroupDeleteMsgResponsedMessage());
        groupSettingActivity2 = this.a.a;
        groupSettingActivity2.showToast(com.baidu.tieba.y.cash_del_suc, false);
    }
}
