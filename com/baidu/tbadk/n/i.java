package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long eHd;
    public long eHe;
    public long eHf;
    public long eHg;
    public long eHh;
    public long eHi;
    public long eHj;
    public long eHk;
    public long eHl;
    public long eHm;
    public long eHn;
    public long eHo;
    public long eHp;
    public long eHq;
    public boolean eHr;
    public long eHs;
    public long eHt;
    public boolean eHu;
    public long eHv;
    public long eHw;
    public long eHx;
    public long eHy;
    public int errCode;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.eHm = 0L;
        this.eHo = 0L;
        this.eHp = 0L;
        this.eHq = 0L;
        this.eHs = 0L;
        this.eHt = 0L;
        this.eHu = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.eHm = 0L;
        this.eHo = 0L;
        this.eHp = 0L;
        this.eHq = 0L;
        this.eHs = 0L;
        this.eHt = 0L;
        this.eHu = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.eHr = z;
            if (this.eHr) {
                this.eHq = responsedMessage.getDownSize();
                this.eHv = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.eHs = responsedMessage.performanceData.mHttpRetryNum;
                this.eHt = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.eHp = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.eHd = j;
            this.eHe = j4;
            this.eHf = j2;
            this.eHn = j3;
            this.eHl = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.eHg = responsedMessage.performanceData.mQueneTime;
            this.eHh = responsedMessage.performanceData.mNetConTime;
            this.eHi = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.eHj = responsedMessage.performanceData.mCompressTime;
            this.eHk = responsedMessage.performanceData.mAnalysisTime;
            this.eHm = responsedMessage.performanceData.mTaskWaitTime;
            this.eHm += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.eHu = z2;
            this.eHo = j6;
        }
    }

    public void blx() {
        o oVar = (o) m.blA().or(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void jc(boolean z) {
        o oVar = (o) m.blA().or(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void op(int i) {
        o oVar = (o) m.blA().or(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
