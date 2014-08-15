package com.baidu.tieba.im.mygroup;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MyGroupFragment myGroupFragment, int i) {
        super(i);
        this.a = myGroupFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.a.c = true;
    }
}
