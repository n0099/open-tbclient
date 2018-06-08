package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long aSO;
    public long aSP;
    public long aSQ;
    public long aSR;
    public long aSS;
    public long aST;
    public long aSU;
    public long aSV;
    public long aSW;
    public long aSX;
    public long aSY;
    public long aSZ;
    public boolean aTa;
    public long aTb;
    public long aTc;
    public boolean aTd;
    public long aTe;
    public long aTf;
    public long aTg;
    public long aTh;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;
    public long tt;
    public long tu;

    public i() {
        this.tt = 0L;
        this.tu = 0L;
        this.aSV = 0L;
        this.aSX = 0L;
        this.aSY = 0L;
        this.aSZ = 0L;
        this.aTb = 0L;
        this.aTc = 0L;
        this.aTd = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.tt = 0L;
        this.tu = 0L;
        this.aSV = 0L;
        this.aSX = 0L;
        this.aSY = 0L;
        this.aSZ = 0L;
        this.aTb = 0L;
        this.aTc = 0L;
        this.aTd = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aTa = z;
            if (this.aTa) {
                this.aSZ = responsedMessage.getDownSize();
                this.aTe = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aTb = responsedMessage.performanceData.vA;
                this.aTc = responsedMessage.performanceData.vB;
                this.socketErrNo = responsedMessage.performanceData.vy;
                this.socketCostTime = responsedMessage.performanceData.vz;
            } else {
                this.aSY = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aSO = j;
            this.aSP = j2;
            this.aSW = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aSQ = responsedMessage.performanceData.vq;
            this.aSR = responsedMessage.performanceData.vr;
            this.aSS = responsedMessage.performanceData.vs;
            this.tt = responsedMessage.performanceData.vt;
            this.tu = responsedMessage.performanceData.vu;
            this.aST = responsedMessage.performanceData.vv;
            this.aSU = responsedMessage.performanceData.vw;
            this.aSV = responsedMessage.performanceData.vx;
            this.aSV += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aTd = z2;
            this.aSX = j4;
        }
    }

    public void Kp() {
        o oVar = (o) m.Ks().fn(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void bW(boolean z) {
        o oVar = (o) m.Ks().fn(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void fl(int i) {
        o oVar = (o) m.Ks().fn(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
