package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
/* loaded from: classes.dex */
class r extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(FrsActivity frsActivity, int i) {
        super(i);
        this.aDW = frsActivity;
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
            hVar.bTY = fRSPageSocketResponsedMessage.getError() < -13 || fRSPageSocketResponsedMessage.getError() > -10;
            hVar.isSuccess = !fRSPageSocketResponsedMessage.hasNetworkError();
            hVar.errorCode = fRSPageSocketResponsedMessage.getError();
            hVar.errorMsg = fRSPageSocketResponsedMessage.getErrorString();
            hVar.bTZ = fRSPageSocketResponsedMessage.getDownSize();
            xVar = this.aDW.aDG;
            xVar.a(fRSPageSocketResponsedMessage.getUpdateType(), false, hVar);
            this.aDW.FS();
            aVar = this.aDW.aDh;
            if (aVar != null) {
                aVar2 = this.aDW.aDh;
                aVar2.a(false, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.bTZ);
                this.aDW.aDh = null;
            }
            z = this.aDW.aDw;
            if (!z) {
                this.aDW.aDw = true;
                com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
                wVar.dX(1000);
                wVar.agY = false;
                wVar.isSuccess = hVar.isSuccess;
                wVar.agN = socketResponsedMessage.performanceData.fb;
                wVar.agO = socketResponsedMessage.performanceData.fc;
                wVar.agP = socketResponsedMessage.performanceData.fd;
                wVar.agQ = socketResponsedMessage.performanceData.fe;
                wVar.agR = socketResponsedMessage.performanceData.ff;
                wVar.agW = hVar.bTZ;
                wVar.agX = 0L;
                xVar2 = this.aDW.aDG;
                if (xVar2 != null) {
                    this.aDW.e(wVar);
                }
            }
        }
    }
}
