package com.baidu.tbadk.j;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class v extends t {
    public long aGA;
    public long aGB;
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
    public boolean aGM;
    public long aGN;
    public long aGO;
    public boolean aGP;
    public long aGQ;
    public long aGy;
    public long aGz;
    public int errCode;
    public boolean isSuccess;
    public long oI;
    public long oJ;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public v() {
        this.oI = 0L;
        this.oJ = 0L;
        this.aGF = 0L;
        this.aGH = 0L;
        this.aGK = 0L;
        this.aGL = 0L;
        this.aGN = 0L;
        this.aGO = 0L;
        this.aGP = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.oI = 0L;
        this.oJ = 0L;
        this.aGF = 0L;
        this.aGH = 0L;
        this.aGK = 0L;
        this.aGL = 0L;
        this.aGN = 0L;
        this.aGO = 0L;
        this.aGP = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aGM = z;
            if (this.aGM) {
                this.aGL = responsedMessage.getDownSize();
                this.aGQ = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aGN = responsedMessage.performanceData.qS;
                this.aGO = responsedMessage.performanceData.qT;
                this.socketErrNo = responsedMessage.performanceData.qQ;
                this.socketCostTime = responsedMessage.performanceData.qR;
            } else {
                this.aGK = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aGy = j;
            this.aGz = j2;
            this.aGG = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aGA = responsedMessage.performanceData.qI;
            this.aGB = responsedMessage.performanceData.qJ;
            this.aGC = responsedMessage.performanceData.qK;
            this.oI = responsedMessage.performanceData.qL;
            this.oJ = responsedMessage.performanceData.qM;
            this.aGD = responsedMessage.performanceData.qN;
            this.aGE = responsedMessage.performanceData.qO;
            this.aGF = responsedMessage.performanceData.qP;
            this.aGF += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aGP = z2;
            this.aGH = j4;
        }
    }

    public void GB() {
        ac acVar = (ac) aa.GG().fg(this.mSubType);
        if (acVar != null) {
            acVar.a(this);
        }
    }

    public void GC() {
        ac acVar;
        if (aa.GG().GH() && (acVar = (ac) aa.GG().fg(this.mSubType)) != null) {
            acVar.b(this);
        }
    }

    public void GD() {
        ac acVar = (ac) aa.GG().fg(this.mSubType);
        if (acVar != null) {
            acVar.c(this);
        }
    }
}
