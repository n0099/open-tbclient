package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes9.dex */
public class m implements MessageQueue.IdleHandler {
    private FrsModelController hsE;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> hsF;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hsG;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hsH;

    public void f(FrsModelController frsModelController) {
        this.hsE = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.hsF = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.hsG = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.hsH = mvcNetMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.hsE != null) {
            this.hsE.b(this.hsF, this.hsG, this.hsH);
        }
        return false;
    }
}
