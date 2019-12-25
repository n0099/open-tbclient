package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public boolean dzA;
    public long dzB;
    public long dzC;
    public long dzD;
    public long dzE;
    public long dzl;
    public long dzm;
    public long dzn;
    public long dzo;
    public long dzp;
    public long dzq;
    public long dzr;
    public long dzs;
    public long dzt;
    public long dzu;
    public long dzv;
    public long dzw;
    public boolean dzx;
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
        this.dzs = 0L;
        this.dzu = 0L;
        this.dzv = 0L;
        this.dzw = 0L;
        this.dzy = 0L;
        this.dzz = 0L;
        this.dzA = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.dzs = 0L;
        this.dzu = 0L;
        this.dzv = 0L;
        this.dzw = 0L;
        this.dzy = 0L;
        this.dzz = 0L;
        this.dzA = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.dzx = z;
            if (this.dzx) {
                this.dzw = responsedMessage.getDownSize();
                this.dzB = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.dzy = responsedMessage.performanceData.mHttpRetryNum;
                this.dzz = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.dzv = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.dzl = j;
            this.dzm = j2;
            this.dzt = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.dzn = responsedMessage.performanceData.mQueneTime;
            this.dzo = responsedMessage.performanceData.mNetConTime;
            this.dzp = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.dzq = responsedMessage.performanceData.mCompressTime;
            this.dzr = responsedMessage.performanceData.mAnalysisTime;
            this.dzs = responsedMessage.performanceData.mTaskWaitTime;
            this.dzs += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.dzA = z2;
            this.dzu = j4;
        }
    }

    public void aOx() {
        o oVar = (o) m.aOA().mw(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void gH(boolean z) {
        o oVar = (o) m.aOA().mw(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void mu(int i) {
        o oVar = (o) m.aOA().mw(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
