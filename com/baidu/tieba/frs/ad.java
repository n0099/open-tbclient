package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class ad extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(FrsActivity frsActivity, int i) {
        super(i);
        this.a = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        dl dlVar;
        com.baidu.tieba.b.a aVar;
        com.baidu.tieba.b.a aVar2;
        if (socketResponsedMessage instanceof FRSPageSocketResponsedMessage) {
            FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) socketResponsedMessage;
            j jVar = new j();
            jVar.a = fRSPageSocketResponsedMessage.getError() < -13 || fRSPageSocketResponsedMessage.getError() > -10;
            jVar.b = !fRSPageSocketResponsedMessage.hasNetworkError();
            jVar.c = fRSPageSocketResponsedMessage.getError();
            jVar.d = fRSPageSocketResponsedMessage.getErrorString();
            jVar.e = fRSPageSocketResponsedMessage.getDownSize();
            dlVar = this.a.aj;
            dlVar.a(fRSPageSocketResponsedMessage.getUpdateType(), false, jVar);
            aVar = this.a.K;
            if (aVar != null) {
                boolean z = fRSPageSocketResponsedMessage.getError() == 0;
                aVar2 = this.a.K;
                aVar2.a(false, z, jVar.c, jVar.d, jVar.e, 0L, fRSPageSocketResponsedMessage.getCostTime());
                this.a.K = null;
            }
        }
    }
}
