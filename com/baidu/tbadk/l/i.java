package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long bcA;
    public long bcB;
    public boolean bcC;
    public long bcD;
    public long bcE;
    public long bcF;
    public long bcG;
    public long bcn;
    public long bco;
    public long bcp;
    public long bcq;
    public long bcr;
    public long bcs;
    public long bct;
    public long bcu;
    public long bcv;
    public long bcw;
    public long bcx;
    public long bcy;
    public boolean bcz;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;
    public long wx;
    public long wy;

    public i() {
        this.wx = 0L;
        this.wy = 0L;
        this.bcu = 0L;
        this.bcw = 0L;
        this.bcx = 0L;
        this.bcy = 0L;
        this.bcA = 0L;
        this.bcB = 0L;
        this.bcC = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.wx = 0L;
        this.wy = 0L;
        this.bcu = 0L;
        this.bcw = 0L;
        this.bcx = 0L;
        this.bcy = 0L;
        this.bcA = 0L;
        this.bcB = 0L;
        this.bcC = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.bcz = z;
            if (this.bcz) {
                this.bcy = responsedMessage.getDownSize();
                this.bcD = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.bcA = responsedMessage.performanceData.yz;
                this.bcB = responsedMessage.performanceData.yA;
                this.socketErrNo = responsedMessage.performanceData.yx;
                this.socketCostTime = responsedMessage.performanceData.yy;
            } else {
                this.bcx = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.bcn = j;
            this.bco = j2;
            this.bcv = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.bcp = responsedMessage.performanceData.yp;
            this.bcq = responsedMessage.performanceData.yq;
            this.bcr = responsedMessage.performanceData.yr;
            this.wx = responsedMessage.performanceData.ys;
            this.wy = responsedMessage.performanceData.yt;
            this.bcs = responsedMessage.performanceData.yu;
            this.bct = responsedMessage.performanceData.yv;
            this.bcu = responsedMessage.performanceData.yw;
            this.bcu += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.bcC = z2;
            this.bcw = j4;
        }
    }

    public void Od() {
        o oVar = (o) m.Og().fX(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void cK(boolean z) {
        o oVar = (o) m.Og().fX(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void fV(int i) {
        o oVar = (o) m.Og().fX(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
