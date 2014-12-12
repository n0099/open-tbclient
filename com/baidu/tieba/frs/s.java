package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
/* loaded from: classes.dex */
class s extends HttpMessageListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(FrsActivity frsActivity, int i) {
        super(i);
        this.aCV = frsActivity;
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
            hVar.bSk = frsPageHttpResponseMessage.getError() < -13 || frsPageHttpResponseMessage.getError() > -10;
            hVar.isSuccess = !frsPageHttpResponseMessage.hasNetworkError();
            hVar.errorCode = frsPageHttpResponseMessage.getError();
            hVar.errorMsg = frsPageHttpResponseMessage.getErrorString();
            hVar.bSl = frsPageHttpResponseMessage.getDownSize();
            xVar = this.aCV.aCF;
            xVar.a(frsPageHttpResponseMessage.getUpdateType(), false, hVar);
            this.aCV.Fu();
            aVar = this.aCV.aCg;
            if (aVar != null) {
                aVar2 = this.aCV.aCg;
                aVar2.a(true, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.bSl);
                this.aCV.aCg = null;
            }
            z = this.aCV.aCv;
            if (!z) {
                this.aCV.aCv = true;
                com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
                wVar.dR(1000);
                wVar.agA = true;
                wVar.isSuccess = hVar.isSuccess;
                wVar.agp = httpResponsedMessage.performanceData.eZ;
                wVar.agq = httpResponsedMessage.performanceData.fa;
                wVar.agr = httpResponsedMessage.performanceData.fb;
                wVar.ags = httpResponsedMessage.performanceData.fc;
                wVar.agt = httpResponsedMessage.performanceData.fd;
                wVar.agy = 0L;
                wVar.agz = hVar.bSl;
                xVar2 = this.aCV.aCF;
                if (xVar2 != null) {
                    this.aCV.e(wVar);
                }
            }
        }
    }
}
