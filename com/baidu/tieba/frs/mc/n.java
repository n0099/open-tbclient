package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.q;
/* loaded from: classes9.dex */
public class n implements MessageQueue.IdleHandler {
    private q hUl;
    private FrsModelController hVr;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hVu;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> hVv;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hVw;

    public void f(FrsModelController frsModelController) {
        this.hVr = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.hVv = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.hVw = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.hVu = mvcNetMessage;
    }

    public void a(q qVar) {
        this.hUl = qVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.hVr != null) {
            this.hVr.b(this.hVv, this.hVw, this.hVu);
            if (this.hUl != null) {
                this.hUl.bYn();
            }
        }
        return false;
    }
}
