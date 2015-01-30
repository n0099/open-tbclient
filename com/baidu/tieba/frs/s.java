package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
/* loaded from: classes.dex */
class s extends HttpMessageListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(FrsActivity frsActivity, int i) {
        super(i);
        this.aDW = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.d.a aVar;
        boolean z;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.d.a aVar2;
        if (httpResponsedMessage instanceof FrsPageHttpResponseMessage) {
            FrsPageHttpResponseMessage frsPageHttpResponseMessage = (FrsPageHttpResponseMessage) httpResponsedMessage;
            com.baidu.tieba.tbadkCore.h hVar = new com.baidu.tieba.tbadkCore.h();
            hVar.bTY = frsPageHttpResponseMessage.getError() < -13 || frsPageHttpResponseMessage.getError() > -10;
            hVar.isSuccess = !frsPageHttpResponseMessage.hasNetworkError();
            hVar.errorCode = frsPageHttpResponseMessage.getError();
            hVar.errorMsg = frsPageHttpResponseMessage.getErrorString();
            hVar.bTZ = frsPageHttpResponseMessage.getDownSize();
            xVar = this.aDW.aDG;
            xVar.a(frsPageHttpResponseMessage.getUpdateType(), false, hVar);
            this.aDW.FS();
            aVar = this.aDW.aDh;
            if (aVar != null) {
                aVar2 = this.aDW.aDh;
                aVar2.a(true, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.bTZ);
                this.aDW.aDh = null;
            }
            z = this.aDW.aDw;
            if (!z) {
                this.aDW.aDw = true;
                com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
                wVar.dX(1000);
                wVar.agY = true;
                wVar.isSuccess = hVar.isSuccess;
                wVar.agN = httpResponsedMessage.performanceData.fb;
                wVar.agO = httpResponsedMessage.performanceData.fc;
                wVar.agP = httpResponsedMessage.performanceData.fd;
                wVar.agQ = httpResponsedMessage.performanceData.fe;
                wVar.agR = httpResponsedMessage.performanceData.ff;
                wVar.agW = 0L;
                wVar.agX = hVar.bTZ;
                xVar2 = this.aDW.aDG;
                if (xVar2 != null) {
                    this.aDW.e(wVar);
                }
            }
        }
    }
}
