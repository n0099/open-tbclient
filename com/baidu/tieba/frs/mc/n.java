package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes9.dex */
public class n implements MessageQueue.IdleHandler {
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hsB;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> hsC;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hsD;
    private FrsModelController hsy;

    public void f(FrsModelController frsModelController) {
        this.hsy = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.hsC = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.hsD = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.hsB = mvcNetMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.hsy != null) {
            this.hsy.b(this.hsC, this.hsD, this.hsB);
        }
        return false;
    }
}
