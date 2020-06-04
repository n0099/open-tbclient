package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes9.dex */
public class m implements MessageQueue.IdleHandler {
    private FrsModelController hIf;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> hIg;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hIh;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hIi;

    public void f(FrsModelController frsModelController) {
        this.hIf = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.hIg = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.hIh = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.hIi = mvcNetMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.hIf != null) {
            this.hIf.b(this.hIg, this.hIh, this.hIi);
        }
        return false;
    }
}
