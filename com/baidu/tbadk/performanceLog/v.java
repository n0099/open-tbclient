package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class v extends t {
    public long aAP;
    public long aAQ;
    public long aAR;
    public long aAS;
    public long aAT;
    public long aAU;
    public long aAV;
    public long aAW;
    public long aAX;
    public long aAY;
    public long aAZ;
    public long aBa;
    public long aBb;
    public long aBc;
    public boolean aBd;
    public long aBe;
    public long aBf;
    public boolean aBg;
    public long aBh;
    public int errCode;
    public long hp;
    public long hq;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public v() {
        this.hp = 0L;
        this.hq = 0L;
        this.aAW = 0L;
        this.aAY = 0L;
        this.aBb = 0L;
        this.aBc = 0L;
        this.aBe = 0L;
        this.aBf = 0L;
        this.aBg = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.hp = 0L;
        this.hq = 0L;
        this.aAW = 0L;
        this.aAY = 0L;
        this.aBb = 0L;
        this.aBc = 0L;
        this.aBe = 0L;
        this.aBf = 0L;
        this.aBg = false;
        if (responsedMessage != null) {
            this.aAN = i;
            this.aBd = z;
            if (this.aBd) {
                this.aBc = responsedMessage.getDownSize();
                this.aBh = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aBe = responsedMessage.performanceData.jt;
                this.aBf = responsedMessage.performanceData.ju;
                this.socketErrNo = responsedMessage.performanceData.jr;
                this.socketCostTime = responsedMessage.performanceData.js;
            } else {
                this.aBb = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aAP = j;
            this.aAQ = j2;
            this.aAX = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aAR = responsedMessage.performanceData.jj;
            this.aAS = responsedMessage.performanceData.jk;
            this.aAT = responsedMessage.performanceData.jl;
            this.hp = responsedMessage.performanceData.jm;
            this.hq = responsedMessage.performanceData.jn;
            this.aAU = responsedMessage.performanceData.jo;
            this.aAV = responsedMessage.performanceData.jp;
            this.aAW = responsedMessage.performanceData.jq;
            this.aAW += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aBg = z2;
            this.aAY = j4;
        }
    }

    public void FJ() {
        ac acVar = (ac) aa.FO().fj(this.aAN);
        if (acVar != null) {
            acVar.a(this);
        }
    }

    public void FK() {
        ac acVar;
        if (aa.FO().FP() && (acVar = (ac) aa.FO().fj(this.aAN)) != null) {
            acVar.b(this);
        }
    }

    public void FL() {
        ac acVar = (ac) aa.FO().fj(this.aAN);
        if (acVar != null) {
            acVar.c(this);
        }
    }
}
