package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.q;
/* loaded from: classes16.dex */
public class m implements MessageQueue.IdleHandler {
    private q iak;
    private FrsModelController ibq;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> ibr;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ibs;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ibt;

    public void f(FrsModelController frsModelController) {
        this.ibq = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.ibr = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.ibs = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.ibt = mvcNetMessage;
    }

    public void a(q qVar) {
        this.iak = qVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.ibq != null) {
            this.ibq.b(this.ibr, this.ibs, this.ibt);
            if (this.iak != null) {
                this.iak.cbJ();
            }
        }
        return false;
    }
}
