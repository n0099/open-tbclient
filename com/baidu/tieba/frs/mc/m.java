package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes22.dex */
public class m implements MessageQueue.IdleHandler {
    private s jru;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> jsA;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jsB;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jsC;
    private FrsModelController jsz;

    public void g(FrsModelController frsModelController) {
        this.jsz = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.jsA = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.jsB = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jsC = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jru = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jsz != null) {
            this.jsz.b(this.jsA, this.jsB, this.jsC);
            if (this.jru != null) {
                this.jru.cCt();
            }
        }
        return false;
    }
}
