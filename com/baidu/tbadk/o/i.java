package com.baidu.tbadk.o;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long cqA;
    public boolean cqB;
    public long cqC;
    public long cqD;
    public boolean cqE;
    public long cqF;
    public long cqG;
    public long cqH;
    public long cqI;
    public long cqp;
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
        this.cqw = 0L;
        this.cqy = 0L;
        this.cqz = 0L;
        this.cqA = 0L;
        this.cqC = 0L;
        this.cqD = 0L;
        this.cqE = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.wu = 0L;
        this.wv = 0L;
        this.cqw = 0L;
        this.cqy = 0L;
        this.cqz = 0L;
        this.cqA = 0L;
        this.cqC = 0L;
        this.cqD = 0L;
        this.cqE = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.cqB = z;
            if (this.cqB) {
                this.cqA = responsedMessage.getDownSize();
                this.cqF = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.cqC = responsedMessage.performanceData.yv;
                this.cqD = responsedMessage.performanceData.yw;
                this.socketErrNo = responsedMessage.performanceData.yt;
                this.socketCostTime = responsedMessage.performanceData.yu;
            } else {
                this.cqz = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.cqp = j;
            this.cqq = j2;
            this.cqx = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.cqr = responsedMessage.performanceData.yl;
            this.cqs = responsedMessage.performanceData.ym;
            this.cqt = responsedMessage.performanceData.yn;
            this.wu = responsedMessage.performanceData.yo;
            this.wv = responsedMessage.performanceData.yp;
            this.cqu = responsedMessage.performanceData.yq;
            this.cqv = responsedMessage.performanceData.yr;
            this.cqw = responsedMessage.performanceData.ys;
            this.cqw += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.cqE = z2;
            this.cqy = j4;
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
