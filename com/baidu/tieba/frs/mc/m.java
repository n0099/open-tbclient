package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes2.dex */
public class m implements MessageQueue.IdleHandler {
    private s jGM;
    private FrsModelController jHP;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> jHQ;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jHR;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jHS;

    public void g(FrsModelController frsModelController) {
        this.jHP = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.jHQ = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.jHR = mvcHttpMessage;
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
            this.jHP.b(this.jHQ, this.jHR, this.jHS);
            if (this.jGM != null) {
                this.jGM.cCV();
            }
        }
        return false;
    }
}
