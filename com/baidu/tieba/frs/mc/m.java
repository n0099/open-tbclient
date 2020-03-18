package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes9.dex */
public class m implements MessageQueue.IdleHandler {
    private FrsModelController gJi;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> gJj;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> gJk;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> gJl;

    public void f(FrsModelController frsModelController) {
        this.gJi = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.gJj = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.gJk = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.gJl = mvcNetMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.gJi != null) {
            this.gJi.b(this.gJj, this.gJk, this.gJl);
        }
        return false;
    }
}
