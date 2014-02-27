package com.baidu.tieba.im.chat;

import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
final class cm implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ ck a;
    private final /* synthetic */ com.baidu.adp.framework.message.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(ck ckVar, com.baidu.adp.framework.message.a aVar) {
        this.a = ckVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r6) {
        ((com.baidu.tieba.a.c) this.b.a()).d().setClass(((com.baidu.tieba.a.c) this.b.a()).c(), PersonalChatActivity.class);
        UserData a = ((com.baidu.tieba.a.c) this.b.a()).a();
        if (a.getUserIdLong() == 0) {
            com.baidu.adp.lib.util.e.e("userid = " + a.getUserId());
        } else {
            ((com.baidu.tieba.a.c) this.b.a()).e();
        }
    }
}
