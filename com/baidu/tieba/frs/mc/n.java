package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes21.dex */
public class n implements MessageQueue.IdleHandler {
    private r ivQ;
    private FrsModelController iwV;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> iwY;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> iwZ;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ixa;

    public void g(FrsModelController frsModelController) {
        this.iwV = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.iwZ = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.ixa = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.iwY = mvcNetMessage;
    }

    public void a(r rVar) {
        this.ivQ = rVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.iwV != null) {
            this.iwV.b(this.iwZ, this.ixa, this.iwY);
            if (this.ivQ != null) {
                this.ivQ.cpt();
            }
        }
        return false;
    }
}
