package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class l extends j {
    public long acL;
    public long acM;
    public long bAB;
    public long bAC;
    public long bAD;
    public long bAE;
    public long bAF;
    public long bAG;
    public long bAH;
    public long bAI;
    public long bAJ;
    public long bAK;
    public long bAL;
    public long bAM;
    public long bAN;
    public long bAO;
    public boolean bAP;
    public long bAQ;
    public long bAR;
    public boolean bAS;
    public long bAT;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public l() {
        this.acL = 0L;
        this.acM = 0L;
        this.bAI = 0L;
        this.bAK = 0L;
        this.bAN = 0L;
        this.bAO = 0L;
        this.bAQ = 0L;
        this.bAR = 0L;
        this.bAS = false;
    }

    public l(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.acL = 0L;
        this.acM = 0L;
        this.bAI = 0L;
        this.bAK = 0L;
        this.bAN = 0L;
        this.bAO = 0L;
        this.bAQ = 0L;
        this.bAR = 0L;
        this.bAS = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.bAP = z;
            if (this.bAP) {
                this.bAO = responsedMessage.getDownSize();
                this.bAT = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.bAQ = responsedMessage.performanceData.aeQ;
                this.bAR = responsedMessage.performanceData.aeR;
                this.socketErrNo = responsedMessage.performanceData.aeO;
                this.socketCostTime = responsedMessage.performanceData.aeP;
            } else {
                this.bAN = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.bAB = j;
            this.bAC = j2;
            this.bAJ = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.bAD = responsedMessage.performanceData.aeG;
            this.bAE = responsedMessage.performanceData.aeH;
            this.bAF = responsedMessage.performanceData.aeI;
            this.acL = responsedMessage.performanceData.aeJ;
            this.acM = responsedMessage.performanceData.aeK;
            this.bAG = responsedMessage.performanceData.aeL;
            this.bAH = responsedMessage.performanceData.aeM;
            this.bAI = responsedMessage.performanceData.aeN;
            this.bAI += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.bAS = z2;
            this.bAK = j4;
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
