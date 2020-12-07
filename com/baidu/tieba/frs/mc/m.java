package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes22.dex */
public class m implements MessageQueue.IdleHandler {
    private s jrs;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jsA;
    private FrsModelController jsx;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> jsy;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jsz;

    public void g(FrsModelController frsModelController) {
        this.jsx = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.jsy = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.jsz = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jsA = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jrs = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jsx != null) {
            this.jsx.b(this.jsy, this.jsz, this.jsA);
            if (this.jrs != null) {
                this.jrs.cCs();
            }
        }
        return false;
    }
}
