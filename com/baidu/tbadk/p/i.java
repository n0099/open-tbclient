package com.baidu.tbadk.p;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long cAa;
    public long cAb;
    public long cAc;
    public long cAd;
    public long cAe;
    public long cAf;
    public boolean cAg;
    public long cAh;
    public long cAi;
    public boolean cAj;
    public long cAk;
    public long cAl;
    public long cAm;
    public long cAn;
    public long czU;
    public long czV;
    public long czW;
    public long czX;
    public long czY;
    public long czZ;
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
        this.cAb = 0L;
        this.cAd = 0L;
        this.cAe = 0L;
        this.cAf = 0L;
        this.cAh = 0L;
        this.cAi = 0L;
        this.cAj = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.ud = 0L;
        this.ue = 0L;
        this.cAb = 0L;
        this.cAd = 0L;
        this.cAe = 0L;
        this.cAf = 0L;
        this.cAh = 0L;
        this.cAi = 0L;
        this.cAj = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.cAg = z;
            if (this.cAg) {
                this.cAf = responsedMessage.getDownSize();
                this.cAk = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.cAh = responsedMessage.performanceData.wh;
                this.cAi = responsedMessage.performanceData.wi;
                this.socketErrNo = responsedMessage.performanceData.wf;
                this.socketCostTime = responsedMessage.performanceData.wg;
            } else {
                this.cAe = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.czU = j;
            this.czV = j2;
            this.cAc = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.czW = responsedMessage.performanceData.vW;
            this.czX = responsedMessage.performanceData.vX;
            this.czY = responsedMessage.performanceData.vY;
            this.ud = responsedMessage.performanceData.vZ;
            this.ue = responsedMessage.performanceData.wa;
            this.czZ = responsedMessage.performanceData.wb;
            this.cAa = responsedMessage.performanceData.wc;
            this.cAb = responsedMessage.performanceData.we;
            this.cAb += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.cAj = z2;
            this.cAd = j4;
        }
    }

    public void avs() {
        o oVar = (o) m.avv().kU(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void fE(boolean z) {
        o oVar = (o) m.avv().kU(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void kS(int i) {
        o oVar = (o) m.avv().kU(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
