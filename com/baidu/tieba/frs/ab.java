package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class ab extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(FrsActivity frsActivity, int i) {
        super(i);
        this.a = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        dg dgVar;
        if (socketResponsedMessage instanceof FRSPageSocketResponsedMessage) {
            FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) socketResponsedMessage;
            j jVar = new j();
            jVar.a = true;
            jVar.b = fRSPageSocketResponsedMessage.hasNetworkError() ? false : true;
            jVar.c = fRSPageSocketResponsedMessage.getError();
            jVar.d = fRSPageSocketResponsedMessage.getErrorString();
            jVar.e = fRSPageSocketResponsedMessage.getmDownSize();
            dgVar = this.a.ae;
            dgVar.a(fRSPageSocketResponsedMessage.getUpdateType(), false, jVar);
        }
    }
}
