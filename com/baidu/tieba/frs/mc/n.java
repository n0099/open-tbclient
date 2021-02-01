package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes2.dex */
public class n implements MessageQueue.IdleHandler {
    private s jEP;
    private FrsModelController jFS;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jFV;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> jFW;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jFX;

    public void g(FrsModelController frsModelController) {
        this.jFS = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.jFW = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.jFX = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jFV = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jEP = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jFS != null) {
            this.jFS.b(this.jFW, this.jFX, this.jFV);
            if (this.jEP != null) {
                this.jEP.cCI();
            }
        }
        return false;
    }
}
