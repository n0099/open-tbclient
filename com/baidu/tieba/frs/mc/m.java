package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.q;
/* loaded from: classes16.dex */
public class m implements MessageQueue.IdleHandler {
    private q iam;
    private FrsModelController ibs;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> ibt;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ibu;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ibv;

    public void f(FrsModelController frsModelController) {
        this.ibs = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.ibt = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.ibu = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.ibv = mvcNetMessage;
    }

    public void a(q qVar) {
        this.iam = qVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.ibs != null) {
            this.ibs.b(this.ibt, this.ibu, this.ibv);
            if (this.iam != null) {
                this.iam.cbJ();
            }
        }
        return false;
    }
}
