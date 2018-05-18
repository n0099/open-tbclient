package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class l extends j {
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
    public long aLb;
    public boolean aLc;
    public long aLd;
    public long aLe;
    public boolean aLf;
    public long aLg;
    public long aLh;
    public long aLi;
    public long aLj;
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
        this.aKV = 0L;
        this.aKX = 0L;
        this.aLa = 0L;
        this.aLb = 0L;
        this.aLd = 0L;
        this.aLe = 0L;
        this.aLf = false;
    }

    public l(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.mW = 0L;
        this.mZ = 0L;
        this.aKV = 0L;
        this.aKX = 0L;
        this.aLa = 0L;
        this.aLb = 0L;
        this.aLd = 0L;
        this.aLe = 0L;
        this.aLf = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aLc = z;
            if (this.aLc) {
                this.aLb = responsedMessage.getDownSize();
                this.aLg = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aLd = responsedMessage.performanceData.pg;
                this.aLe = responsedMessage.performanceData.ph;
                this.socketErrNo = responsedMessage.performanceData.pe;
                this.socketCostTime = responsedMessage.performanceData.pf;
            } else {
                this.aLa = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aKO = j;
            this.aKP = j2;
            this.aKW = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aKQ = responsedMessage.performanceData.oU;
            this.aKR = responsedMessage.performanceData.oV;
            this.aKS = responsedMessage.performanceData.oW;
            this.mW = responsedMessage.performanceData.oX;
            this.mZ = responsedMessage.performanceData.oY;
            this.aKT = responsedMessage.performanceData.oZ;
            this.aKU = responsedMessage.performanceData.pa;
            this.aKV = responsedMessage.performanceData.pd;
            this.aKV += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aLf = z2;
            this.aKX = j4;
        }
    }

    public void GR() {
        r rVar = (r) p.GY().fm(this.mSubType);
        if (rVar != null) {
            rVar.a(this);
        }
    }

    public void GS() {
        r rVar;
        if (p.GY().GZ() && (rVar = (r) p.GY().fm(this.mSubType)) != null) {
            rVar.b(this);
        }
    }

    public void GT() {
        r rVar = (r) p.GY().fm(this.mSubType);
        if (rVar != null) {
            rVar.c(this);
        }
    }

    public void GU() {
        r rVar = (r) p.GY().fm(this.mSubType);
        if (rVar != null) {
            rVar.d(this);
        }
    }

    public void GV() {
        r rVar = (r) p.GY().fm(this.mSubType);
        if (rVar != null) {
            rVar.e(this);
        }
    }

    public void fk(int i) {
        r rVar = (r) p.GY().fm(this.mSubType);
        if (rVar != null) {
            rVar.a(this, i);
        }
    }
}
