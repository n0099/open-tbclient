package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
/* loaded from: classes.dex */
class s extends HttpMessageListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(FrsActivity frsActivity, int i) {
        super(i);
        this.aDT = frsActivity;
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
            hVar.bTX = frsPageHttpResponseMessage.getError() < -13 || frsPageHttpResponseMessage.getError() > -10;
            hVar.isSuccess = !frsPageHttpResponseMessage.hasNetworkError();
            hVar.errorCode = frsPageHttpResponseMessage.getError();
            hVar.errorMsg = frsPageHttpResponseMessage.getErrorString();
            hVar.bTY = frsPageHttpResponseMessage.getDownSize();
            xVar = this.aDT.aDD;
            xVar.a(frsPageHttpResponseMessage.getUpdateType(), false, hVar);
            this.aDT.FM();
            aVar = this.aDT.aDe;
            if (aVar != null) {
                aVar2 = this.aDT.aDe;
                aVar2.a(true, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.bTY);
                this.aDT.aDe = null;
            }
            z = this.aDT.aDt;
            if (!z) {
                this.aDT.aDt = true;
                com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
                wVar.dX(1000);
                wVar.agV = true;
                wVar.isSuccess = hVar.isSuccess;
                wVar.agK = httpResponsedMessage.performanceData.fb;
                wVar.agL = httpResponsedMessage.performanceData.fc;
                wVar.agM = httpResponsedMessage.performanceData.fd;
                wVar.agN = httpResponsedMessage.performanceData.fe;
                wVar.agO = httpResponsedMessage.performanceData.ff;
                wVar.agT = 0L;
                wVar.agU = hVar.bTY;
                xVar2 = this.aDT.aDD;
                if (xVar2 != null) {
                    this.aDT.e(wVar);
                }
            }
        }
    }
}
