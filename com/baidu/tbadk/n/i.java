package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long dzA;
    public long dzB;
    public long dzC;
    public long dzD;
    public long dzE;
    public boolean dzF;
    public long dzG;
    public long dzH;
    public boolean dzI;
    public long dzJ;
    public long dzK;
    public long dzL;
    public long dzM;
    public long dzt;
    public long dzu;
    public long dzv;
    public long dzw;
    public long dzx;
    public long dzy;
    public long dzz;
    public int errCode;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.dzA = 0L;
        this.dzC = 0L;
        this.dzD = 0L;
        this.dzE = 0L;
        this.dzG = 0L;
        this.dzH = 0L;
        this.dzI = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.dzA = 0L;
        this.dzC = 0L;
        this.dzD = 0L;
        this.dzE = 0L;
        this.dzG = 0L;
        this.dzH = 0L;
        this.dzI = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.dzF = z;
            if (this.dzF) {
                this.dzE = responsedMessage.getDownSize();
                this.dzJ = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.dzG = responsedMessage.performanceData.mHttpRetryNum;
                this.dzH = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.dzD = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.dzt = j;
            this.dzu = j2;
            this.dzB = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.dzv = responsedMessage.performanceData.mQueneTime;
            this.dzw = responsedMessage.performanceData.mNetConTime;
            this.dzx = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.dzy = responsedMessage.performanceData.mCompressTime;
            this.dzz = responsedMessage.performanceData.mAnalysisTime;
            this.dzA = responsedMessage.performanceData.mTaskWaitTime;
            this.dzA += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.dzI = z2;
            this.dzC = j4;
        }
    }

    public void aOQ() {
        o oVar = (o) m.aOT().mw(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void gM(boolean z) {
        o oVar = (o) m.aOT().mw(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void mu(int i) {
        o oVar = (o) m.aOT().mw(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
