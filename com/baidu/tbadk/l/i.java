package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long aXa;
    public long aXb;
    public long aXc;
    public long aXd;
    public long aXe;
    public long aXf;
    public long aXg;
    public long aXh;
    public long aXi;
    public long aXj;
    public long aXk;
    public long aXl;
    public boolean aXm;
    public long aXn;
    public long aXo;
    public boolean aXp;
    public long aXq;
    public long aXr;
    public long aXs;
    public long aXt;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;
    public long vH;
    public long vI;

    public i() {
        this.vH = 0L;
        this.vI = 0L;
        this.aXh = 0L;
        this.aXj = 0L;
        this.aXk = 0L;
        this.aXl = 0L;
        this.aXn = 0L;
        this.aXo = 0L;
        this.aXp = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.vH = 0L;
        this.vI = 0L;
        this.aXh = 0L;
        this.aXj = 0L;
        this.aXk = 0L;
        this.aXl = 0L;
        this.aXn = 0L;
        this.aXo = 0L;
        this.aXp = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aXm = z;
            if (this.aXm) {
                this.aXl = responsedMessage.getDownSize();
                this.aXq = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aXn = responsedMessage.performanceData.xK;
                this.aXo = responsedMessage.performanceData.xL;
                this.socketErrNo = responsedMessage.performanceData.xI;
                this.socketCostTime = responsedMessage.performanceData.xJ;
            } else {
                this.aXk = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aXa = j;
            this.aXb = j2;
            this.aXi = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aXc = responsedMessage.performanceData.xA;
            this.aXd = responsedMessage.performanceData.xB;
            this.aXe = responsedMessage.performanceData.xC;
            this.vH = responsedMessage.performanceData.xD;
            this.vI = responsedMessage.performanceData.xE;
            this.aXf = responsedMessage.performanceData.xF;
            this.aXg = responsedMessage.performanceData.xG;
            this.aXh = responsedMessage.performanceData.xH;
            this.aXh += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aXp = z2;
            this.aXj = j4;
        }
    }

    public void LW() {
        o oVar = (o) m.LZ().fA(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void ck(boolean z) {
        o oVar = (o) m.LZ().fA(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void fy(int i) {
        o oVar = (o) m.LZ().fA(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
