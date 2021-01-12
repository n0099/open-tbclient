package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes2.dex */
public class m implements MessageQueue.IdleHandler {
    private FrsModelController jAo;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> jAp;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jAq;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jAr;
    private s jzk;

    public void g(FrsModelController frsModelController) {
        this.jAo = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.jAp = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.jAq = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jAr = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jzk = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jAo != null) {
            this.jAo.b(this.jAp, this.jAq, this.jAr);
            if (this.jzk != null) {
                this.jzk.cBw();
            }
        }
        return false;
    }
}
