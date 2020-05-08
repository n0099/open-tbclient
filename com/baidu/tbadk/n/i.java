package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long edJ;
    public long edK;
    public long edL;
    public long edM;
    public long edN;
    public long edO;
    public long edP;
    public long edQ;
    public long edR;
    public long edS;
    public long edT;
    public long edU;
    public long edV;
    public long edW;
    public boolean edX;
    public long edY;
    public long edZ;
    public boolean eea;
    public long eeb;
    public long eec;
    public long eed;
    public long eee;
    public int errCode;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.edS = 0L;
        this.edU = 0L;
        this.edV = 0L;
        this.edW = 0L;
        this.edY = 0L;
        this.edZ = 0L;
        this.eea = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.edS = 0L;
        this.edU = 0L;
        this.edV = 0L;
        this.edW = 0L;
        this.edY = 0L;
        this.edZ = 0L;
        this.eea = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.edX = z;
            if (this.edX) {
                this.edW = responsedMessage.getDownSize();
                this.eeb = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.edY = responsedMessage.performanceData.mHttpRetryNum;
                this.edZ = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.edV = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.edJ = j;
            this.edK = j4;
            this.edL = j2;
            this.edT = j3;
            this.edR = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.edM = responsedMessage.performanceData.mQueneTime;
            this.edN = responsedMessage.performanceData.mNetConTime;
            this.edO = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.edP = responsedMessage.performanceData.mCompressTime;
            this.edQ = responsedMessage.performanceData.mAnalysisTime;
            this.edS = responsedMessage.performanceData.mTaskWaitTime;
            this.edS += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.eea = z2;
            this.edU = j6;
        }
    }

    public void aZv() {
        o oVar = (o) m.aZy().na(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void hS(boolean z) {
        o oVar = (o) m.aZy().na(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void mY(int i) {
        o oVar = (o) m.aZy().na(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
