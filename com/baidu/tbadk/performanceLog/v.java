package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class v extends t {
    public boolean ayA;
    public long ayB;
    public long ayC;
    public boolean ayD;
    public long ayE;
    public long aym;
    public long ayn;
    public long ayo;
    public long ayp;
    public long ayq;
    public long ayr;
    public long ays;
    public long ayt;
    public long ayu;
    public long ayv;
    public long ayw;
    public long ayx;
    public long ayy;
    public long ayz;
    public long eC;
    public long eD;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public v() {
        this.eC = 0L;
        this.eD = 0L;
        this.ayt = 0L;
        this.ayv = 0L;
        this.ayy = 0L;
        this.ayz = 0L;
        this.ayB = 0L;
        this.ayC = 0L;
        this.ayD = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.eC = 0L;
        this.eD = 0L;
        this.ayt = 0L;
        this.ayv = 0L;
        this.ayy = 0L;
        this.ayz = 0L;
        this.ayB = 0L;
        this.ayC = 0L;
        this.ayD = false;
        if (responsedMessage != null) {
            this.ayk = i;
            this.ayA = z;
            if (this.ayA) {
                this.ayz = responsedMessage.getDownSize();
                this.ayE = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.ayB = responsedMessage.performanceData.gE;
                this.ayC = responsedMessage.performanceData.gF;
                this.socketErrNo = responsedMessage.performanceData.gC;
                this.socketCostTime = responsedMessage.performanceData.gD;
            } else {
                this.ayy = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aym = j;
            this.ayn = j2;
            this.ayu = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.ayo = responsedMessage.performanceData.gu;
            this.ayp = responsedMessage.performanceData.gv;
            this.ayq = responsedMessage.performanceData.gw;
            this.eC = responsedMessage.performanceData.gx;
            this.eD = responsedMessage.performanceData.gy;
            this.ayr = responsedMessage.performanceData.gz;
            this.ays = responsedMessage.performanceData.gA;
            this.ayt = responsedMessage.performanceData.gB;
            this.ayt += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.ayD = z2;
            this.ayv = j4;
        }
    }

    public void ER() {
        ac acVar = (ac) aa.EW().eS(this.ayk);
        if (acVar != null) {
            acVar.a(this);
        }
    }

    public void ES() {
        ac acVar;
        if (aa.EW().EX() && (acVar = (ac) aa.EW().eS(this.ayk)) != null) {
            acVar.b(this);
        }
    }

    public void ET() {
        ac acVar = (ac) aa.EW().eS(this.ayk);
        if (acVar != null) {
            acVar.c(this);
        }
    }
}
