package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class l extends j {
    public long aKN;
    public long aKO;
    public long aKP;
    public long aKQ;
    public long aKR;
    public long aKS;
    public long aKT;
    public long aKU;
    public long aKV;
    public long aKW;
    public long aKX;
    public long aKY;
    public long aKZ;
    public long aLa;
    public boolean aLb;
    public long aLc;
    public long aLd;
    public boolean aLe;
    public long aLf;
    public long aLg;
    public long aLh;
    public long aLi;
    public int errCode;
    public boolean isSuccess;
    public long mW;
    public long mZ;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public l() {
        this.mW = 0L;
        this.mZ = 0L;
        this.aKU = 0L;
        this.aKW = 0L;
        this.aKZ = 0L;
        this.aLa = 0L;
        this.aLc = 0L;
        this.aLd = 0L;
        this.aLe = false;
    }

    public l(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.mW = 0L;
        this.mZ = 0L;
        this.aKU = 0L;
        this.aKW = 0L;
        this.aKZ = 0L;
        this.aLa = 0L;
        this.aLc = 0L;
        this.aLd = 0L;
        this.aLe = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aLb = z;
            if (this.aLb) {
                this.aLa = responsedMessage.getDownSize();
                this.aLf = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aLc = responsedMessage.performanceData.ph;
                this.aLd = responsedMessage.performanceData.pi;
                this.socketErrNo = responsedMessage.performanceData.pf;
                this.socketCostTime = responsedMessage.performanceData.pg;
            } else {
                this.aKZ = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aKN = j;
            this.aKO = j2;
            this.aKV = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aKP = responsedMessage.performanceData.oV;
            this.aKQ = responsedMessage.performanceData.oW;
            this.aKR = responsedMessage.performanceData.oX;
            this.mW = responsedMessage.performanceData.oY;
            this.mZ = responsedMessage.performanceData.oZ;
            this.aKS = responsedMessage.performanceData.pa;
            this.aKT = responsedMessage.performanceData.pd;
            this.aKU = responsedMessage.performanceData.pe;
            this.aKU += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aLe = z2;
            this.aKW = j4;
        }
    }

    public void GT() {
        r rVar = (r) p.Ha().fm(this.mSubType);
        if (rVar != null) {
            rVar.a(this);
        }
    }

    public void GU() {
        r rVar;
        if (p.Ha().Hb() && (rVar = (r) p.Ha().fm(this.mSubType)) != null) {
            rVar.b(this);
        }
    }

    public void GV() {
        r rVar = (r) p.Ha().fm(this.mSubType);
        if (rVar != null) {
            rVar.c(this);
        }
    }

    public void GW() {
        r rVar = (r) p.Ha().fm(this.mSubType);
        if (rVar != null) {
            rVar.d(this);
        }
    }

    public void GX() {
        r rVar = (r) p.Ha().fm(this.mSubType);
        if (rVar != null) {
            rVar.e(this);
        }
    }

    public void fk(int i) {
        r rVar = (r) p.Ha().fm(this.mSubType);
        if (rVar != null) {
            rVar.a(this, i);
        }
    }
}
