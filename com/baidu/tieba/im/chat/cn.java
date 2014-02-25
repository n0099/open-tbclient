package com.baidu.tieba.im.chat;

import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
class cn implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ cl a;
    private final /* synthetic */ com.baidu.adp.framework.message.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cl clVar, com.baidu.adp.framework.message.a aVar) {
        this.a = clVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r6) {
        ((com.baidu.tieba.a.c) this.b.a()).d().setClass(((com.baidu.tieba.a.c) this.b.a()).c(), PersonalChatActivity.class);
        UserData a = ((com.baidu.tieba.a.c) this.b.a()).a();
        if (a.getUserIdLong() == 0) {
            com.baidu.adp.lib.util.f.e("userid = " + a.getUserId());
        } else {
            ((com.baidu.tieba.a.c) this.b.a()).e();
        }
    }
}
