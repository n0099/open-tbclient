package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class v extends t {
    public long aGh;
    public long aGi;
    public long aGj;
    public long aGk;
    public long aGl;
    public long aGm;
    public long aGn;
    public long aGo;
    public long aGp;
    public long aGq;
    public long aGr;
    public long aGs;
    public long aGt;
    public long aGu;
    public boolean aGv;
    public long aGw;
    public long aGx;
    public boolean aGy;
    public long aGz;
    public int errCode;
    public boolean isSuccess;
    public long po;
    public long pp;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public v() {
        this.po = 0L;
        this.pp = 0L;
        this.aGo = 0L;
        this.aGq = 0L;
        this.aGt = 0L;
        this.aGu = 0L;
        this.aGw = 0L;
        this.aGx = 0L;
        this.aGy = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.po = 0L;
        this.pp = 0L;
        this.aGo = 0L;
        this.aGq = 0L;
        this.aGt = 0L;
        this.aGu = 0L;
        this.aGw = 0L;
        this.aGx = 0L;
        this.aGy = false;
        if (responsedMessage != null) {
            this.aGf = i;
            this.aGv = z;
            if (this.aGv) {
                this.aGu = responsedMessage.getDownSize();
                this.aGz = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aGw = responsedMessage.performanceData.rp;
                this.aGx = responsedMessage.performanceData.rq;
                this.socketErrNo = responsedMessage.performanceData.rm;
                this.socketCostTime = responsedMessage.performanceData.ro;
            } else {
                this.aGt = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aGh = j;
            this.aGi = j2;
            this.aGp = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aGj = responsedMessage.performanceData.re;
            this.aGk = responsedMessage.performanceData.rf;
            this.aGl = responsedMessage.performanceData.rg;
            this.po = responsedMessage.performanceData.rh;
            this.pp = responsedMessage.performanceData.ri;
            this.aGm = responsedMessage.performanceData.rj;
            this.aGn = responsedMessage.performanceData.rk;
            this.aGo = responsedMessage.performanceData.rl;
            this.aGo += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aGy = z2;
            this.aGq = j4;
        }
    }

    public void Gd() {
        ac acVar = (ac) aa.Gi().fd(this.aGf);
        if (acVar != null) {
            acVar.a(this);
        }
    }

    public void Ge() {
        ac acVar;
        if (aa.Gi().Gj() && (acVar = (ac) aa.Gi().fd(this.aGf)) != null) {
            acVar.b(this);
        }
    }

    public void Gf() {
        ac acVar = (ac) aa.Gi().fd(this.aGf);
        if (acVar != null) {
            acVar.c(this);
        }
    }
}
