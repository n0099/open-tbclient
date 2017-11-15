package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long aJJ;
    public long aJK;
    public long aJL;
    public long aJM;
    public long aJN;
    public long aJO;
    public long aJP;
    public long aJQ;
    public long aJR;
    public long aJS;
    public long aJT;
    public long aJU;
    public long aJV;
    public long aJW;
    public boolean aJX;
    public long aJY;
    public long aJZ;
    public boolean aKa;
    public long aKb;
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
        this.aJQ = 0L;
        this.aJS = 0L;
        this.aJV = 0L;
        this.aJW = 0L;
        this.aJY = 0L;
        this.aJZ = 0L;
        this.aKa = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.od = 0L;
        this.oe = 0L;
        this.aJQ = 0L;
        this.aJS = 0L;
        this.aJV = 0L;
        this.aJW = 0L;
        this.aJY = 0L;
        this.aJZ = 0L;
        this.aKa = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aJX = z;
            if (this.aJX) {
                this.aJW = responsedMessage.getDownSize();
                this.aKb = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aJY = responsedMessage.performanceData.qs;
                this.aJZ = responsedMessage.performanceData.qt;
                this.socketErrNo = responsedMessage.performanceData.qq;
                this.socketCostTime = responsedMessage.performanceData.qr;
            } else {
                this.aJV = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aJJ = j;
            this.aJK = j2;
            this.aJR = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aJL = responsedMessage.performanceData.qh;
            this.aJM = responsedMessage.performanceData.qi;
            this.aJN = responsedMessage.performanceData.qj;
            this.od = responsedMessage.performanceData.ql;
            this.oe = responsedMessage.performanceData.qm;
            this.aJO = responsedMessage.performanceData.qn;
            this.aJP = responsedMessage.performanceData.qo;
            this.aJQ = responsedMessage.performanceData.qp;
            this.aJQ += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aKa = z2;
            this.aJS = j4;
        }
    }

    public void Go() {
        t tVar = (t) r.Gt().fu(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void Gp() {
        t tVar;
        if (r.Gt().Gu() && (tVar = (t) r.Gt().fu(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void Gq() {
        t tVar = (t) r.Gt().fu(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
