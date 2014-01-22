package com.baidu.tieba.im.chat;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class an implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ al a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.a = alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.a.closeLoadingDialog();
        com.baidu.tieba.im.messageCenter.e.a().e(new com.baidu.tieba.im.message.h());
        this.a.a.showToast(R.string.cash_del_suc, false);
    }
}
