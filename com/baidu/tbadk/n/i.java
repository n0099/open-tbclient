package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long erW;
    public long erX;
    public long erY;
    public long erZ;
    public int errCode;
    public long esa;
    public long esb;
    public long esc;
    public long esd;
    public long ese;
    public long esf;
    public long esg;
    public long esh;
    public long esi;
    public long esj;
    public boolean esk;
    public long esl;
    public long esm;
    public boolean esn;
    public long eso;
    public long esp;
    public long esq;
    public long esr;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.esf = 0L;
        this.esh = 0L;
        this.esi = 0L;
        this.esj = 0L;
        this.esl = 0L;
        this.esm = 0L;
        this.esn = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.esf = 0L;
        this.esh = 0L;
        this.esi = 0L;
        this.esj = 0L;
        this.esl = 0L;
        this.esm = 0L;
        this.esn = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.esk = z;
            if (this.esk) {
                this.esj = responsedMessage.getDownSize();
                this.eso = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.esl = responsedMessage.performanceData.mHttpRetryNum;
                this.esm = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.esi = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.erW = j;
            this.erX = j4;
            this.erY = j2;
            this.esg = j3;
            this.ese = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.erZ = responsedMessage.performanceData.mQueneTime;
            this.esa = responsedMessage.performanceData.mNetConTime;
            this.esb = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.esc = responsedMessage.performanceData.mCompressTime;
            this.esd = responsedMessage.performanceData.mAnalysisTime;
            this.esf = responsedMessage.performanceData.mTaskWaitTime;
            this.esf += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.esn = z2;
            this.esh = j6;
        }
    }

    public void bfG() {
        o oVar = (o) m.bfJ().nE(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void io(boolean z) {
        o oVar = (o) m.bfJ().nE(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void nC(int i) {
        o oVar = (o) m.bfJ().nE(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
