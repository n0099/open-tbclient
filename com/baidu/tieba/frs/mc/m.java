package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes16.dex */
public class m implements MessageQueue.IdleHandler {
    private r ioA;
    private FrsModelController ipF;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> ipG;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ipH;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ipI;

    public void f(FrsModelController frsModelController) {
        this.ipF = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.ipG = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.ipH = mvcHttpMessage;
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
            this.ipF.b(this.ipG, this.ipH, this.ipI);
            if (this.ioA != null) {
                this.ioA.cmh();
            }
        }
        return false;
    }
}
