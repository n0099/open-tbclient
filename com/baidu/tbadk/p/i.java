package com.baidu.tbadk.p;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long cLA;
    public long cLB;
    public long cLi;
    public long cLj;
    public long cLk;
    public long cLl;
    public long cLm;
    public long cLn;
    public long cLo;
    public long cLp;
    public long cLq;
    public long cLr;
    public long cLs;
    public long cLt;
    public boolean cLu;
    public long cLv;
    public long cLw;
    public boolean cLx;
    public long cLy;
    public long cLz;
    public int errCode;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.cLp = 0L;
        this.cLr = 0L;
        this.cLs = 0L;
        this.cLt = 0L;
        this.cLv = 0L;
        this.cLw = 0L;
        this.cLx = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.cLp = 0L;
        this.cLr = 0L;
        this.cLs = 0L;
        this.cLt = 0L;
        this.cLv = 0L;
        this.cLw = 0L;
        this.cLx = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.cLu = z;
            if (this.cLu) {
                this.cLt = responsedMessage.getDownSize();
                this.cLy = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.cLv = responsedMessage.performanceData.mHttpRetryNum;
                this.cLw = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.cLs = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.cLi = j;
            this.cLj = j2;
            this.cLq = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.cLk = responsedMessage.performanceData.mQueneTime;
            this.cLl = responsedMessage.performanceData.mNetConTime;
            this.cLm = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.cLn = responsedMessage.performanceData.mCompressTime;
            this.cLo = responsedMessage.performanceData.mAnalysisTime;
            this.cLp = responsedMessage.performanceData.mTaskWaitTime;
            this.cLp += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.cLx = z2;
            this.cLr = j4;
        }
    }

    public void awI() {
        o oVar = (o) m.awL().kh(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void fw(boolean z) {
        o oVar = (o) m.awL().kh(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void kf(int i) {
        o oVar = (o) m.awL().kh(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
