package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes2.dex */
public class m implements MessageQueue.IdleHandler {
    private s jDQ;
    private FrsModelController jEU;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> jEV;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jEW;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jEX;

    public void g(FrsModelController frsModelController) {
        this.jEU = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.jEV = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.jEW = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jEX = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jDQ = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jEU != null) {
            this.jEU.b(this.jEV, this.jEW, this.jEX);
            if (this.jDQ != null) {
                this.jDQ.cFo();
            }
        }
        return false;
    }
}
