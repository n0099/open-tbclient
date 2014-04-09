package com.baidu.tieba.im.mygroup;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
final class c extends com.baidu.adp.framework.c.g {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MyGroupFragment myGroupFragment, int i) {
        super(0);
        this.a = myGroupFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* bridge */ /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        this.a.c = true;
    }
}
