package com.baidu.tbadk.k;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long acN;
    public long acO;
    public long byf;
    public long byg;
    public long byh;
    public long byi;
    public long byj;
    public long byk;
    public long byl;
    public long bym;
    public long byn;
    public long byo;
    public long byp;
    public long byq;
    public long byr;
    public long bys;
    public boolean byt;
    public long byu;
    public long byv;
    public boolean byw;
    public long byx;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public m() {
        this.acN = 0L;
        this.acO = 0L;
        this.bym = 0L;
        this.byo = 0L;
        this.byr = 0L;
        this.bys = 0L;
        this.byu = 0L;
        this.byv = 0L;
        this.byw = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.acN = 0L;
        this.acO = 0L;
        this.bym = 0L;
        this.byo = 0L;
        this.byr = 0L;
        this.bys = 0L;
        this.byu = 0L;
        this.byv = 0L;
        this.byw = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.byt = z;
            if (this.byt) {
                this.bys = responsedMessage.getDownSize();
                this.byx = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.byu = responsedMessage.performanceData.aeS;
                this.byv = responsedMessage.performanceData.aeT;
                this.socketErrNo = responsedMessage.performanceData.aeQ;
                this.socketCostTime = responsedMessage.performanceData.aeR;
            } else {
                this.byr = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.byf = j;
            this.byg = j2;
            this.byn = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.byh = responsedMessage.performanceData.aeI;
            this.byi = responsedMessage.performanceData.aeJ;
            this.byj = responsedMessage.performanceData.aeK;
            this.acN = responsedMessage.performanceData.aeL;
            this.acO = responsedMessage.performanceData.aeM;
            this.byk = responsedMessage.performanceData.aeN;
            this.byl = responsedMessage.performanceData.aeO;
            this.bym = responsedMessage.performanceData.aeP;
            this.bym += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.byw = z2;
            this.byo = j4;
        }
    }

    public void NV() {
        t tVar = (t) r.Oa().is(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void NW() {
        t tVar;
        if (r.Oa().Ob() && (tVar = (t) r.Oa().is(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void NX() {
        t tVar = (t) r.Oa().is(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
