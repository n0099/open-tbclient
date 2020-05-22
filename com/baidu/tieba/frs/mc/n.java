package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes9.dex */
public class n implements MessageQueue.IdleHandler {
    private FrsModelController hHs;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hHv;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> hHw;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hHx;

    public void f(FrsModelController frsModelController) {
        this.hHs = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.hHw = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.hHx = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.hHv = mvcNetMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.hHs != null) {
            this.hHs.b(this.hHw, this.hHx, this.hHv);
        }
        return false;
    }
}
