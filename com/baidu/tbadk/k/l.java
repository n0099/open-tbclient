package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class l extends j {
    public long acF;
    public long acG;
    public long bAA;
    public long bAB;
    public boolean bAC;
    public long bAD;
    public long bAE;
    public boolean bAF;
    public long bAG;
    public long bAo;
    public long bAp;
    public long bAq;
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
        this.bAv = 0L;
        this.bAx = 0L;
        this.bAA = 0L;
        this.bAB = 0L;
        this.bAD = 0L;
        this.bAE = 0L;
        this.bAF = false;
    }

    public l(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.acF = 0L;
        this.acG = 0L;
        this.bAv = 0L;
        this.bAx = 0L;
        this.bAA = 0L;
        this.bAB = 0L;
        this.bAD = 0L;
        this.bAE = 0L;
        this.bAF = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.bAC = z;
            if (this.bAC) {
                this.bAB = responsedMessage.getDownSize();
                this.bAG = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.bAD = responsedMessage.performanceData.aeK;
                this.bAE = responsedMessage.performanceData.aeL;
                this.socketErrNo = responsedMessage.performanceData.aeI;
                this.socketCostTime = responsedMessage.performanceData.aeJ;
            } else {
                this.bAA = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.bAo = j;
            this.bAp = j2;
            this.bAw = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.bAq = responsedMessage.performanceData.aeA;
            this.bAr = responsedMessage.performanceData.aeB;
            this.bAs = responsedMessage.performanceData.aeC;
            this.acF = responsedMessage.performanceData.aeD;
            this.acG = responsedMessage.performanceData.aeE;
            this.bAt = responsedMessage.performanceData.aeF;
            this.bAu = responsedMessage.performanceData.aeG;
            this.bAv = responsedMessage.performanceData.aeH;
            this.bAv += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.bAF = z2;
            this.bAx = j4;
        }
    }

    public void Oq() {
        r rVar = (r) p.Ov().il(this.mSubType);
        if (rVar != null) {
            rVar.a(this);
        }
    }

    public void Or() {
        r rVar;
        if (p.Ov().Ow() && (rVar = (r) p.Ov().il(this.mSubType)) != null) {
            rVar.b(this);
        }
    }

    public void Os() {
        r rVar = (r) p.Ov().il(this.mSubType);
        if (rVar != null) {
            rVar.c(this);
        }
    }
}
