package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long aJD;
    public long aJE;
    public long aJF;
    public long aJG;
    public long aJH;
    public long aJI;
    public long aJJ;
    public long aJK;
    public long aJL;
    public long aJM;
    public long aJN;
    public long aJO;
    public long aJP;
    public long aJQ;
    public boolean aJR;
    public long aJS;
    public long aJT;
    public boolean aJU;
    public long aJV;
    public int errCode;
    public boolean isSuccess;
    public long ob;
    public long oc;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public m() {
        this.ob = 0L;
        this.oc = 0L;
        this.aJK = 0L;
        this.aJM = 0L;
        this.aJP = 0L;
        this.aJQ = 0L;
        this.aJS = 0L;
        this.aJT = 0L;
        this.aJU = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.ob = 0L;
        this.oc = 0L;
        this.aJK = 0L;
        this.aJM = 0L;
        this.aJP = 0L;
        this.aJQ = 0L;
        this.aJS = 0L;
        this.aJT = 0L;
        this.aJU = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aJR = z;
            if (this.aJR) {
                this.aJQ = responsedMessage.getDownSize();
                this.aJV = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aJS = responsedMessage.performanceData.qp;
                this.aJT = responsedMessage.performanceData.qq;
                this.socketErrNo = responsedMessage.performanceData.qn;
                this.socketCostTime = responsedMessage.performanceData.qo;
            } else {
                this.aJP = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aJD = j;
            this.aJE = j2;
            this.aJL = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aJF = responsedMessage.performanceData.qf;
            this.aJG = responsedMessage.performanceData.qg;
            this.aJH = responsedMessage.performanceData.qh;
            this.ob = responsedMessage.performanceData.qi;
            this.oc = responsedMessage.performanceData.qj;
            this.aJI = responsedMessage.performanceData.qk;
            this.aJJ = responsedMessage.performanceData.ql;
            this.aJK = responsedMessage.performanceData.qm;
            this.aJK += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aJU = z2;
            this.aJM = j4;
        }
    }

    public void Gs() {
        t tVar = (t) r.Gx().fk(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void Gt() {
        t tVar;
        if (r.Gx().Gy() && (tVar = (t) r.Gx().fk(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void Gu() {
        t tVar = (t) r.Gx().fk(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
