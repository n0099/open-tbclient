package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long bgB;
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
    public boolean bgN;
    public long bgO;
    public long bgP;
    public boolean bgQ;
    public long bgR;
    public long bgS;
    public long bgT;
    public long bgU;
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
        this.bgI = 0L;
        this.bgK = 0L;
        this.bgL = 0L;
        this.bgM = 0L;
        this.bgO = 0L;
        this.bgP = 0L;
        this.bgQ = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.wx = 0L;
        this.wy = 0L;
        this.bgI = 0L;
        this.bgK = 0L;
        this.bgL = 0L;
        this.bgM = 0L;
        this.bgO = 0L;
        this.bgP = 0L;
        this.bgQ = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.bgN = z;
            if (this.bgN) {
                this.bgM = responsedMessage.getDownSize();
                this.bgR = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.bgO = responsedMessage.performanceData.yz;
                this.bgP = responsedMessage.performanceData.yA;
                this.socketErrNo = responsedMessage.performanceData.yx;
                this.socketCostTime = responsedMessage.performanceData.yy;
            } else {
                this.bgL = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.bgB = j;
            this.bgC = j2;
            this.bgJ = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.bgD = responsedMessage.performanceData.yp;
            this.bgE = responsedMessage.performanceData.yq;
            this.bgF = responsedMessage.performanceData.yr;
            this.wx = responsedMessage.performanceData.ys;
            this.wy = responsedMessage.performanceData.yt;
            this.bgG = responsedMessage.performanceData.yu;
            this.bgH = responsedMessage.performanceData.yv;
            this.bgI = responsedMessage.performanceData.yw;
            this.bgI += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.bgQ = z2;
            this.bgK = j4;
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
