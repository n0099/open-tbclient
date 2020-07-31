package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.q;
/* loaded from: classes16.dex */
public class n implements MessageQueue.IdleHandler {
    private q iak;
    private FrsModelController ibq;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ibt;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> ibu;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ibv;

    public void f(FrsModelController frsModelController) {
        this.ibq = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.ibu = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.ibv = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.ibt = mvcNetMessage;
    }

    public void a(q qVar) {
        this.iak = qVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.ibq != null) {
            this.ibq.b(this.ibu, this.ibv, this.ibt);
            if (this.iak != null) {
                this.iak.cbJ();
            }
        }
        return false;
    }
}
