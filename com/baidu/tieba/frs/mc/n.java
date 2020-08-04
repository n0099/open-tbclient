package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.q;
/* loaded from: classes16.dex */
public class n implements MessageQueue.IdleHandler {
    private q iam;
    private FrsModelController ibs;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ibv;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> ibw;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ibx;

    public void f(FrsModelController frsModelController) {
        this.ibs = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.ibw = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.ibx = mvcSocketMessage;
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
            this.ibs.b(this.ibw, this.ibx, this.ibv);
            if (this.iam != null) {
                this.iam.cbJ();
            }
        }
        return false;
    }
}
