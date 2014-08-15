package com.baidu.tieba.im.mygroup;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class w extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i) {
        super(i);
        this.a = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.a.c = true;
    }
}
