package com.baidu.tbadk.j;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class v extends t {
    public long aGC;
    public long aGD;
    public long aGE;
    public long aGF;
    public long aGG;
    public long aGH;
    public long aGI;
    public long aGJ;
    public long aGK;
    public long aGL;
    public long aGM;
    public long aGN;
    public long aGO;
    public long aGP;
    public boolean aGQ;
    public long aGR;
    public long aGS;
    public boolean aGT;
    public long aGU;
    public int errCode;
    public boolean isSuccess;
    public long oJ;
    public long oK;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public v() {
        this.oJ = 0L;
        this.oK = 0L;
        this.aGJ = 0L;
        this.aGL = 0L;
        this.aGO = 0L;
        this.aGP = 0L;
        this.aGR = 0L;
        this.aGS = 0L;
        this.aGT = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.oJ = 0L;
        this.oK = 0L;
        this.aGJ = 0L;
        this.aGL = 0L;
        this.aGO = 0L;
        this.aGP = 0L;
        this.aGR = 0L;
        this.aGS = 0L;
        this.aGT = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aGQ = z;
            if (this.aGQ) {
                this.aGP = responsedMessage.getDownSize();
                this.aGU = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aGR = responsedMessage.performanceData.qT;
                this.aGS = responsedMessage.performanceData.qU;
                this.socketErrNo = responsedMessage.performanceData.qR;
                this.socketCostTime = responsedMessage.performanceData.qS;
            } else {
                this.aGO = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aGC = j;
            this.aGD = j2;
            this.aGK = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aGE = responsedMessage.performanceData.qJ;
            this.aGF = responsedMessage.performanceData.qK;
            this.aGG = responsedMessage.performanceData.qL;
            this.oJ = responsedMessage.performanceData.qM;
            this.oK = responsedMessage.performanceData.qN;
            this.aGH = responsedMessage.performanceData.qO;
            this.aGI = responsedMessage.performanceData.qP;
            this.aGJ = responsedMessage.performanceData.qQ;
            this.aGJ += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aGT = z2;
            this.aGL = j4;
        }
    }

    public void FF() {
        ac acVar = (ac) aa.FK().fc(this.mSubType);
        if (acVar != null) {
            acVar.a(this);
        }
    }

    public void FG() {
        ac acVar;
        if (aa.FK().FL() && (acVar = (ac) aa.FK().fc(this.mSubType)) != null) {
            acVar.b(this);
        }
    }

    public void FH() {
        ac acVar = (ac) aa.FK().fc(this.mSubType);
        if (acVar != null) {
            acVar.c(this);
        }
    }
}
