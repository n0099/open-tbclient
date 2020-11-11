package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes22.dex */
public class n implements MessageQueue.IdleHandler {
    private r jdc;
    private FrsModelController jeh;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jek;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> jel;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> jem;

    public void g(FrsModelController frsModelController) {
        this.jeh = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.jel = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.jem = mvcSocketMessage;
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
            this.jeh.b(this.jel, this.jem, this.jek);
            if (this.jdc != null) {
                this.jdc.cyz();
            }
        }
        return false;
    }
}
