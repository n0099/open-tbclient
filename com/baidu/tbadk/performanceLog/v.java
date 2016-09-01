package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class v extends t {
    public boolean aCA;
    public long aCB;
    public long aCj;
    public long aCk;
    public long aCl;
    public long aCm;
    public long aCn;
    public long aCo;
    public long aCp;
    public long aCq;
    public long aCr;
    public long aCs;
    public long aCt;
    public long aCu;
    public long aCv;
    public long aCw;
    public boolean aCx;
    public long aCy;
    public long aCz;
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
        this.aCq = 0L;
        this.aCs = 0L;
        this.aCv = 0L;
        this.aCw = 0L;
        this.aCy = 0L;
        this.aCz = 0L;
        this.aCA = false;
    }

    public v(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.hr = 0L;
        this.hs = 0L;
        this.aCq = 0L;
        this.aCs = 0L;
        this.aCv = 0L;
        this.aCw = 0L;
        this.aCy = 0L;
        this.aCz = 0L;
        this.aCA = false;
        if (responsedMessage != null) {
            this.aCh = i;
            this.aCx = z;
            if (this.aCx) {
                this.aCw = responsedMessage.getDownSize();
                this.aCB = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aCy = responsedMessage.performanceData.jz;
                this.aCz = responsedMessage.performanceData.jA;
                this.socketErrNo = responsedMessage.performanceData.jx;
                this.socketCostTime = responsedMessage.performanceData.jy;
            } else {
                this.aCv = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aCj = j;
            this.aCk = j2;
            this.aCr = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aCl = responsedMessage.performanceData.jp;
            this.aCm = responsedMessage.performanceData.jq;
            this.aCn = responsedMessage.performanceData.jr;
            this.hr = responsedMessage.performanceData.js;
            this.hs = responsedMessage.performanceData.jt;
            this.aCo = responsedMessage.performanceData.ju;
            this.aCp = responsedMessage.performanceData.jv;
            this.aCq = responsedMessage.performanceData.jw;
            this.aCq += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aCA = z2;
            this.aCs = j4;
        }
    }

    public void Gk() {
        ac acVar = (ac) aa.Gp().fg(this.aCh);
        if (acVar != null) {
            acVar.a(this);
        }
    }

    public void Gl() {
        ac acVar;
        if (aa.Gp().Gq() && (acVar = (ac) aa.Gp().fg(this.aCh)) != null) {
            acVar.b(this);
        }
    }

    public void Gm() {
        ac acVar = (ac) aa.Gp().fg(this.aCh);
        if (acVar != null) {
            acVar.c(this);
        }
    }
}
