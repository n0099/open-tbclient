package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
/* loaded from: classes9.dex */
public class n implements MessageQueue.IdleHandler {
    private FrsModelController gJi;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> gJl;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> gJm;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> gJn;

    public void f(FrsModelController frsModelController) {
        this.gJi = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.gJm = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.gJn = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.gJl = mvcNetMessage;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.gJi != null) {
            this.gJi.b(this.gJm, this.gJn, this.gJl);
        }
        return false;
    }
}
