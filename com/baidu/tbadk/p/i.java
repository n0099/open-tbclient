package com.baidu.tbadk.p;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long cLZ;
    public long cMa;
    public long cMb;
    public long cMc;
    public long cMd;
    public long cMe;
    public long cMf;
    public long cMg;
    public long cMh;
    public long cMi;
    public long cMj;
    public long cMk;
    public boolean cMl;
    public long cMm;
    public long cMn;
    public boolean cMo;
    public long cMp;
    public long cMq;
    public long cMr;
    public long cMs;
    public int errCode;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.cMg = 0L;
        this.cMi = 0L;
        this.cMj = 0L;
        this.cMk = 0L;
        this.cMm = 0L;
        this.cMn = 0L;
        this.cMo = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.cMg = 0L;
        this.cMi = 0L;
        this.cMj = 0L;
        this.cMk = 0L;
        this.cMm = 0L;
        this.cMn = 0L;
        this.cMo = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.cMl = z;
            if (this.cMl) {
                this.cMk = responsedMessage.getDownSize();
                this.cMp = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.cMm = responsedMessage.performanceData.mHttpRetryNum;
                this.cMn = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.cMj = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.cLZ = j;
            this.cMa = j2;
            this.cMh = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.cMb = responsedMessage.performanceData.mQueneTime;
            this.cMc = responsedMessage.performanceData.mNetConTime;
            this.cMd = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.cMe = responsedMessage.performanceData.mCompressTime;
            this.cMf = responsedMessage.performanceData.mAnalysisTime;
            this.cMg = responsedMessage.performanceData.mTaskWaitTime;
            this.cMg += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.cMo = z2;
            this.cMi = j4;
        }
    }

    public void awK() {
        o oVar = (o) m.awN().ki(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void fw(boolean z) {
        o oVar = (o) m.awN().ki(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void kg(int i) {
        o oVar = (o) m.awN().ki(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
