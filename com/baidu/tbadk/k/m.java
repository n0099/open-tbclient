package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long aKA;
    public long aKB;
    public boolean aKC;
    public long aKD;
    public long aKE;
    public boolean aKF;
    public long aKG;
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
    public long aKy;
    public long aKz;
    public int errCode;
    public boolean isSuccess;
    public long oc;
    public long od;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public m() {
        this.oc = 0L;
        this.od = 0L;
        this.aKv = 0L;
        this.aKx = 0L;
        this.aKA = 0L;
        this.aKB = 0L;
        this.aKD = 0L;
        this.aKE = 0L;
        this.aKF = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.oc = 0L;
        this.od = 0L;
        this.aKv = 0L;
        this.aKx = 0L;
        this.aKA = 0L;
        this.aKB = 0L;
        this.aKD = 0L;
        this.aKE = 0L;
        this.aKF = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aKC = z;
            if (this.aKC) {
                this.aKB = responsedMessage.getDownSize();
                this.aKG = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aKD = responsedMessage.performanceData.qr;
                this.aKE = responsedMessage.performanceData.qs;
                this.socketErrNo = responsedMessage.performanceData.qp;
                this.socketCostTime = responsedMessage.performanceData.qq;
            } else {
                this.aKA = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aKo = j;
            this.aKp = j2;
            this.aKw = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aKq = responsedMessage.performanceData.qg;
            this.aKr = responsedMessage.performanceData.qh;
            this.aKs = responsedMessage.performanceData.qi;
            this.oc = responsedMessage.performanceData.qj;
            this.od = responsedMessage.performanceData.ql;
            this.aKt = responsedMessage.performanceData.qm;
            this.aKu = responsedMessage.performanceData.qn;
            this.aKv = responsedMessage.performanceData.qo;
            this.aKv += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aKF = z2;
            this.aKx = j4;
        }
    }

    public void Gw() {
        t tVar = (t) r.GB().ft(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void Gx() {
        t tVar;
        if (r.GB().GC() && (tVar = (t) r.GB().ft(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void Gy() {
        t tVar = (t) r.GB().ft(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
