package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
final class w implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ u a;
    private final /* synthetic */ com.baidu.adp.framework.message.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, com.baidu.adp.framework.message.a aVar) {
        this.a = uVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r6) {
        ((com.baidu.tbadk.core.b.ae) this.b.a()).d().setClass(((com.baidu.tbadk.core.b.ae) this.b.a()).c(), OfficialBarChatActivity.class);
        UserData b = ((com.baidu.tbadk.core.b.ae) this.b.a()).b();
        if (b.getUserIdLong() == 0) {
            com.baidu.adp.lib.util.f.e("userid = " + b.getUserId());
        } else {
            ((com.baidu.tbadk.core.b.ae) this.b.a()).f();
        }
    }
}
