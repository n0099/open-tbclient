package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes22.dex */
public class n implements MessageQueue.IdleHandler {
    private r iKJ;
    private FrsModelController iLO;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> iLR;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> iLS;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> iLT;

    public void g(FrsModelController frsModelController) {
        this.iLO = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.iLS = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.iLT = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.iLR = mvcNetMessage;
    }

    public void a(r rVar) {
        this.iKJ = rVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.iLO != null) {
            this.iLO.b(this.iLS, this.iLT, this.iLR);
            if (this.iKJ != null) {
                this.iKJ.csR();
            }
        }
        return false;
    }
}
