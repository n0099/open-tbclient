package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
/* loaded from: classes.dex */
class r extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(FrsActivity frsActivity, int i) {
        super(i);
        this.aDT = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.d.a aVar;
        boolean z;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.d.a aVar2;
        if (socketResponsedMessage instanceof FRSPageSocketResponsedMessage) {
            FRSPageSocketResponsedMessage fRSPageSocketResponsedMessage = (FRSPageSocketResponsedMessage) socketResponsedMessage;
            com.baidu.tieba.tbadkCore.h hVar = new com.baidu.tieba.tbadkCore.h();
            hVar.bTX = fRSPageSocketResponsedMessage.getError() < -13 || fRSPageSocketResponsedMessage.getError() > -10;
            hVar.isSuccess = !fRSPageSocketResponsedMessage.hasNetworkError();
            hVar.errorCode = fRSPageSocketResponsedMessage.getError();
            hVar.errorMsg = fRSPageSocketResponsedMessage.getErrorString();
            hVar.bTY = fRSPageSocketResponsedMessage.getDownSize();
            xVar = this.aDT.aDD;
            xVar.a(fRSPageSocketResponsedMessage.getUpdateType(), false, hVar);
            this.aDT.FM();
            aVar = this.aDT.aDe;
            if (aVar != null) {
                aVar2 = this.aDT.aDe;
                aVar2.a(false, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.bTY);
                this.aDT.aDe = null;
            }
            z = this.aDT.aDt;
            if (!z) {
                this.aDT.aDt = true;
                com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
                wVar.dX(1000);
                wVar.agV = false;
                wVar.isSuccess = hVar.isSuccess;
                wVar.agK = socketResponsedMessage.performanceData.fb;
                wVar.agL = socketResponsedMessage.performanceData.fc;
                wVar.agM = socketResponsedMessage.performanceData.fd;
                wVar.agN = socketResponsedMessage.performanceData.fe;
                wVar.agO = socketResponsedMessage.performanceData.ff;
                wVar.agT = hVar.bTY;
                wVar.agU = 0L;
                xVar2 = this.aDT.aDD;
                if (xVar2 != null) {
                    this.aDT.e(wVar);
                }
            }
        }
    }
}
