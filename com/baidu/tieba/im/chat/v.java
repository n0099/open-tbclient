package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class v implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.a = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.a.closeLoadingDialog();
        com.baidu.tieba.im.messageCenter.e.a().e(new com.baidu.tieba.im.message.e());
        this.a.a.showToast(R.string.cash_del_suc, false);
    }
}
