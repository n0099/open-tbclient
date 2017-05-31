package com.baidu.tbadk.j;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class v extends t {
    public long aGA;
    public long aGB;
    public long aGC;
    public boolean aGD;
    public long aGE;
    public long aGF;
    public boolean aGG;
    public long aGH;
    public long aGp;
    public long aGq;
    public long aGr;
    public long aGs;
    public long aGt;
    public long aGu;
    public long aGv;
    public long aGw;
    public long aGx;
    public long aGy;
    public long aGz;
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
        this.aGw = 0L;
        this.aGy = 0L;
        this.aGB = 0L;
        this.aGC = 0L;
        this.aGE = 0L;
        this.aGF = 0L;
        this.aGG = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.oJ = 0L;
        this.oK = 0L;
        this.aGw = 0L;
        this.aGy = 0L;
        this.aGB = 0L;
        this.aGC = 0L;
        this.aGE = 0L;
        this.aGF = 0L;
        this.aGG = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aGD = z;
            if (this.aGD) {
                this.aGC = responsedMessage.getDownSize();
                this.aGH = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aGE = responsedMessage.performanceData.qT;
                this.aGF = responsedMessage.performanceData.qU;
                this.socketErrNo = responsedMessage.performanceData.qR;
                this.socketCostTime = responsedMessage.performanceData.qS;
            } else {
                this.aGB = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aGp = j;
            this.aGq = j2;
            this.aGx = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aGr = responsedMessage.performanceData.qJ;
            this.aGs = responsedMessage.performanceData.qK;
            this.aGt = responsedMessage.performanceData.qL;
            this.oJ = responsedMessage.performanceData.qM;
            this.oK = responsedMessage.performanceData.qN;
            this.aGu = responsedMessage.performanceData.qO;
            this.aGv = responsedMessage.performanceData.qP;
            this.aGw = responsedMessage.performanceData.qQ;
            this.aGw += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aGG = z2;
            this.aGy = j4;
        }
    }

    public void Fz() {
        ac acVar = (ac) aa.FE().fd(this.mSubType);
        if (acVar != null) {
            acVar.a(this);
        }
    }

    public void FA() {
        ac acVar;
        if (aa.FE().FF() && (acVar = (ac) aa.FE().fd(this.mSubType)) != null) {
            acVar.b(this);
        }
    }

    public void FB() {
        ac acVar = (ac) aa.FE().fd(this.mSubType);
        if (acVar != null) {
            acVar.c(this);
        }
    }
}
