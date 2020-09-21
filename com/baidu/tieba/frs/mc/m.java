package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes21.dex */
public class m implements MessageQueue.IdleHandler {
    private r ivQ;
    private FrsModelController iwV;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> iwW;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> iwX;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> iwY;

    public void g(FrsModelController frsModelController) {
        this.iwV = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.iwW = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.iwX = mvcHttpMessage;
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
            this.iwV.b(this.iwW, this.iwX, this.iwY);
            if (this.ivQ != null) {
                this.ivQ.cpt();
            }
        }
        return false;
    }
}
