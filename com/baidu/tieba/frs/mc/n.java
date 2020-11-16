package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes21.dex */
public class n implements MessageQueue.IdleHandler {
    private r jdP;
    private FrsModelController jeU;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jeX;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> jeY;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jeZ;

    public void g(FrsModelController frsModelController) {
        this.jeU = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.jeY = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.jeZ = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jeX = mvcNetMessage;
    }

    public void a(r rVar) {
        this.jdP = rVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jeU != null) {
            this.jeU.b(this.jeY, this.jeZ, this.jeX);
            if (this.jdP != null) {
                this.jdP.cyc();
            }
        }
        return false;
    }
}
