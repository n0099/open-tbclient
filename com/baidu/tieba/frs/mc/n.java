package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes9.dex */
public class n implements MessageQueue.IdleHandler {
    private FrsModelController hIf;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hIi;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> hIj;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hIk;

    public void f(FrsModelController frsModelController) {
        this.hIf = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.hIj = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.hIk = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.hIi = mvcNetMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.hIf != null) {
            this.hIf.b(this.hIj, this.hIk, this.hIi);
        }
        return false;
    }
}
