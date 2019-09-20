package com.baidu.tbadk.p;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long cAQ;
    public long cAR;
    public long cAS;
    public long cAT;
    public long cAU;
    public long cAV;
    public long cAW;
    public long cAX;
    public long cAY;
    public long cAZ;
    public long cBa;
    public long cBb;
    public boolean cBc;
    public long cBd;
    public long cBe;
    public boolean cBf;
    public long cBg;
    public long cBh;
    public long cBi;
    public long cBj;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;
    public long ud;
    public long ue;

    public i() {
        this.ud = 0L;
        this.ue = 0L;
        this.cAX = 0L;
        this.cAZ = 0L;
        this.cBa = 0L;
        this.cBb = 0L;
        this.cBd = 0L;
        this.cBe = 0L;
        this.cBf = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.ud = 0L;
        this.ue = 0L;
        this.cAX = 0L;
        this.cAZ = 0L;
        this.cBa = 0L;
        this.cBb = 0L;
        this.cBd = 0L;
        this.cBe = 0L;
        this.cBf = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.cBc = z;
            if (this.cBc) {
                this.cBb = responsedMessage.getDownSize();
                this.cBg = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.cBd = responsedMessage.performanceData.wh;
                this.cBe = responsedMessage.performanceData.wi;
                this.socketErrNo = responsedMessage.performanceData.wf;
                this.socketCostTime = responsedMessage.performanceData.wg;
            } else {
                this.cBa = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.cAQ = j;
            this.cAR = j2;
            this.cAY = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.cAS = responsedMessage.performanceData.vW;
            this.cAT = responsedMessage.performanceData.vX;
            this.cAU = responsedMessage.performanceData.vY;
            this.ud = responsedMessage.performanceData.vZ;
            this.ue = responsedMessage.performanceData.wa;
            this.cAV = responsedMessage.performanceData.wb;
            this.cAW = responsedMessage.performanceData.wc;
            this.cAX = responsedMessage.performanceData.we;
            this.cAX += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.cBf = z2;
            this.cAZ = j4;
        }
    }

    public void avE() {
        o oVar = (o) m.avH().kX(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void fH(boolean z) {
        o oVar = (o) m.avH().kX(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void kV(int i) {
        o oVar = (o) m.avH().kX(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
