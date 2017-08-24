package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
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
    public long aKp;
    public boolean aKq;
    public long aKr;
    public long aKs;
    public boolean aKt;
    public long aKu;
    public int errCode;
    public boolean isSuccess;
    public long qu;
    public long qv;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public m() {
        this.qu = 0L;
        this.qv = 0L;
        this.aKj = 0L;
        this.aKl = 0L;
        this.aKo = 0L;
        this.aKp = 0L;
        this.aKr = 0L;
        this.aKs = 0L;
        this.aKt = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.qu = 0L;
        this.qv = 0L;
        this.aKj = 0L;
        this.aKl = 0L;
        this.aKo = 0L;
        this.aKp = 0L;
        this.aKr = 0L;
        this.aKs = 0L;
        this.aKt = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aKq = z;
            if (this.aKq) {
                this.aKp = responsedMessage.getDownSize();
                this.aKu = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aKr = responsedMessage.performanceData.sC;
                this.aKs = responsedMessage.performanceData.sD;
                this.socketErrNo = responsedMessage.performanceData.sA;
                this.socketCostTime = responsedMessage.performanceData.sB;
            } else {
                this.aKo = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aKc = j;
            this.aKd = j2;
            this.aKk = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aKe = responsedMessage.performanceData.sr;
            this.aKf = responsedMessage.performanceData.ss;
            this.aKg = responsedMessage.performanceData.su;
            this.qu = responsedMessage.performanceData.sv;
            this.qv = responsedMessage.performanceData.sw;
            this.aKh = responsedMessage.performanceData.sx;
            this.aKi = responsedMessage.performanceData.sy;
            this.aKj = responsedMessage.performanceData.sz;
            this.aKj += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aKt = z2;
            this.aKl = j4;
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
