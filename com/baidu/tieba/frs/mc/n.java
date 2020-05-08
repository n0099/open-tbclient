package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes9.dex */
public class n implements MessageQueue.IdleHandler {
    private FrsModelController hsE;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hsH;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> hsI;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hsJ;

    public void f(FrsModelController frsModelController) {
        this.hsE = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.hsI = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.hsJ = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.hsH = mvcNetMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.hsE != null) {
            this.hsE.b(this.hsI, this.hsJ, this.hsH);
        }
        return false;
    }
}
