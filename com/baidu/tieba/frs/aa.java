package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class aa extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(FrsActivity frsActivity, int i) {
        super(i);
        this.a = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        di diVar;
        com.baidu.tieba.b.a aVar;
        com.baidu.tieba.b.a aVar2;
        if (socketResponsedMessage instanceof FRSPageSocketResponsedMessage) {
            FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) socketResponsedMessage;
            j jVar = new j();
            jVar.a = fRSPageSocketResponsedMessage.getError() < -13 || fRSPageSocketResponsedMessage.getError() > -10;
            jVar.b = fRSPageSocketResponsedMessage.hasNetworkError() ? false : true;
            jVar.c = fRSPageSocketResponsedMessage.getError();
            jVar.d = fRSPageSocketResponsedMessage.getErrorString();
            jVar.e = fRSPageSocketResponsedMessage.getDownSize();
            diVar = this.a.ah;
            diVar.a(fRSPageSocketResponsedMessage.getUpdateType(), false, jVar);
            aVar = this.a.G;
            if (aVar != null) {
                aVar2 = this.a.G;
                aVar2.a(false, jVar.b, jVar.c, jVar.d, jVar.e);
                this.a.G = null;
            }
        }
    }
}
