package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.GroupDeleteMsgResponsedMessage;
/* loaded from: classes.dex */
final class bm implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bk bkVar) {
        this.a = bkVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        GroupSettingActivity groupSettingActivity;
        GroupSettingActivity groupSettingActivity2;
        groupSettingActivity = this.a.a;
        groupSettingActivity.closeLoadingDialog();
        com.baidu.adp.framework.c.a().b(new GroupDeleteMsgResponsedMessage());
        groupSettingActivity2 = this.a.a;
        groupSettingActivity2.showToast(com.baidu.tieba.im.j.cash_del_suc, false);
    }
}
