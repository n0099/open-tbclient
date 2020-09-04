package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes16.dex */
public class n implements MessageQueue.IdleHandler {
    private r ioA;
    private FrsModelController ipF;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ipI;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> ipJ;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ipK;

    public void f(FrsModelController frsModelController) {
        this.ipF = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.ipJ = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.ipK = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.ipI = mvcNetMessage;
    }

    public void a(r rVar) {
        this.ioA = rVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.ipF != null) {
            this.ipF.b(this.ipJ, this.ipK, this.ipI);
            if (this.ioA != null) {
                this.ioA.cmh();
            }
        }
        return false;
    }
}
