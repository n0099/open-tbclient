package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes2.dex */
public class n implements MessageQueue.IdleHandler {
    private s jFd;
    private FrsModelController jGg;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jGj;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> jGk;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jGl;

    public void g(FrsModelController frsModelController) {
        this.jGg = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.jGk = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.jGl = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jGj = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jFd = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jGg != null) {
            this.jGg.b(this.jGk, this.jGl, this.jGj);
            if (this.jFd != null) {
                this.jFd.cCP();
            }
        }
        return false;
    }
}
