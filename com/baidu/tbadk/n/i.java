package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long eAO;
    public long eAP;
    public long eAQ;
    public long eAR;
    public long eAS;
    public long eAT;
    public long eAU;
    public long eAV;
    public long eAW;
    public long eAX;
    public long eAY;
    public long eAZ;
    public long eBa;
    public long eBb;
    public boolean eBc;
    public long eBd;
    public long eBe;
    public boolean eBf;
    public long eBg;
    public long eBh;
    public long eBi;
    public long eBj;
    public int errCode;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.eAX = 0L;
        this.eAZ = 0L;
        this.eBa = 0L;
        this.eBb = 0L;
        this.eBd = 0L;
        this.eBe = 0L;
        this.eBf = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.eAX = 0L;
        this.eAZ = 0L;
        this.eBa = 0L;
        this.eBb = 0L;
        this.eBd = 0L;
        this.eBe = 0L;
        this.eBf = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.eBc = z;
            if (this.eBc) {
                this.eBb = responsedMessage.getDownSize();
                this.eBg = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.eBd = responsedMessage.performanceData.mHttpRetryNum;
                this.eBe = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.eBa = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.eAO = j;
            this.eAP = j4;
            this.eAQ = j2;
            this.eAY = j3;
            this.eAW = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.eAR = responsedMessage.performanceData.mQueneTime;
            this.eAS = responsedMessage.performanceData.mNetConTime;
            this.eAT = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.eAU = responsedMessage.performanceData.mCompressTime;
            this.eAV = responsedMessage.performanceData.mAnalysisTime;
            this.eAX = responsedMessage.performanceData.mTaskWaitTime;
            this.eAX += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.eBf = z2;
            this.eAZ = j6;
        }
    }

    public void bhM() {
        o oVar = (o) m.bhP().nZ(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void ix(boolean z) {
        o oVar = (o) m.bhP().nZ(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void nX(int i) {
        o oVar = (o) m.bhP().nZ(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
