package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class l extends j {
    public long acF;
    public long acG;
    public long bAA;
    public long bAB;
    public long bAC;
    public long bAD;
    public long bAE;
    public boolean bAF;
    public long bAG;
    public long bAH;
    public boolean bAI;
    public long bAJ;
    public long bAr;
    public long bAs;
    public long bAt;
    public long bAu;
    public long bAv;
    public long bAw;
    public long bAx;
    public long bAy;
    public long bAz;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public l() {
        this.acF = 0L;
        this.acG = 0L;
        this.bAy = 0L;
        this.bAA = 0L;
        this.bAD = 0L;
        this.bAE = 0L;
        this.bAG = 0L;
        this.bAH = 0L;
        this.bAI = false;
    }

    public l(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.acF = 0L;
        this.acG = 0L;
        this.bAy = 0L;
        this.bAA = 0L;
        this.bAD = 0L;
        this.bAE = 0L;
        this.bAG = 0L;
        this.bAH = 0L;
        this.bAI = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.bAF = z;
            if (this.bAF) {
                this.bAE = responsedMessage.getDownSize();
                this.bAJ = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.bAG = responsedMessage.performanceData.aeK;
                this.bAH = responsedMessage.performanceData.aeL;
                this.socketErrNo = responsedMessage.performanceData.aeI;
                this.socketCostTime = responsedMessage.performanceData.aeJ;
            } else {
                this.bAD = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.bAr = j;
            this.bAs = j2;
            this.bAz = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.bAt = responsedMessage.performanceData.aeA;
            this.bAu = responsedMessage.performanceData.aeB;
            this.bAv = responsedMessage.performanceData.aeC;
            this.acF = responsedMessage.performanceData.aeD;
            this.acG = responsedMessage.performanceData.aeE;
            this.bAw = responsedMessage.performanceData.aeF;
            this.bAx = responsedMessage.performanceData.aeG;
            this.bAy = responsedMessage.performanceData.aeH;
            this.bAy += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.bAI = z2;
            this.bAA = j4;
        }
    }

    public void Or() {
        r rVar = (r) p.Ow().il(this.mSubType);
        if (rVar != null) {
            rVar.a(this);
        }
    }

    public void Os() {
        r rVar;
        if (p.Ow().Ox() && (rVar = (r) p.Ow().il(this.mSubType)) != null) {
            rVar.b(this);
        }
    }

    public void Ot() {
        r rVar = (r) p.Ow().il(this.mSubType);
        if (rVar != null) {
            rVar.c(this);
        }
    }
}
