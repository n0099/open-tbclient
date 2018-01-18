package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long acN;
    public long acO;
    public long byA;
    public long byB;
    public boolean byC;
    public long byD;
    public long byE;
    public boolean byF;
    public long byG;
    public long byo;
    public long byp;
    public long byq;
    public long byr;
    public long bys;
    public long byt;
    public long byu;
    public long byv;
    public long byw;
    public long byx;
    public long byy;
    public long byz;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public m() {
        this.acN = 0L;
        this.acO = 0L;
        this.byv = 0L;
        this.byx = 0L;
        this.byA = 0L;
        this.byB = 0L;
        this.byD = 0L;
        this.byE = 0L;
        this.byF = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.acN = 0L;
        this.acO = 0L;
        this.byv = 0L;
        this.byx = 0L;
        this.byA = 0L;
        this.byB = 0L;
        this.byD = 0L;
        this.byE = 0L;
        this.byF = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.byC = z;
            if (this.byC) {
                this.byB = responsedMessage.getDownSize();
                this.byG = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.byD = responsedMessage.performanceData.aeS;
                this.byE = responsedMessage.performanceData.aeT;
                this.socketErrNo = responsedMessage.performanceData.aeQ;
                this.socketCostTime = responsedMessage.performanceData.aeR;
            } else {
                this.byA = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.byo = j;
            this.byp = j2;
            this.byw = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.byq = responsedMessage.performanceData.aeI;
            this.byr = responsedMessage.performanceData.aeJ;
            this.bys = responsedMessage.performanceData.aeK;
            this.acN = responsedMessage.performanceData.aeL;
            this.acO = responsedMessage.performanceData.aeM;
            this.byt = responsedMessage.performanceData.aeN;
            this.byu = responsedMessage.performanceData.aeO;
            this.byv = responsedMessage.performanceData.aeP;
            this.byv += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.byF = z2;
            this.byx = j4;
        }
    }

    public void NJ() {
        t tVar = (t) r.NO().io(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void NK() {
        t tVar;
        if (r.NO().NP() && (tVar = (t) r.NO().io(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void NL() {
        t tVar = (t) r.NO().io(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
