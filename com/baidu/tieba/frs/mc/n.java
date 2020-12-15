package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes22.dex */
public class n implements MessageQueue.IdleHandler {
    private s jru;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jsC;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> jsD;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jsE;
    private FrsModelController jsz;

    public void g(FrsModelController frsModelController) {
        this.jsz = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.jsD = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.jsE = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jsC = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jru = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jsz != null) {
            this.jsz.b(this.jsD, this.jsE, this.jsC);
            if (this.jru != null) {
                this.jru.cCt();
            }
        }
        return false;
    }
}
