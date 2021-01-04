package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes2.dex */
public class n implements MessageQueue.IdleHandler {
    private s jDQ;
    private FrsModelController jEU;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jEX;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> jEY;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jEZ;

    public void g(FrsModelController frsModelController) {
        this.jEU = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.jEY = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.jEZ = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jEX = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jDQ = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jEU != null) {
            this.jEU.b(this.jEY, this.jEZ, this.jEX);
            if (this.jDQ != null) {
                this.jDQ.cFn();
            }
        }
        return false;
    }
}
