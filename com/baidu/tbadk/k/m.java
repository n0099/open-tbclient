package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long aIR;
    public long aIS;
    public long aIT;
    public long aIU;
    public long aIV;
    public long aIW;
    public long aIX;
    public long aIY;
    public long aIZ;
    public long aJa;
    public long aJb;
    public long aJc;
    public long aJd;
    public long aJe;
    public boolean aJf;
    public long aJg;
    public long aJh;
    public boolean aJi;
    public long aJj;
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
        this.aIY = 0L;
        this.aJa = 0L;
        this.aJd = 0L;
        this.aJe = 0L;
        this.aJg = 0L;
        this.aJh = 0L;
        this.aJi = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.od = 0L;
        this.oe = 0L;
        this.aIY = 0L;
        this.aJa = 0L;
        this.aJd = 0L;
        this.aJe = 0L;
        this.aJg = 0L;
        this.aJh = 0L;
        this.aJi = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aJf = z;
            if (this.aJf) {
                this.aJe = responsedMessage.getDownSize();
                this.aJj = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aJg = responsedMessage.performanceData.qr;
                this.aJh = responsedMessage.performanceData.qs;
                this.socketErrNo = responsedMessage.performanceData.qp;
                this.socketCostTime = responsedMessage.performanceData.qq;
            } else {
                this.aJd = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aIR = j;
            this.aIS = j2;
            this.aIZ = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aIT = responsedMessage.performanceData.qh;
            this.aIU = responsedMessage.performanceData.qi;
            this.aIV = responsedMessage.performanceData.qj;
            this.od = responsedMessage.performanceData.qk;
            this.oe = responsedMessage.performanceData.ql;
            this.aIW = responsedMessage.performanceData.qm;
            this.aIX = responsedMessage.performanceData.qn;
            this.aIY = responsedMessage.performanceData.qo;
            this.aIY += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aJi = z2;
            this.aJa = j4;
        }
    }

    public void FR() {
        t tVar = (t) r.FW().fu(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void FS() {
        t tVar;
        if (r.FW().FX() && (tVar = (t) r.FW().fu(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void FT() {
        t tVar = (t) r.FW().fu(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
