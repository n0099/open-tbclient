package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long aJG;
    public long aJH;
    public long aJI;
    public long aJJ;
    public long aJK;
    public long aJL;
    public long aJM;
    public long aJN;
    public long aJO;
    public long aJP;
    public long aJQ;
    public long aJR;
    public long aJS;
    public long aJT;
    public boolean aJU;
    public long aJV;
    public long aJW;
    public boolean aJX;
    public long aJY;
    public int errCode;
    public boolean isSuccess;
    public long ob;
    public long oc;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public m() {
        this.ob = 0L;
        this.oc = 0L;
        this.aJN = 0L;
        this.aJP = 0L;
        this.aJS = 0L;
        this.aJT = 0L;
        this.aJV = 0L;
        this.aJW = 0L;
        this.aJX = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.ob = 0L;
        this.oc = 0L;
        this.aJN = 0L;
        this.aJP = 0L;
        this.aJS = 0L;
        this.aJT = 0L;
        this.aJV = 0L;
        this.aJW = 0L;
        this.aJX = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aJU = z;
            if (this.aJU) {
                this.aJT = responsedMessage.getDownSize();
                this.aJY = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aJV = responsedMessage.performanceData.qp;
                this.aJW = responsedMessage.performanceData.qq;
                this.socketErrNo = responsedMessage.performanceData.qn;
                this.socketCostTime = responsedMessage.performanceData.qo;
            } else {
                this.aJS = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aJG = j;
            this.aJH = j2;
            this.aJO = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aJI = responsedMessage.performanceData.qf;
            this.aJJ = responsedMessage.performanceData.qg;
            this.aJK = responsedMessage.performanceData.qh;
            this.ob = responsedMessage.performanceData.qi;
            this.oc = responsedMessage.performanceData.qj;
            this.aJL = responsedMessage.performanceData.qk;
            this.aJM = responsedMessage.performanceData.ql;
            this.aJN = responsedMessage.performanceData.qm;
            this.aJN += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aJX = z2;
            this.aJP = j4;
        }
    }

    public void Gs() {
        t tVar = (t) r.Gx().fk(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void Gt() {
        t tVar;
        if (r.Gx().Gy() && (tVar = (t) r.Gx().fk(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void Gu() {
        t tVar = (t) r.Gx().fk(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
