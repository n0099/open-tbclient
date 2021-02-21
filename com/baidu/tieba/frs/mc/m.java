package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes2.dex */
public class m implements MessageQueue.IdleHandler {
    private s jFd;
    private FrsModelController jGg;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> jGh;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jGi;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jGj;

    public void g(FrsModelController frsModelController) {
        this.jGg = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.jGh = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.jGi = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jGj = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jFd = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jGg != null) {
            this.jGg.b(this.jGh, this.jGi, this.jGj);
            if (this.jFd != null) {
                this.jFd.cCP();
            }
        }
        return false;
    }
}
