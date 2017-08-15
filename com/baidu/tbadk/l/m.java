package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long aKb;
    public long aKc;
    public long aKd;
    public long aKe;
    public long aKf;
    public long aKg;
    public long aKh;
    public long aKi;
    public long aKj;
    public long aKk;
    public long aKl;
    public long aKm;
    public long aKn;
    public long aKo;
    public boolean aKp;
    public long aKq;
    public long aKr;
    public boolean aKs;
    public long aKt;
    public int errCode;
    public boolean isSuccess;
    public long qt;
    public long qu;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public m() {
        this.qt = 0L;
        this.qu = 0L;
        this.aKi = 0L;
        this.aKk = 0L;
        this.aKn = 0L;
        this.aKo = 0L;
        this.aKq = 0L;
        this.aKr = 0L;
        this.aKs = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.qt = 0L;
        this.qu = 0L;
        this.aKi = 0L;
        this.aKk = 0L;
        this.aKn = 0L;
        this.aKo = 0L;
        this.aKq = 0L;
        this.aKr = 0L;
        this.aKs = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aKp = z;
            if (this.aKp) {
                this.aKo = responsedMessage.getDownSize();
                this.aKt = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aKq = responsedMessage.performanceData.sB;
                this.aKr = responsedMessage.performanceData.sC;
                this.socketErrNo = responsedMessage.performanceData.sz;
                this.socketCostTime = responsedMessage.performanceData.sA;
            } else {
                this.aKn = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aKb = j;
            this.aKc = j2;
            this.aKj = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aKd = responsedMessage.performanceData.sq;
            this.aKe = responsedMessage.performanceData.sr;
            this.aKf = responsedMessage.performanceData.ss;
            this.qt = responsedMessage.performanceData.su;
            this.qu = responsedMessage.performanceData.sv;
            this.aKg = responsedMessage.performanceData.sw;
            this.aKh = responsedMessage.performanceData.sx;
            this.aKi = responsedMessage.performanceData.sy;
            this.aKi += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aKs = z2;
            this.aKk = j4;
        }
    }

    public void Gu() {
        t tVar = (t) r.Gz().fk(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void Gv() {
        t tVar;
        if (r.Gz().GA() && (tVar = (t) r.Gz().fk(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void Gw() {
        t tVar = (t) r.Gz().fk(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
