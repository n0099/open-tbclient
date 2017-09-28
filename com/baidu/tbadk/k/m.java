package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long aJe;
    public long aJf;
    public long aJg;
    public long aJh;
    public long aJi;
    public long aJj;
    public long aJk;
    public long aJl;
    public long aJm;
    public long aJn;
    public long aJo;
    public long aJp;
    public long aJq;
    public long aJr;
    public boolean aJs;
    public long aJt;
    public long aJu;
    public boolean aJv;
    public long aJw;
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
        this.aJl = 0L;
        this.aJn = 0L;
        this.aJq = 0L;
        this.aJr = 0L;
        this.aJt = 0L;
        this.aJu = 0L;
        this.aJv = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.oc = 0L;
        this.od = 0L;
        this.aJl = 0L;
        this.aJn = 0L;
        this.aJq = 0L;
        this.aJr = 0L;
        this.aJt = 0L;
        this.aJu = 0L;
        this.aJv = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aJs = z;
            if (this.aJs) {
                this.aJr = responsedMessage.getDownSize();
                this.aJw = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aJt = responsedMessage.performanceData.qq;
                this.aJu = responsedMessage.performanceData.qr;
                this.socketErrNo = responsedMessage.performanceData.qo;
                this.socketCostTime = responsedMessage.performanceData.qp;
            } else {
                this.aJq = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aJe = j;
            this.aJf = j2;
            this.aJm = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aJg = responsedMessage.performanceData.qg;
            this.aJh = responsedMessage.performanceData.qh;
            this.aJi = responsedMessage.performanceData.qi;
            this.oc = responsedMessage.performanceData.qj;
            this.od = responsedMessage.performanceData.qk;
            this.aJj = responsedMessage.performanceData.ql;
            this.aJk = responsedMessage.performanceData.qm;
            this.aJl = responsedMessage.performanceData.qn;
            this.aJl += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aJv = z2;
            this.aJn = j4;
        }
    }

    public void FX() {
        t tVar = (t) r.Gc().fv(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void FY() {
        t tVar;
        if (r.Gc().Gd() && (tVar = (t) r.Gc().fv(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void FZ() {
        t tVar = (t) r.Gc().fv(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
