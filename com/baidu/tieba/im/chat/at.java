package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar) {
        this.a = arVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        GroupSettingActivity groupSettingActivity;
        GroupSettingActivity groupSettingActivity2;
        groupSettingActivity = this.a.a;
        groupSettingActivity.closeLoadingDialog();
        com.baidu.tieba.im.messageCenter.e.a().e(new com.baidu.tieba.im.message.h());
        groupSettingActivity2 = this.a.a;
        groupSettingActivity2.showToast(R.string.cash_del_suc, false);
    }
}
