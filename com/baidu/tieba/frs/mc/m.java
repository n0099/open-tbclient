package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes22.dex */
public class m implements MessageQueue.IdleHandler {
    private r jdc;
    private FrsModelController jeh;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> jei;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jej;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jek;

    public void g(FrsModelController frsModelController) {
        this.jeh = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.jei = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.jej = mvcHttpMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.jek = mvcNetMessage;
    }

    public void a(r rVar) {
        this.jdc = rVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.jeh != null) {
            this.jeh.b(this.jei, this.jej, this.jek);
            if (this.jdc != null) {
                this.jdc.cyz();
            }
        }
        return false;
    }
}
