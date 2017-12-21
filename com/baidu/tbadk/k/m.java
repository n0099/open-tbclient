package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long aKA;
    public long aKB;
    public long aKC;
    public long aKD;
    public long aKE;
    public boolean aKF;
    public long aKG;
    public long aKH;
    public boolean aKI;
    public long aKJ;
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
    public long od;
    public long oe;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public m() {
        this.od = 0L;
        this.oe = 0L;
        this.aKy = 0L;
        this.aKA = 0L;
        this.aKD = 0L;
        this.aKE = 0L;
        this.aKG = 0L;
        this.aKH = 0L;
        this.aKI = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.od = 0L;
        this.oe = 0L;
        this.aKy = 0L;
        this.aKA = 0L;
        this.aKD = 0L;
        this.aKE = 0L;
        this.aKG = 0L;
        this.aKH = 0L;
        this.aKI = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aKF = z;
            if (this.aKF) {
                this.aKE = responsedMessage.getDownSize();
                this.aKJ = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aKG = responsedMessage.performanceData.qs;
                this.aKH = responsedMessage.performanceData.qt;
                this.socketErrNo = responsedMessage.performanceData.qq;
                this.socketCostTime = responsedMessage.performanceData.qr;
            } else {
                this.aKD = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aKr = j;
            this.aKs = j2;
            this.aKz = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aKt = responsedMessage.performanceData.qh;
            this.aKu = responsedMessage.performanceData.qi;
            this.aKv = responsedMessage.performanceData.qj;
            this.od = responsedMessage.performanceData.ql;
            this.oe = responsedMessage.performanceData.qm;
            this.aKw = responsedMessage.performanceData.qn;
            this.aKx = responsedMessage.performanceData.qo;
            this.aKy = responsedMessage.performanceData.qp;
            this.aKy += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aKI = z2;
            this.aKA = j4;
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
