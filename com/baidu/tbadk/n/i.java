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
    public boolean dDH;
    public long dDI;
    public long dDJ;
    public boolean dDK;
    public long dDL;
    public long dDM;
    public long dDN;
    public long dDO;
    public long dDv;
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
        this.dDC = 0L;
        this.dDE = 0L;
        this.dDF = 0L;
        this.dDG = 0L;
        this.dDI = 0L;
        this.dDJ = 0L;
        this.dDK = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.dDC = 0L;
        this.dDE = 0L;
        this.dDF = 0L;
        this.dDG = 0L;
        this.dDI = 0L;
        this.dDJ = 0L;
        this.dDK = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.dDH = z;
            if (this.dDH) {
                this.dDG = responsedMessage.getDownSize();
                this.dDL = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.dDI = responsedMessage.performanceData.mHttpRetryNum;
                this.dDJ = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.dDF = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.dDv = j;
            this.dDw = j2;
            this.dDD = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.dDx = responsedMessage.performanceData.mQueneTime;
            this.dDy = responsedMessage.performanceData.mNetConTime;
            this.dDz = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.dDA = responsedMessage.performanceData.mCompressTime;
            this.dDB = responsedMessage.performanceData.mAnalysisTime;
            this.dDC = responsedMessage.performanceData.mTaskWaitTime;
            this.dDC += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.dDK = z2;
            this.dDE = j4;
        }
    }

    public void aRg() {
        o oVar = (o) m.aRj().mN(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void gT(boolean z) {
        o oVar = (o) m.aRj().mN(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void mL(int i) {
        o oVar = (o) m.aRj().mN(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
