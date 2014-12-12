package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
/* loaded from: classes.dex */
class r extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(FrsActivity frsActivity, int i) {
        super(i);
        this.aCV = frsActivity;
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
            hVar.bSk = fRSPageSocketResponsedMessage.getError() < -13 || fRSPageSocketResponsedMessage.getError() > -10;
            hVar.isSuccess = !fRSPageSocketResponsedMessage.hasNetworkError();
            hVar.errorCode = fRSPageSocketResponsedMessage.getError();
            hVar.errorMsg = fRSPageSocketResponsedMessage.getErrorString();
            hVar.bSl = fRSPageSocketResponsedMessage.getDownSize();
            xVar = this.aCV.aCF;
            xVar.a(fRSPageSocketResponsedMessage.getUpdateType(), false, hVar);
            this.aCV.Fu();
            aVar = this.aCV.aCg;
            if (aVar != null) {
                aVar2 = this.aCV.aCg;
                aVar2.a(false, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.bSl);
                this.aCV.aCg = null;
            }
            z = this.aCV.aCv;
            if (!z) {
                this.aCV.aCv = true;
                com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
                wVar.dR(1000);
                wVar.agA = false;
                wVar.isSuccess = hVar.isSuccess;
                wVar.agp = socketResponsedMessage.performanceData.eZ;
                wVar.agq = socketResponsedMessage.performanceData.fa;
                wVar.agr = socketResponsedMessage.performanceData.fb;
                wVar.ags = socketResponsedMessage.performanceData.fc;
                wVar.agt = socketResponsedMessage.performanceData.fd;
                wVar.agy = hVar.bSl;
                wVar.agz = 0L;
                xVar2 = this.aCV.aCF;
                if (xVar2 != null) {
                    this.aCV.e(wVar);
                }
            }
        }
    }
}
