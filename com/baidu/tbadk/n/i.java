package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes2.dex */
public class i extends g {
    public long allDataReadTime;
    public long eRJ;
    public long eRK;
    public long eRL;
    public long eRM;
    public long eRN;
    public long eRO;
    public long eRP;
    public long eRQ;
    public long eRR;
    public long eRS;
    public long eRT;
    public long eRU;
    public long eRV;
    public long eRW;
    public boolean eRX;
    public long eRY;
    public long eRZ;
    public boolean eSa;
    public long eSb;
    public long eSc;
    public long eSd;
    public long eSe;
    public int errCode;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.eRS = 0L;
        this.eRU = 0L;
        this.eRV = 0L;
        this.eRW = 0L;
        this.eRY = 0L;
        this.eRZ = 0L;
        this.eSa = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.eRS = 0L;
        this.eRU = 0L;
        this.eRV = 0L;
        this.eRW = 0L;
        this.eRY = 0L;
        this.eRZ = 0L;
        this.eSa = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.eRX = z;
            if (this.eRX) {
                this.eRW = responsedMessage.getDownSize();
                this.eSb = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.eRY = responsedMessage.performanceData.mHttpRetryNum;
                this.eRZ = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.eRV = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.eRJ = j;
            this.eRK = j4;
            this.eRL = j2;
            this.eRT = j3;
            this.eRR = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.eRM = responsedMessage.performanceData.mQueneTime;
            this.eRN = responsedMessage.performanceData.mNetConTime;
            this.eRO = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.eRP = responsedMessage.performanceData.mCompressTime;
            this.eRQ = responsedMessage.performanceData.mAnalysisTime;
            this.eRS = responsedMessage.performanceData.mTaskWaitTime;
            this.eRS += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.eSa = z2;
            this.eRU = j6;
        }
    }

    public void buk() {
        o oVar = (o) m.bun().qC(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void jA(boolean z) {
        o oVar = (o) m.bun().qC(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void qA(int i) {
        o oVar = (o) m.bun().qC(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
