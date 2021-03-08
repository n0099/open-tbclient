package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes2.dex */
public class n implements MessageQueue.IdleHandler {
    private s jGM;
    private FrsModelController jHP;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jHS;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> jHT;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jHU;

    public void g(FrsModelController frsModelController) {
        this.jHP = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.jHT = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.jHU = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jHS = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jGM = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jHP != null) {
            this.jHP.b(this.jHT, this.jHU, this.jHS);
            if (this.jGM != null) {
                this.jGM.cCV();
            }
        }
        return false;
    }
}
