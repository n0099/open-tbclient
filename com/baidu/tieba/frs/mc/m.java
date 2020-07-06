package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.q;
/* loaded from: classes9.dex */
public class m implements MessageQueue.IdleHandler {
    private q hUl;
    private FrsModelController hVr;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> hVs;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hVt;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> hVu;

    public void f(FrsModelController frsModelController) {
        this.hVr = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.hVs = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.hVt = mvcHttpMessage;
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
            this.hVr.b(this.hVs, this.hVt, this.hVu);
            if (this.hUl != null) {
                this.hUl.bYo();
            }
        }
        return false;
    }
}
