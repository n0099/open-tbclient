package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class w extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(FrsActivity frsActivity, int i) {
        super(i);
        this.aBk = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        dd ddVar;
        com.baidu.tieba.b.a aVar;
        com.baidu.tieba.b.a aVar2;
        if (socketResponsedMessage instanceof FRSPageSocketResponsedMessage) {
            FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) socketResponsedMessage;
            e eVar = new e();
            eVar.aAc = fRSPageSocketResponsedMessage.getError() < -13 || fRSPageSocketResponsedMessage.getError() > -10;
            eVar.isSuccess = fRSPageSocketResponsedMessage.hasNetworkError() ? false : true;
            eVar.errorCode = fRSPageSocketResponsedMessage.getError();
            eVar.errorMsg = fRSPageSocketResponsedMessage.getErrorString();
            eVar.aAd = fRSPageSocketResponsedMessage.getDownSize();
            ddVar = this.aBk.aAT;
            ddVar.a(fRSPageSocketResponsedMessage.getUpdateType(), false, eVar);
            aVar = this.aBk.aAE;
            if (aVar != null) {
                aVar2 = this.aBk.aAE;
                aVar2.a(false, eVar.isSuccess, eVar.errorCode, eVar.errorMsg, eVar.aAd);
                this.aBk.aAE = null;
            }
        }
    }
}
