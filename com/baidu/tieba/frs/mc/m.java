package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes21.dex */
public class m implements MessageQueue.IdleHandler {
    private r jdP;
    private FrsModelController jeU;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> jeV;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jeW;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jeX;

    public void g(FrsModelController frsModelController) {
        this.jeU = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.jeV = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.jeW = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jeX = mvcNetMessage;
    }

    public void a(r rVar) {
        this.jdP = rVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jeU != null) {
            this.jeU.b(this.jeV, this.jeW, this.jeX);
            if (this.jdP != null) {
                this.jdP.cyc();
            }
        }
        return false;
    }
}
