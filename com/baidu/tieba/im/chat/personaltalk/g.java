package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.db.ae;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        long j;
        this.a.a.closeLoadingDialog();
        com.baidu.tieba.im.messageCenter.e.a().e(new com.baidu.tieba.im.message.h());
        ae.a().a(new h(this));
        StringBuilder append = new StringBuilder().append("clear cache by person:");
        j = this.a.a.c;
        TiebaSocketLinkService.a(true, append.append(j).toString());
    }
}
