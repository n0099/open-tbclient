package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes9.dex */
public class m implements MessageQueue.IdleHandler {
    private FrsModelController hHs;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> hHt;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hHu;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hHv;

    public void f(FrsModelController frsModelController) {
        this.hHs = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.hHt = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.hHu = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.hHv = mvcNetMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.hHs != null) {
            this.hHs.b(this.hHt, this.hHu, this.hHv);
        }
        return false;
    }
}
