package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long bbA;
    public long bbB;
    public long bbC;
    public long bbD;
    public long bbE;
    public long bbF;
    public long bbG;
    public long bbH;
    public long bbI;
    public long bbJ;
    public long bbK;
    public long bbL;
    public boolean bbM;
    public long bbN;
    public long bbO;
    public boolean bbP;
    public long bbQ;
    public long bbR;
    public long bbS;
    public long bbT;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;
    public long wu;
    public long wv;

    public i() {
        this.wu = 0L;
        this.wv = 0L;
        this.bbH = 0L;
        this.bbJ = 0L;
        this.bbK = 0L;
        this.bbL = 0L;
        this.bbN = 0L;
        this.bbO = 0L;
        this.bbP = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.wu = 0L;
        this.wv = 0L;
        this.bbH = 0L;
        this.bbJ = 0L;
        this.bbK = 0L;
        this.bbL = 0L;
        this.bbN = 0L;
        this.bbO = 0L;
        this.bbP = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.bbM = z;
            if (this.bbM) {
                this.bbL = responsedMessage.getDownSize();
                this.bbQ = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.bbN = responsedMessage.performanceData.yw;
                this.bbO = responsedMessage.performanceData.yx;
                this.socketErrNo = responsedMessage.performanceData.yu;
                this.socketCostTime = responsedMessage.performanceData.yv;
            } else {
                this.bbK = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.bbA = j;
            this.bbB = j2;
            this.bbI = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.bbC = responsedMessage.performanceData.ym;
            this.bbD = responsedMessage.performanceData.yn;
            this.bbE = responsedMessage.performanceData.yo;
            this.wu = responsedMessage.performanceData.yp;
            this.wv = responsedMessage.performanceData.yq;
            this.bbF = responsedMessage.performanceData.yr;
            this.bbG = responsedMessage.performanceData.ys;
            this.bbH = responsedMessage.performanceData.yt;
            this.bbH += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.bbP = z2;
            this.bbJ = j4;
        }
    }

    public void NU() {
        o oVar = (o) m.NX().fJ(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void ct(boolean z) {
        o oVar = (o) m.NX().fJ(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void fH(int i) {
        o oVar = (o) m.NX().fJ(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
