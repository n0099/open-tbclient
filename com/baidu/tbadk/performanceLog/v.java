package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class v extends t {
    public long aCD;
    public long aCE;
    public long aCF;
    public long aCG;
    public long aCH;
    public long aCI;
    public long aCJ;
    public long aCK;
    public long aCL;
    public long aCM;
    public long aCN;
    public long aCO;
    public long aCP;
    public long aCQ;
    public boolean aCR;
    public long aCS;
    public long aCT;
    public boolean aCU;
    public long aCV;
    public int errCode;
    public long hs;
    public long ht;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public v() {
        this.hs = 0L;
        this.ht = 0L;
        this.aCK = 0L;
        this.aCM = 0L;
        this.aCP = 0L;
        this.aCQ = 0L;
        this.aCS = 0L;
        this.aCT = 0L;
        this.aCU = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.hs = 0L;
        this.ht = 0L;
        this.aCK = 0L;
        this.aCM = 0L;
        this.aCP = 0L;
        this.aCQ = 0L;
        this.aCS = 0L;
        this.aCT = 0L;
        this.aCU = false;
        if (responsedMessage != null) {
            this.aCB = i;
            this.aCR = z;
            if (this.aCR) {
                this.aCQ = responsedMessage.getDownSize();
                this.aCV = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aCS = responsedMessage.performanceData.jA;
                this.aCT = responsedMessage.performanceData.jB;
                this.socketErrNo = responsedMessage.performanceData.jy;
                this.socketCostTime = responsedMessage.performanceData.jz;
            } else {
                this.aCP = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aCD = j;
            this.aCE = j2;
            this.aCL = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aCF = responsedMessage.performanceData.jq;
            this.aCG = responsedMessage.performanceData.jr;
            this.aCH = responsedMessage.performanceData.js;
            this.hs = responsedMessage.performanceData.jt;
            this.ht = responsedMessage.performanceData.ju;
            this.aCI = responsedMessage.performanceData.jv;
            this.aCJ = responsedMessage.performanceData.jw;
            this.aCK = responsedMessage.performanceData.jx;
            this.aCK += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aCU = z2;
            this.aCM = j4;
        }
    }

    public void Gp() {
        ac acVar = (ac) aa.Gu().fi(this.aCB);
        if (acVar != null) {
            acVar.a(this);
        }
    }

    public void Gq() {
        ac acVar;
        if (aa.Gu().Gv() && (acVar = (ac) aa.Gu().fi(this.aCB)) != null) {
            acVar.b(this);
        }
    }

    public void Gr() {
        ac acVar = (ac) aa.Gu().fi(this.aCB);
        if (acVar != null) {
            acVar.c(this);
        }
    }
}
