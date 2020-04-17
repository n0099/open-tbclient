package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long edE;
    public long edF;
    public long edG;
    public long edH;
    public long edI;
    public long edJ;
    public long edK;
    public long edL;
    public long edM;
    public long edN;
    public long edO;
    public long edP;
    public long edQ;
    public long edR;
    public boolean edS;
    public long edT;
    public long edU;
    public boolean edV;
    public long edW;
    public long edX;
    public long edY;
    public long edZ;
    public int errCode;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.edN = 0L;
        this.edP = 0L;
        this.edQ = 0L;
        this.edR = 0L;
        this.edT = 0L;
        this.edU = 0L;
        this.edV = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.edN = 0L;
        this.edP = 0L;
        this.edQ = 0L;
        this.edR = 0L;
        this.edT = 0L;
        this.edU = 0L;
        this.edV = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.edS = z;
            if (this.edS) {
                this.edR = responsedMessage.getDownSize();
                this.edW = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.edT = responsedMessage.performanceData.mHttpRetryNum;
                this.edU = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.edQ = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.edE = j;
            this.edF = j4;
            this.edG = j2;
            this.edO = j3;
            this.edM = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.edH = responsedMessage.performanceData.mQueneTime;
            this.edI = responsedMessage.performanceData.mNetConTime;
            this.edJ = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.edK = responsedMessage.performanceData.mCompressTime;
            this.edL = responsedMessage.performanceData.mAnalysisTime;
            this.edN = responsedMessage.performanceData.mTaskWaitTime;
            this.edN += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.edV = z2;
            this.edP = j6;
        }
    }

    public void aZx() {
        o oVar = (o) m.aZA().na(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void hS(boolean z) {
        o oVar = (o) m.aZA().na(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void mY(int i) {
        o oVar = (o) m.aZA().na(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
