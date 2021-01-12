package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes2.dex */
public class n implements MessageQueue.IdleHandler {
    private FrsModelController jAo;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jAr;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> jAs;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jAt;
    private s jzk;

    public void g(FrsModelController frsModelController) {
        this.jAo = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.jAs = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.jAt = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jAr = mvcNetMessage;
    }

    public void a(s sVar) {
        this.jzk = sVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jAo != null) {
            this.jAo.b(this.jAs, this.jAt, this.jAr);
            if (this.jzk != null) {
                this.jzk.cBw();
            }
        }
        return false;
    }
}
