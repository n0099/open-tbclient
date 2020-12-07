package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes22.dex */
public class n implements MessageQueue.IdleHandler {
    private s jrs;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jsA;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> jsB;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jsC;
    private FrsModelController jsx;

    public void g(FrsModelController frsModelController) {
        this.jsx = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.jsB = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.jsC = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jsA = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jrs = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jsx != null) {
            this.jsx.b(this.jsB, this.jsC, this.jsA);
            if (this.jrs != null) {
                this.jrs.cCs();
            }
        }
        return false;
    }
}
