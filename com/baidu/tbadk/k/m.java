package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long acN;
    public long acO;
    public long byA;
    public long byB;
    public long byC;
    public long byD;
    public long byE;
    public long byF;
    public long byG;
    public long byH;
    public long byI;
    public long byJ;
    public long byK;
    public boolean byL;
    public long byM;
    public long byN;
    public boolean byO;
    public long byP;
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
        this.byE = 0L;
        this.byG = 0L;
        this.byJ = 0L;
        this.byK = 0L;
        this.byM = 0L;
        this.byN = 0L;
        this.byO = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.acN = 0L;
        this.acO = 0L;
        this.byE = 0L;
        this.byG = 0L;
        this.byJ = 0L;
        this.byK = 0L;
        this.byM = 0L;
        this.byN = 0L;
        this.byO = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.byL = z;
            if (this.byL) {
                this.byK = responsedMessage.getDownSize();
                this.byP = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.byM = responsedMessage.performanceData.aeS;
                this.byN = responsedMessage.performanceData.aeT;
                this.socketErrNo = responsedMessage.performanceData.aeQ;
                this.socketCostTime = responsedMessage.performanceData.aeR;
            } else {
                this.byJ = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.byx = j;
            this.byy = j2;
            this.byF = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.byz = responsedMessage.performanceData.aeI;
            this.byA = responsedMessage.performanceData.aeJ;
            this.byB = responsedMessage.performanceData.aeK;
            this.acN = responsedMessage.performanceData.aeL;
            this.acO = responsedMessage.performanceData.aeM;
            this.byC = responsedMessage.performanceData.aeN;
            this.byD = responsedMessage.performanceData.aeO;
            this.byE = responsedMessage.performanceData.aeP;
            this.byE += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.byO = z2;
            this.byG = j4;
        }
    }

    public void NL() {
        t tVar = (t) r.NQ().io(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void NM() {
        t tVar;
        if (r.NQ().NR() && (tVar = (t) r.NQ().io(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void NN() {
        t tVar = (t) r.NQ().io(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
