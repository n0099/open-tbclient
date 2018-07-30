package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
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
    public long aTW;
    public boolean aTX;
    public long aTY;
    public long aTZ;
    public boolean aUa;
    public long aUb;
    public long aUc;
    public long aUd;
    public long aUe;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;
    public long th;
    public long ti;

    public i() {
        this.th = 0L;
        this.ti = 0L;
        this.aTS = 0L;
        this.aTU = 0L;
        this.aTV = 0L;
        this.aTW = 0L;
        this.aTY = 0L;
        this.aTZ = 0L;
        this.aUa = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.th = 0L;
        this.ti = 0L;
        this.aTS = 0L;
        this.aTU = 0L;
        this.aTV = 0L;
        this.aTW = 0L;
        this.aTY = 0L;
        this.aTZ = 0L;
        this.aUa = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aTX = z;
            if (this.aTX) {
                this.aTW = responsedMessage.getDownSize();
                this.aUb = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aTY = responsedMessage.performanceData.vq;
                this.aTZ = responsedMessage.performanceData.vr;
                this.socketErrNo = responsedMessage.performanceData.vo;
                this.socketCostTime = responsedMessage.performanceData.vp;
            } else {
                this.aTV = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aTL = j;
            this.aTM = j2;
            this.aTT = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aTN = responsedMessage.performanceData.vg;
            this.aTO = responsedMessage.performanceData.vh;
            this.aTP = responsedMessage.performanceData.vi;
            this.th = responsedMessage.performanceData.vj;
            this.ti = responsedMessage.performanceData.vk;
            this.aTQ = responsedMessage.performanceData.vl;
            this.aTR = responsedMessage.performanceData.vm;
            this.aTS = responsedMessage.performanceData.vn;
            this.aTS += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aUa = z2;
            this.aTU = j4;
        }
    }

    public void KC() {
        o oVar = (o) m.KF().fp(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void bX(boolean z) {
        o oVar = (o) m.KF().fp(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void fn(int i) {
        o oVar = (o) m.KF().fp(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
