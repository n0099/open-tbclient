package com.baidu.tbadk.o;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long cqA;
    public long cqB;
    public boolean cqC;
    public long cqD;
    public long cqE;
    public long cqF;
    public long cqG;
    public long cqn;
    public long cqo;
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
    public boolean cqz;
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
        this.cqu = 0L;
        this.cqw = 0L;
        this.cqx = 0L;
        this.cqy = 0L;
        this.cqA = 0L;
        this.cqB = 0L;
        this.cqC = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.wu = 0L;
        this.wv = 0L;
        this.cqu = 0L;
        this.cqw = 0L;
        this.cqx = 0L;
        this.cqy = 0L;
        this.cqA = 0L;
        this.cqB = 0L;
        this.cqC = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.cqz = z;
            if (this.cqz) {
                this.cqy = responsedMessage.getDownSize();
                this.cqD = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.cqA = responsedMessage.performanceData.yw;
                this.cqB = responsedMessage.performanceData.yx;
                this.socketErrNo = responsedMessage.performanceData.yu;
                this.socketCostTime = responsedMessage.performanceData.yv;
            } else {
                this.cqx = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.cqn = j;
            this.cqo = j2;
            this.cqv = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.cqp = responsedMessage.performanceData.ym;
            this.cqq = responsedMessage.performanceData.yn;
            this.cqr = responsedMessage.performanceData.yo;
            this.wu = responsedMessage.performanceData.yp;
            this.wv = responsedMessage.performanceData.yq;
            this.cqs = responsedMessage.performanceData.yr;
            this.cqt = responsedMessage.performanceData.ys;
            this.cqu = responsedMessage.performanceData.yt;
            this.cqu += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.cqC = z2;
            this.cqw = j4;
        }
    }

    public void apg() {
        o oVar = (o) m.apk().ka(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void fe(boolean z) {
        o oVar = (o) m.apk().ka(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void jY(int i) {
        o oVar = (o) m.apk().ka(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
