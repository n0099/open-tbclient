package com.baidu.tbadk.j;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class v extends t {
    public long aHD;
    public long aHE;
    public long aHF;
    public long aHG;
    public long aHH;
    public long aHI;
    public long aHJ;
    public long aHK;
    public long aHL;
    public long aHM;
    public long aHN;
    public long aHO;
    public long aHP;
    public long aHQ;
    public boolean aHR;
    public long aHS;
    public long aHT;
    public boolean aHU;
    public long aHV;
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
        this.aHK = 0L;
        this.aHM = 0L;
        this.aHP = 0L;
        this.aHQ = 0L;
        this.aHS = 0L;
        this.aHT = 0L;
        this.aHU = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.oJ = 0L;
        this.oK = 0L;
        this.aHK = 0L;
        this.aHM = 0L;
        this.aHP = 0L;
        this.aHQ = 0L;
        this.aHS = 0L;
        this.aHT = 0L;
        this.aHU = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aHR = z;
            if (this.aHR) {
                this.aHQ = responsedMessage.getDownSize();
                this.aHV = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aHS = responsedMessage.performanceData.qT;
                this.aHT = responsedMessage.performanceData.qU;
                this.socketErrNo = responsedMessage.performanceData.qR;
                this.socketCostTime = responsedMessage.performanceData.qS;
            } else {
                this.aHP = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aHD = j;
            this.aHE = j2;
            this.aHL = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aHF = responsedMessage.performanceData.qJ;
            this.aHG = responsedMessage.performanceData.qK;
            this.aHH = responsedMessage.performanceData.qL;
            this.oJ = responsedMessage.performanceData.qM;
            this.oK = responsedMessage.performanceData.qN;
            this.aHI = responsedMessage.performanceData.qO;
            this.aHJ = responsedMessage.performanceData.qP;
            this.aHK = responsedMessage.performanceData.qQ;
            this.aHK += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aHU = z2;
            this.aHM = j4;
        }
    }

    public void FW() {
        ac acVar = (ac) aa.Gb().ff(this.mSubType);
        if (acVar != null) {
            acVar.a(this);
        }
    }

    public void FX() {
        ac acVar;
        if (aa.Gb().Gc() && (acVar = (ac) aa.Gb().ff(this.mSubType)) != null) {
            acVar.b(this);
        }
    }

    public void FY() {
        ac acVar = (ac) aa.Gb().ff(this.mSubType);
        if (acVar != null) {
            acVar.c(this);
        }
    }
}
