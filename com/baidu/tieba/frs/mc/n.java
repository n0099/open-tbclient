package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes16.dex */
public class n implements MessageQueue.IdleHandler {
    private r iou;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ipC;
    private MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> ipD;
    private MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ipE;
    private FrsModelController ipz;

    public void f(FrsModelController frsModelController) {
        this.ipz = frsModelController;
    }

    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage) {
        this.ipD = mvcSocketResponsedMessage;
    }

    public void a(MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage) {
        this.ipE = mvcSocketMessage;
    }

    public void a(MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        this.ipC = mvcNetMessage;
    }

    public void a(r rVar) {
        this.iou = rVar;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (this.ipz != null) {
            this.ipz.b(this.ipD, this.ipE, this.ipC);
            if (this.iou != null) {
                this.iou.cmg();
            }
        }
        return false;
    }
}
