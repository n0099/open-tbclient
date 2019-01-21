package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long bgC;
    public long bgD;
    public long bgE;
    public long bgF;
    public long bgG;
    public long bgH;
    public long bgI;
    public long bgJ;
    public long bgK;
    public long bgL;
    public long bgM;
    public long bgN;
    public boolean bgO;
    public long bgP;
    public long bgQ;
    public boolean bgR;
    public long bgS;
    public long bgT;
    public long bgU;
    public long bgV;
    public int errCode;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;
    public long wx;
    public long wy;

    public i() {
        this.wx = 0L;
        this.wy = 0L;
        this.bgJ = 0L;
        this.bgL = 0L;
        this.bgM = 0L;
        this.bgN = 0L;
        this.bgP = 0L;
        this.bgQ = 0L;
        this.bgR = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.wx = 0L;
        this.wy = 0L;
        this.bgJ = 0L;
        this.bgL = 0L;
        this.bgM = 0L;
        this.bgN = 0L;
        this.bgP = 0L;
        this.bgQ = 0L;
        this.bgR = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.bgO = z;
            if (this.bgO) {
                this.bgN = responsedMessage.getDownSize();
                this.bgS = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.bgP = responsedMessage.performanceData.yz;
                this.bgQ = responsedMessage.performanceData.yA;
                this.socketErrNo = responsedMessage.performanceData.yx;
                this.socketCostTime = responsedMessage.performanceData.yy;
            } else {
                this.bgM = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.bgC = j;
            this.bgD = j2;
            this.bgK = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.bgE = responsedMessage.performanceData.yp;
            this.bgF = responsedMessage.performanceData.yq;
            this.bgG = responsedMessage.performanceData.yr;
            this.wx = responsedMessage.performanceData.ys;
            this.wy = responsedMessage.performanceData.yt;
            this.bgH = responsedMessage.performanceData.yu;
            this.bgI = responsedMessage.performanceData.yv;
            this.bgJ = responsedMessage.performanceData.yw;
            this.bgJ += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.bgR = z2;
            this.bgL = j4;
        }
    }

    public void PA() {
        o oVar = (o) m.PD().gm(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void cO(boolean z) {
        o oVar = (o) m.PD().gm(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void gk(int i) {
        o oVar = (o) m.PD().gm(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
