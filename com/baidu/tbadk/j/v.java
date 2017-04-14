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
    public boolean aGK;
    public long aGL;
    public long aGM;
    public boolean aGN;
    public long aGO;
    public long aGw;
    public long aGx;
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
        this.aGD = 0L;
        this.aGF = 0L;
        this.aGI = 0L;
        this.aGJ = 0L;
        this.aGL = 0L;
        this.aGM = 0L;
        this.aGN = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.oI = 0L;
        this.oJ = 0L;
        this.aGD = 0L;
        this.aGF = 0L;
        this.aGI = 0L;
        this.aGJ = 0L;
        this.aGL = 0L;
        this.aGM = 0L;
        this.aGN = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aGK = z;
            if (this.aGK) {
                this.aGJ = responsedMessage.getDownSize();
                this.aGO = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aGL = responsedMessage.performanceData.qN;
                this.aGM = responsedMessage.performanceData.qO;
                this.socketErrNo = responsedMessage.performanceData.qL;
                this.socketCostTime = responsedMessage.performanceData.qM;
            } else {
                this.aGI = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aGw = j;
            this.aGx = j2;
            this.aGE = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aGy = responsedMessage.performanceData.qD;
            this.aGz = responsedMessage.performanceData.qE;
            this.aGA = responsedMessage.performanceData.qF;
            this.oI = responsedMessage.performanceData.qG;
            this.oJ = responsedMessage.performanceData.qH;
            this.aGB = responsedMessage.performanceData.qI;
            this.aGC = responsedMessage.performanceData.qJ;
            this.aGD = responsedMessage.performanceData.qK;
            this.aGD += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aGN = z2;
            this.aGF = j4;
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
