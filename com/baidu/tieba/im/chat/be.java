package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class be extends com.baidu.adp.framework.c.a {
    final /* synthetic */ GroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(GroupChatActivity groupChatActivity, int i) {
        super(2001125);
        this.a = groupChatActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.p.a();
        if (com.baidu.tieba.im.p.f()) {
            this.a.d.Q().setVisibility(0);
            this.a.d.Q().d();
        }
    }
}
