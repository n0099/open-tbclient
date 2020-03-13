package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long dDJ;
    public long dDK;
    public long dDL;
    public long dDM;
    public long dDN;
    public long dDO;
    public long dDP;
    public long dDQ;
    public long dDR;
    public long dDS;
    public long dDT;
    public long dDU;
    public boolean dDV;
    public long dDW;
    public long dDX;
    public boolean dDY;
    public long dDZ;
    public long dEa;
    public long dEb;
    public long dEc;
    public int errCode;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.dDQ = 0L;
        this.dDS = 0L;
        this.dDT = 0L;
        this.dDU = 0L;
        this.dDW = 0L;
        this.dDX = 0L;
        this.dDY = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.dDQ = 0L;
        this.dDS = 0L;
        this.dDT = 0L;
        this.dDU = 0L;
        this.dDW = 0L;
        this.dDX = 0L;
        this.dDY = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.dDV = z;
            if (this.dDV) {
                this.dDU = responsedMessage.getDownSize();
                this.dDZ = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.dDW = responsedMessage.performanceData.mHttpRetryNum;
                this.dDX = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.dDT = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.dDJ = j;
            this.dDK = j2;
            this.dDR = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.dDL = responsedMessage.performanceData.mQueneTime;
            this.dDM = responsedMessage.performanceData.mNetConTime;
            this.dDN = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.dDO = responsedMessage.performanceData.mCompressTime;
            this.dDP = responsedMessage.performanceData.mAnalysisTime;
            this.dDQ = responsedMessage.performanceData.mTaskWaitTime;
            this.dDQ += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.dDY = z2;
            this.dDS = j4;
        }
    }

    public void aRj() {
        o oVar = (o) m.aRm().mN(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void gT(boolean z) {
        o oVar = (o) m.aRm().mN(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void mL(int i) {
        o oVar = (o) m.aRm().mN(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
