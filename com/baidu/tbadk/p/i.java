package com.baidu.tbadk.p;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long cAa;
    public long cAb;
    public boolean cAc;
    public long cAd;
    public long cAe;
    public long cAf;
    public long cAg;
    public long czN;
    public long czO;
    public long czP;
    public long czQ;
    public long czR;
    public long czS;
    public long czT;
    public long czU;
    public long czV;
    public long czW;
    public long czX;
    public long czY;
    public boolean czZ;
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
        this.czU = 0L;
        this.czW = 0L;
        this.czX = 0L;
        this.czY = 0L;
        this.cAa = 0L;
        this.cAb = 0L;
        this.cAc = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.ud = 0L;
        this.ue = 0L;
        this.czU = 0L;
        this.czW = 0L;
        this.czX = 0L;
        this.czY = 0L;
        this.cAa = 0L;
        this.cAb = 0L;
        this.cAc = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.czZ = z;
            if (this.czZ) {
                this.czY = responsedMessage.getDownSize();
                this.cAd = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.cAa = responsedMessage.performanceData.wh;
                this.cAb = responsedMessage.performanceData.wi;
                this.socketErrNo = responsedMessage.performanceData.wf;
                this.socketCostTime = responsedMessage.performanceData.wg;
            } else {
                this.czX = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.czN = j;
            this.czO = j2;
            this.czV = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.czP = responsedMessage.performanceData.vW;
            this.czQ = responsedMessage.performanceData.vX;
            this.czR = responsedMessage.performanceData.vY;
            this.ud = responsedMessage.performanceData.vZ;
            this.ue = responsedMessage.performanceData.wa;
            this.czS = responsedMessage.performanceData.wb;
            this.czT = responsedMessage.performanceData.wc;
            this.czU = responsedMessage.performanceData.we;
            this.czU += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.cAc = z2;
            this.czW = j4;
        }
    }

    public void avq() {
        o oVar = (o) m.avt().kT(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void fE(boolean z) {
        o oVar = (o) m.avt().kT(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void kR(int i) {
        o oVar = (o) m.avt().kT(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
