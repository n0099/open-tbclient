package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class m extends k {
    public long aIL;
    public long aIM;
    public long aIN;
    public long aIO;
    public long aIP;
    public long aIQ;
    public long aIR;
    public long aIS;
    public long aIT;
    public long aIU;
    public long aIV;
    public long aIW;
    public long aIX;
    public long aIY;
    public boolean aIZ;
    public long aJa;
    public long aJb;
    public boolean aJc;
    public long aJd;
    public int errCode;
    public boolean isSuccess;
    public long oJ;
    public long oK;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public m() {
        this.oJ = 0L;
        this.oK = 0L;
        this.aIS = 0L;
        this.aIU = 0L;
        this.aIX = 0L;
        this.aIY = 0L;
        this.aJa = 0L;
        this.aJb = 0L;
        this.aJc = false;
    }

    public m(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.oJ = 0L;
        this.oK = 0L;
        this.aIS = 0L;
        this.aIU = 0L;
        this.aIX = 0L;
        this.aIY = 0L;
        this.aJa = 0L;
        this.aJb = 0L;
        this.aJc = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.aIZ = z;
            if (this.aIZ) {
                this.aIY = responsedMessage.getDownSize();
                this.aJd = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.aJa = responsedMessage.performanceData.qT;
                this.aJb = responsedMessage.performanceData.qU;
                this.socketErrNo = responsedMessage.performanceData.qR;
                this.socketCostTime = responsedMessage.performanceData.qS;
            } else {
                this.aIX = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.aIL = j;
            this.aIM = j2;
            this.aIT = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.aIN = responsedMessage.performanceData.qJ;
            this.aIO = responsedMessage.performanceData.qK;
            this.aIP = responsedMessage.performanceData.qL;
            this.oJ = responsedMessage.performanceData.qM;
            this.oK = responsedMessage.performanceData.qN;
            this.aIQ = responsedMessage.performanceData.qO;
            this.aIR = responsedMessage.performanceData.qP;
            this.aIS = responsedMessage.performanceData.qQ;
            this.aIS += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.aJc = z2;
            this.aIU = j4;
        }
    }

    public void Gm() {
        t tVar = (t) r.Gr().fi(this.mSubType);
        if (tVar != null) {
            tVar.a(this);
        }
    }

    public void Gn() {
        t tVar;
        if (r.Gr().Gs() && (tVar = (t) r.Gr().fi(this.mSubType)) != null) {
            tVar.b(this);
        }
    }

    public void Go() {
        t tVar = (t) r.Gr().fi(this.mSubType);
        if (tVar != null) {
            tVar.c(this);
        }
    }
}
