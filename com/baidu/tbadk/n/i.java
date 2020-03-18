package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long dDX;
    public long dDY;
    public long dDZ;
    public long dEa;
    public long dEb;
    public long dEc;
    public long dEd;
    public long dEe;
    public long dEf;
    public long dEg;
    public long dEh;
    public long dEi;
    public long dEj;
    public long dEk;
    public boolean dEl;
    public long dEm;
    public long dEn;
    public boolean dEo;
    public long dEp;
    public long dEq;
    public long dEr;
    public long dEs;
    public int errCode;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.dEg = 0L;
        this.dEi = 0L;
        this.dEj = 0L;
        this.dEk = 0L;
        this.dEm = 0L;
        this.dEn = 0L;
        this.dEo = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.dEg = 0L;
        this.dEi = 0L;
        this.dEj = 0L;
        this.dEk = 0L;
        this.dEm = 0L;
        this.dEn = 0L;
        this.dEo = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.dEl = z;
            if (this.dEl) {
                this.dEk = responsedMessage.getDownSize();
                this.dEp = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.dEm = responsedMessage.performanceData.mHttpRetryNum;
                this.dEn = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.dEj = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.dDX = j;
            this.dDY = j4;
            this.dDZ = j2;
            this.dEh = j3;
            this.dEf = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.dEa = responsedMessage.performanceData.mQueneTime;
            this.dEb = responsedMessage.performanceData.mNetConTime;
            this.dEc = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.dEd = responsedMessage.performanceData.mCompressTime;
            this.dEe = responsedMessage.performanceData.mAnalysisTime;
            this.dEg = responsedMessage.performanceData.mTaskWaitTime;
            this.dEg += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.dEo = z2;
            this.dEi = j6;
        }
    }

    public void aRn() {
        o oVar = (o) m.aRq().mP(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void gU(boolean z) {
        o oVar = (o) m.aRq().mP(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void mN(int i) {
        o oVar = (o) m.aRq().mP(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
