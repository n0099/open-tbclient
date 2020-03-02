package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long dDA;
    public long dDB;
    public long dDC;
    public long dDD;
    public long dDE;
    public long dDF;
    public long dDG;
    public long dDH;
    public boolean dDI;
    public long dDJ;
    public long dDK;
    public boolean dDL;
    public long dDM;
    public long dDN;
    public long dDO;
    public long dDP;
    public long dDw;
    public long dDx;
    public long dDy;
    public long dDz;
    public int errCode;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.dDD = 0L;
        this.dDF = 0L;
        this.dDG = 0L;
        this.dDH = 0L;
        this.dDJ = 0L;
        this.dDK = 0L;
        this.dDL = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.dDD = 0L;
        this.dDF = 0L;
        this.dDG = 0L;
        this.dDH = 0L;
        this.dDJ = 0L;
        this.dDK = 0L;
        this.dDL = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.dDI = z;
            if (this.dDI) {
                this.dDH = responsedMessage.getDownSize();
                this.dDM = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.dDJ = responsedMessage.performanceData.mHttpRetryNum;
                this.dDK = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.dDG = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.dDw = j;
            this.dDx = j2;
            this.dDE = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.dDy = responsedMessage.performanceData.mQueneTime;
            this.dDz = responsedMessage.performanceData.mNetConTime;
            this.dDA = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.dDB = responsedMessage.performanceData.mCompressTime;
            this.dDC = responsedMessage.performanceData.mAnalysisTime;
            this.dDD = responsedMessage.performanceData.mTaskWaitTime;
            this.dDD += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.dDL = z2;
            this.dDF = j4;
        }
    }

    public void aRi() {
        o oVar = (o) m.aRl().mN(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void gT(boolean z) {
        o oVar = (o) m.aRl().mN(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void mL(int i) {
        o oVar = (o) m.aRl().mN(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
