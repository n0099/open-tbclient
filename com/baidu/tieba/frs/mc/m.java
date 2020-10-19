package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes22.dex */
public class m implements MessageQueue.IdleHandler {
    private r iKJ;
    private FrsModelController iLO;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> iLP;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> iLQ;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> iLR;

    public void g(FrsModelController frsModelController) {
        this.iLO = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.iLP = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.iLQ = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.iLR = mvcNetMessage;
    }

    public void a(r rVar) {
        this.iKJ = rVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.iLO != null) {
            this.iLO.b(this.iLP, this.iLQ, this.iLR);
            if (this.iKJ != null) {
                this.iKJ.csR();
            }
        }
        return false;
    }
}
