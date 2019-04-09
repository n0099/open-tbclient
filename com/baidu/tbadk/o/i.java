package com.baidu.tbadk.o;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long cqA;
    public long cqB;
    public boolean cqC;
    public long cqD;
    public long cqE;
    public boolean cqF;
    public long cqG;
    public long cqH;
    public long cqI;
    public long cqJ;
    public long cqq;
    public long cqr;
    public long cqs;
    public long cqt;
    public long cqu;
    public long cqv;
    public long cqw;
    public long cqx;
    public long cqy;
    public long cqz;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;
    public long wu;
    public long wv;

    public i() {
        this.wu = 0L;
        this.wv = 0L;
        this.cqx = 0L;
        this.cqz = 0L;
        this.cqA = 0L;
        this.cqB = 0L;
        this.cqD = 0L;
        this.cqE = 0L;
        this.cqF = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.wu = 0L;
        this.wv = 0L;
        this.cqx = 0L;
        this.cqz = 0L;
        this.cqA = 0L;
        this.cqB = 0L;
        this.cqD = 0L;
        this.cqE = 0L;
        this.cqF = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.cqC = z;
            if (this.cqC) {
                this.cqB = responsedMessage.getDownSize();
                this.cqG = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.cqD = responsedMessage.performanceData.yv;
                this.cqE = responsedMessage.performanceData.yw;
                this.socketErrNo = responsedMessage.performanceData.yt;
                this.socketCostTime = responsedMessage.performanceData.yu;
            } else {
                this.cqA = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.cqq = j;
            this.cqr = j2;
            this.cqy = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.cqs = responsedMessage.performanceData.yl;
            this.cqt = responsedMessage.performanceData.ym;
            this.cqu = responsedMessage.performanceData.yn;
            this.wu = responsedMessage.performanceData.yo;
            this.wv = responsedMessage.performanceData.yp;
            this.cqv = responsedMessage.performanceData.yq;
            this.cqw = responsedMessage.performanceData.yr;
            this.cqx = responsedMessage.performanceData.ys;
            this.cqx += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.cqF = z2;
            this.cqz = j4;
        }
    }

    public void apd() {
        o oVar = (o) m.apg().jZ(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void fe(boolean z) {
        o oVar = (o) m.apg().jZ(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void jX(int i) {
        o oVar = (o) m.apg().jZ(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
