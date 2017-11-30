package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long aKA;
    public boolean aKB;
    public long aKC;
    public long aKk;
    public long aKl;
    public long aKm;
    public long aKn;
    public long aKo;
    public long aKp;
    public long aKq;
    public long aKr;
    public long aKs;
    public long aKt;
    public long aKu;
    public long aKv;
    public long aKw;
    public long aKx;
    public boolean aKy;
    public long aKz;
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
        this.aKr = 0L;
        this.aKt = 0L;
        this.aKw = 0L;
        this.aKx = 0L;
        this.aKz = 0L;
        this.aKA = 0L;
        this.aKB = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.od = 0L;
        this.oe = 0L;
        this.aKr = 0L;
        this.aKt = 0L;
        this.aKw = 0L;
        this.aKx = 0L;
        this.aKz = 0L;
        this.aKA = 0L;
        this.aKB = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aKy = z;
            if (this.aKy) {
                this.aKx = responsedMessage.getDownSize();
                this.aKC = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aKz = responsedMessage.performanceData.qs;
                this.aKA = responsedMessage.performanceData.qt;
                this.socketErrNo = responsedMessage.performanceData.qq;
                this.socketCostTime = responsedMessage.performanceData.qr;
            } else {
                this.aKw = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aKk = j;
            this.aKl = j2;
            this.aKs = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aKm = responsedMessage.performanceData.qh;
            this.aKn = responsedMessage.performanceData.qi;
            this.aKo = responsedMessage.performanceData.qj;
            this.od = responsedMessage.performanceData.ql;
            this.oe = responsedMessage.performanceData.qm;
            this.aKp = responsedMessage.performanceData.qn;
            this.aKq = responsedMessage.performanceData.qo;
            this.aKr = responsedMessage.performanceData.qp;
            this.aKr += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aKB = z2;
            this.aKt = j4;
        }
    }

    public void Gv() {
        t tVar = (t) r.GA().ft(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void Gw() {
        t tVar;
        if (r.GA().GB() && (tVar = (t) r.GA().ft(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void Gx() {
        t tVar = (t) r.GA().ft(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
