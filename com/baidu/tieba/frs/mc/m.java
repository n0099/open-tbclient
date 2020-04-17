package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes9.dex */
public class m implements MessageQueue.IdleHandler {
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hsA;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hsB;
    private FrsModelController hsy;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> hsz;

    public void f(FrsModelController frsModelController) {
        this.hsy = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.hsz = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.hsA = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.hsB = mvcNetMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.hsy != null) {
            this.hsy.b(this.hsz, this.hsA, this.hsB);
        }
        return false;
    }
}
