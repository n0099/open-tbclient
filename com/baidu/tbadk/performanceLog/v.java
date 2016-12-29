package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class v extends t {
    public long aBX;
    public long aBY;
    public long aBZ;
    public long aCa;
    public long aCb;
    public long aCc;
    public long aCd;
    public long aCe;
    public long aCf;
    public long aCg;
    public long aCh;
    public long aCi;
    public long aCj;
    public long aCk;
    public boolean aCl;
    public long aCm;
    public long aCn;
    public boolean aCo;
    public long aCp;
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
        this.aCe = 0L;
        this.aCg = 0L;
        this.aCj = 0L;
        this.aCk = 0L;
        this.aCm = 0L;
        this.aCn = 0L;
        this.aCo = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.hs = 0L;
        this.ht = 0L;
        this.aCe = 0L;
        this.aCg = 0L;
        this.aCj = 0L;
        this.aCk = 0L;
        this.aCm = 0L;
        this.aCn = 0L;
        this.aCo = false;
        if (responsedMessage != null) {
            this.aBV = i;
            this.aCl = z;
            if (this.aCl) {
                this.aCk = responsedMessage.getDownSize();
                this.aCp = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aCm = responsedMessage.performanceData.jz;
                this.aCn = responsedMessage.performanceData.jA;
                this.socketErrNo = responsedMessage.performanceData.jx;
                this.socketCostTime = responsedMessage.performanceData.jy;
            } else {
                this.aCj = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aBX = j;
            this.aBY = j2;
            this.aCf = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aBZ = responsedMessage.performanceData.jp;
            this.aCa = responsedMessage.performanceData.jq;
            this.aCb = responsedMessage.performanceData.jr;
            this.hs = responsedMessage.performanceData.js;
            this.ht = responsedMessage.performanceData.jt;
            this.aCc = responsedMessage.performanceData.ju;
            this.aCd = responsedMessage.performanceData.jv;
            this.aCe = responsedMessage.performanceData.jw;
            this.aCe += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aCo = z2;
            this.aCg = j4;
        }
    }

    public void FP() {
        ac acVar = (ac) aa.FU().fi(this.aBV);
        if (acVar != null) {
            acVar.a(this);
        }
    }

    public void FQ() {
        ac acVar;
        if (aa.FU().FV() && (acVar = (ac) aa.FU().fi(this.aBV)) != null) {
            acVar.b(this);
        }
    }

    public void FR() {
        ac acVar = (ac) aa.FU().fi(this.aBV);
        if (acVar != null) {
            acVar.c(this);
        }
    }
}
