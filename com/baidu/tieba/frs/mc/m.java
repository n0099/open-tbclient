package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes2.dex */
public class m implements MessageQueue.IdleHandler {
    private s jEP;
    private FrsModelController jFS;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> jFT;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jFU;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jFV;

    public void g(FrsModelController frsModelController) {
        this.jFS = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.jFT = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.jFU = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jFV = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jEP = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jFS != null) {
            this.jFS.b(this.jFT, this.jFU, this.jFV);
            if (this.jEP != null) {
                this.jEP.cCI();
            }
        }
        return false;
    }
}
