package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes22.dex */
public class m implements MessageQueue.IdleHandler {
    private r iXf;
    private FrsModelController iYk;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> iYl;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> iYm;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> iYn;

    public void g(FrsModelController frsModelController) {
        this.iYk = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.iYl = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.iYm = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.iYn = mvcNetMessage;
    }

    public void a(r rVar) {
        this.iXf = rVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.iYk != null) {
            this.iYk.b(this.iYl, this.iYm, this.iYn);
            if (this.iXf != null) {
                this.iXf.cvY();
            }
        }
        return false;
    }
}
