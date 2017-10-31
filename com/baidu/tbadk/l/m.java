package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long aJB;
    public long aJC;
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
    public boolean aJP;
    public long aJQ;
    public long aJR;
    public boolean aJS;
    public long aJT;
    public int errCode;
    public boolean isSuccess;
    public long od;
    public long oe;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public m() {
        this.od = 0L;
        this.oe = 0L;
        this.aJI = 0L;
        this.aJK = 0L;
        this.aJN = 0L;
        this.aJO = 0L;
        this.aJQ = 0L;
        this.aJR = 0L;
        this.aJS = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.od = 0L;
        this.oe = 0L;
        this.aJI = 0L;
        this.aJK = 0L;
        this.aJN = 0L;
        this.aJO = 0L;
        this.aJQ = 0L;
        this.aJR = 0L;
        this.aJS = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aJP = z;
            if (this.aJP) {
                this.aJO = responsedMessage.getDownSize();
                this.aJT = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aJQ = responsedMessage.performanceData.qs;
                this.aJR = responsedMessage.performanceData.qt;
                this.socketErrNo = responsedMessage.performanceData.qq;
                this.socketCostTime = responsedMessage.performanceData.qr;
            } else {
                this.aJN = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aJB = j;
            this.aJC = j2;
            this.aJJ = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aJD = responsedMessage.performanceData.qh;
            this.aJE = responsedMessage.performanceData.qi;
            this.aJF = responsedMessage.performanceData.qj;
            this.od = responsedMessage.performanceData.ql;
            this.oe = responsedMessage.performanceData.qm;
            this.aJG = responsedMessage.performanceData.qn;
            this.aJH = responsedMessage.performanceData.qo;
            this.aJI = responsedMessage.performanceData.qp;
            this.aJI += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aJS = z2;
            this.aJK = j4;
        }
    }

    public void Gd() {
        t tVar = (t) r.Gi().fv(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void Ge() {
        t tVar;
        if (r.Gi().Gj() && (tVar = (t) r.Gi().fv(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void Gf() {
        t tVar = (t) r.Gi().fv(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
