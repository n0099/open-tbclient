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
    public long cyI;
    public boolean cyJ;
    public long cyK;
    public long cyL;
    public boolean cyM;
    public long cyN;
    public long cyO;
    public long cyP;
    public long cyQ;
    public long cyx;
    public long cyy;
    public long cyz;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;
    public long tZ;
    public long ub;

    public i() {
        this.tZ = 0L;
        this.ub = 0L;
        this.cyE = 0L;
        this.cyG = 0L;
        this.cyH = 0L;
        this.cyI = 0L;
        this.cyK = 0L;
        this.cyL = 0L;
        this.cyM = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.tZ = 0L;
        this.ub = 0L;
        this.cyE = 0L;
        this.cyG = 0L;
        this.cyH = 0L;
        this.cyI = 0L;
        this.cyK = 0L;
        this.cyL = 0L;
        this.cyM = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.cyJ = z;
            if (this.cyJ) {
                this.cyI = responsedMessage.getDownSize();
                this.cyN = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.cyK = responsedMessage.performanceData.we;
                this.cyL = responsedMessage.performanceData.wf;
                this.socketErrNo = responsedMessage.performanceData.wb;
                this.socketCostTime = responsedMessage.performanceData.wc;
            } else {
                this.cyH = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.cyx = j;
            this.cyy = j2;
            this.cyF = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.cyz = responsedMessage.performanceData.vT;
            this.cyA = responsedMessage.performanceData.vU;
            this.cyB = responsedMessage.performanceData.vV;
            this.tZ = responsedMessage.performanceData.vW;
            this.ub = responsedMessage.performanceData.vX;
            this.cyC = responsedMessage.performanceData.vY;
            this.cyD = responsedMessage.performanceData.vZ;
            this.cyE = responsedMessage.performanceData.wa;
            this.cyE += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.cyM = z2;
            this.cyG = j4;
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
