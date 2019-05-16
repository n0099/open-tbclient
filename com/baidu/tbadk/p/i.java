package com.baidu.tbadk.p;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long cyA;
    public long cyB;
    public long cyC;
    public long cyD;
    public long cyE;
    public long cyF;
    public long cyG;
    public long cyH;
    public boolean cyI;
    public long cyJ;
    public long cyK;
    public boolean cyL;
    public long cyM;
    public long cyN;
    public long cyO;
    public long cyP;
    public long cyw;
    public long cyx;
    public long cyy;
    public long cyz;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;
    public long ub;
    public long uc;

    public i() {
        this.ub = 0L;
        this.uc = 0L;
        this.cyD = 0L;
        this.cyF = 0L;
        this.cyG = 0L;
        this.cyH = 0L;
        this.cyJ = 0L;
        this.cyK = 0L;
        this.cyL = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.ub = 0L;
        this.uc = 0L;
        this.cyD = 0L;
        this.cyF = 0L;
        this.cyG = 0L;
        this.cyH = 0L;
        this.cyJ = 0L;
        this.cyK = 0L;
        this.cyL = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.cyI = z;
            if (this.cyI) {
                this.cyH = responsedMessage.getDownSize();
                this.cyM = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.cyJ = responsedMessage.performanceData.wf;
                this.cyK = responsedMessage.performanceData.wg;
                this.socketErrNo = responsedMessage.performanceData.wc;
                this.socketCostTime = responsedMessage.performanceData.we;
            } else {
                this.cyG = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.cyw = j;
            this.cyx = j2;
            this.cyE = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.cyy = responsedMessage.performanceData.vU;
            this.cyz = responsedMessage.performanceData.vV;
            this.cyA = responsedMessage.performanceData.vW;
            this.ub = responsedMessage.performanceData.vX;
            this.uc = responsedMessage.performanceData.vY;
            this.cyB = responsedMessage.performanceData.vZ;
            this.cyC = responsedMessage.performanceData.wa;
            this.cyD = responsedMessage.performanceData.wb;
            this.cyD += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.cyL = z2;
            this.cyF = j4;
        }
    }

    public void auh() {
        o oVar = (o) m.auk().kN(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void fA(boolean z) {
        o oVar = (o) m.auk().kN(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void kL(int i) {
        o oVar = (o) m.auk().kN(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
