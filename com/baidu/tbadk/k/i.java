package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long aTK;
    public long aTL;
    public long aTM;
    public long aTN;
    public long aTO;
    public long aTP;
    public long aTQ;
    public long aTR;
    public long aTS;
    public long aTT;
    public long aTU;
    public long aTV;
    public boolean aTW;
    public long aTX;
    public long aTY;
    public boolean aTZ;
    public long aUa;
    public long aUb;
    public long aUc;
    public long aUd;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;
    public long tr;
    public long ts;

    public i() {
        this.tr = 0L;
        this.ts = 0L;
        this.aTR = 0L;
        this.aTT = 0L;
        this.aTU = 0L;
        this.aTV = 0L;
        this.aTX = 0L;
        this.aTY = 0L;
        this.aTZ = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.tr = 0L;
        this.ts = 0L;
        this.aTR = 0L;
        this.aTT = 0L;
        this.aTU = 0L;
        this.aTV = 0L;
        this.aTX = 0L;
        this.aTY = 0L;
        this.aTZ = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aTW = z;
            if (this.aTW) {
                this.aTV = responsedMessage.getDownSize();
                this.aUa = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aTX = responsedMessage.performanceData.vy;
                this.aTY = responsedMessage.performanceData.vz;
                this.socketErrNo = responsedMessage.performanceData.vw;
                this.socketCostTime = responsedMessage.performanceData.vx;
            } else {
                this.aTU = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aTK = j;
            this.aTL = j2;
            this.aTS = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aTM = responsedMessage.performanceData.vo;
            this.aTN = responsedMessage.performanceData.vp;
            this.aTO = responsedMessage.performanceData.vq;
            this.tr = responsedMessage.performanceData.vr;
            this.ts = responsedMessage.performanceData.vs;
            this.aTP = responsedMessage.performanceData.vt;
            this.aTQ = responsedMessage.performanceData.vu;
            this.aTR = responsedMessage.performanceData.vv;
            this.aTR += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aTZ = z2;
            this.aTT = j4;
        }
    }

    public void KH() {
        o oVar = (o) m.KK().fo(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void bZ(boolean z) {
        o oVar = (o) m.KK().fo(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void fm(int i) {
        o oVar = (o) m.KK().fo(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
