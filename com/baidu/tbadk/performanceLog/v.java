package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class v extends t {
    public long azc;
    public long azd;
    public long aze;
    public long azf;
    public long azg;
    public long azh;
    public long azi;
    public long azj;
    public long azk;
    public long azl;
    public long azm;
    public long azn;
    public long azo;
    public long azp;
    public boolean azq;
    public long azr;
    public long azs;
    public boolean azt;
    public long azu;
    public int errCode;
    public long fe;
    public long ff;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public v() {
        this.fe = 0L;
        this.ff = 0L;
        this.azj = 0L;
        this.azl = 0L;
        this.azo = 0L;
        this.azp = 0L;
        this.azr = 0L;
        this.azs = 0L;
        this.azt = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.fe = 0L;
        this.ff = 0L;
        this.azj = 0L;
        this.azl = 0L;
        this.azo = 0L;
        this.azp = 0L;
        this.azr = 0L;
        this.azs = 0L;
        this.azt = false;
        if (responsedMessage != null) {
            this.aza = i;
            this.azq = z;
            if (this.azq) {
                this.azp = responsedMessage.getDownSize();
                this.azu = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.azr = responsedMessage.performanceData.hh;
                this.azs = responsedMessage.performanceData.hi;
                this.socketErrNo = responsedMessage.performanceData.hf;
                this.socketCostTime = responsedMessage.performanceData.hg;
            } else {
                this.azo = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.azc = j;
            this.azd = j2;
            this.azk = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aze = responsedMessage.performanceData.gW;
            this.azf = responsedMessage.performanceData.gX;
            this.azg = responsedMessage.performanceData.gY;
            this.fe = responsedMessage.performanceData.gZ;
            this.ff = responsedMessage.performanceData.ha;
            this.azh = responsedMessage.performanceData.hb;
            this.azi = responsedMessage.performanceData.hc;
            this.azj = responsedMessage.performanceData.hd;
            this.azj += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.azt = z2;
            this.azl = j4;
        }
    }

    public void EQ() {
        ac acVar = (ac) aa.EV().eS(this.aza);
        if (acVar != null) {
            acVar.a(this);
        }
    }

    public void ER() {
        ac acVar;
        if (aa.EV().EW() && (acVar = (ac) aa.EV().eS(this.aza)) != null) {
            acVar.b(this);
        }
    }

    public void ES() {
        ac acVar = (ac) aa.EV().eS(this.aza);
        if (acVar != null) {
            acVar.c(this);
        }
    }
}
