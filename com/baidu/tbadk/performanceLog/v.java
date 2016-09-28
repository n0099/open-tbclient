package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class v extends t {
    public long aBM;
    public long aBN;
    public long aBO;
    public long aBP;
    public long aBQ;
    public long aBR;
    public long aBS;
    public long aBT;
    public long aBU;
    public long aBV;
    public long aBW;
    public long aBX;
    public long aBY;
    public long aBZ;
    public boolean aCa;
    public long aCb;
    public long aCc;
    public boolean aCd;
    public long aCe;
    public int errCode;
    public long hr;
    public long hs;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public v() {
        this.hr = 0L;
        this.hs = 0L;
        this.aBT = 0L;
        this.aBV = 0L;
        this.aBY = 0L;
        this.aBZ = 0L;
        this.aCb = 0L;
        this.aCc = 0L;
        this.aCd = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.hr = 0L;
        this.hs = 0L;
        this.aBT = 0L;
        this.aBV = 0L;
        this.aBY = 0L;
        this.aBZ = 0L;
        this.aCb = 0L;
        this.aCc = 0L;
        this.aCd = false;
        if (responsedMessage != null) {
            this.aBK = i;
            this.aCa = z;
            if (this.aCa) {
                this.aBZ = responsedMessage.getDownSize();
                this.aCe = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aCb = responsedMessage.performanceData.jz;
                this.aCc = responsedMessage.performanceData.jA;
                this.socketErrNo = responsedMessage.performanceData.jx;
                this.socketCostTime = responsedMessage.performanceData.jy;
            } else {
                this.aBY = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aBM = j;
            this.aBN = j2;
            this.aBU = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aBO = responsedMessage.performanceData.jp;
            this.aBP = responsedMessage.performanceData.jq;
            this.aBQ = responsedMessage.performanceData.jr;
            this.hr = responsedMessage.performanceData.js;
            this.hs = responsedMessage.performanceData.jt;
            this.aBR = responsedMessage.performanceData.ju;
            this.aBS = responsedMessage.performanceData.jv;
            this.aBT = responsedMessage.performanceData.jw;
            this.aBT += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aCd = z2;
            this.aBV = j4;
        }
    }

    public void Gj() {
        ac acVar = (ac) aa.Go().ff(this.aBK);
        if (acVar != null) {
            acVar.a(this);
        }
    }

    public void Gk() {
        ac acVar;
        if (aa.Go().Gp() && (acVar = (ac) aa.Go().ff(this.aBK)) != null) {
            acVar.b(this);
        }
    }

    public void Gl() {
        ac acVar = (ac) aa.Go().ff(this.aBK);
        if (acVar != null) {
            acVar.c(this);
        }
    }
}
