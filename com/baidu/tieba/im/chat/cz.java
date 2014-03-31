package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
final class cz implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ cx a;
    private final /* synthetic */ com.baidu.adp.framework.message.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cx cxVar, com.baidu.adp.framework.message.a aVar) {
        this.a = cxVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r6) {
        ((com.baidu.tbadk.core.b.ah) this.b.a()).d().setClass(((com.baidu.tbadk.core.b.ah) this.b.a()).c(), PersonalChatActivity.class);
        UserData b = ((com.baidu.tbadk.core.b.ah) this.b.a()).b();
        if (b.getUserIdLong() == 0) {
            com.baidu.adp.lib.util.f.e("userid = " + b.getUserId());
        } else {
            ((com.baidu.tbadk.core.b.ah) this.b.a()).f();
        }
    }
}
