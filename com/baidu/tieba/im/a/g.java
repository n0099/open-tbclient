package com.baidu.tieba.im.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
/* loaded from: classes.dex */
class g extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ c dco;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c cVar, int i) {
        super(i);
        this.dco = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePullMessage) && socketResponsedMessage.getError() == 0) {
            this.dco.aqF();
        }
    }
}
