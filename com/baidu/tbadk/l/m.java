package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long aKa;
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
    public boolean aKo;
    public long aKp;
    public long aKq;
    public boolean aKr;
    public long aKs;
    public int errCode;
    public boolean isSuccess;
    public long qr;
    public long qs;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public m() {
        this.qr = 0L;
        this.qs = 0L;
        this.aKh = 0L;
        this.aKj = 0L;
        this.aKm = 0L;
        this.aKn = 0L;
        this.aKp = 0L;
        this.aKq = 0L;
        this.aKr = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.qr = 0L;
        this.qs = 0L;
        this.aKh = 0L;
        this.aKj = 0L;
        this.aKm = 0L;
        this.aKn = 0L;
        this.aKp = 0L;
        this.aKq = 0L;
        this.aKr = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aKo = z;
            if (this.aKo) {
                this.aKn = responsedMessage.getDownSize();
                this.aKs = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aKp = responsedMessage.performanceData.sz;
                this.aKq = responsedMessage.performanceData.sA;
                this.socketErrNo = responsedMessage.performanceData.sx;
                this.socketCostTime = responsedMessage.performanceData.sy;
            } else {
                this.aKm = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aKa = j;
            this.aKb = j2;
            this.aKi = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aKc = responsedMessage.performanceData.sm;
            this.aKd = responsedMessage.performanceData.so;
            this.aKe = responsedMessage.performanceData.sq;
            this.qr = responsedMessage.performanceData.sr;
            this.qs = responsedMessage.performanceData.ss;
            this.aKf = responsedMessage.performanceData.su;
            this.aKg = responsedMessage.performanceData.sv;
            this.aKh = responsedMessage.performanceData.sw;
            this.aKh += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aKr = z2;
            this.aKj = j4;
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
