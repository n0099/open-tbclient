package com.baidu.tieba.frs.mc;

import android.os.MessageQueue;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes16.dex */
public class m implements MessageQueue.IdleHandler {
    private r iou;
    private MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> ipA;
    private MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ipB;
    private MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> ipC;
    private FrsModelController ipz;

    public void f(FrsModelController frsModelController) {
        this.ipz = frsModelController;
    }

    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage) {
        this.ipA = mvcHttpResponsedMessage;
    }

    public void a(MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage) {
        this.ipB = mvcHttpMessage;
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
            this.ipz.b(this.ipA, this.ipB, this.ipC);
            if (this.iou != null) {
                this.iou.cmg();
            }
        }
        return false;
    }
}
