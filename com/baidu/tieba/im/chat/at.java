package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class at implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar) {
        this.a = arVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        GroupSettingActivity groupSettingActivity;
        GroupSettingActivity groupSettingActivity2;
        groupSettingActivity = this.a.a;
        groupSettingActivity.closeLoadingDialog();
        com.baidu.tieba.im.messageCenter.d.a().e(new com.baidu.tieba.im.message.h());
        groupSettingActivity2 = this.a.a;
        groupSettingActivity2.showToast(R.string.cash_del_suc, false);
    }
}
