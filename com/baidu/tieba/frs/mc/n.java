package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes22.dex */
public class n implements MessageQueue.IdleHandler {
    private r iXf;
    private FrsModelController iYk;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> iYn;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> iYo;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> iYp;

    public void g(FrsModelController frsModelController) {
        this.iYk = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.iYo = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.iYp = mvcSocketMessage;
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
            this.iYk.b(this.iYo, this.iYp, this.iYn);
            if (this.iXf != null) {
                this.iXf.cvY();
            }
        }
        return false;
    }
}
