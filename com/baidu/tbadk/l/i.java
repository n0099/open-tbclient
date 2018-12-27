package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long bfQ;
    public long bfR;
    public long bfS;
    public long bfT;
    public long bfU;
    public long bfV;
    public long bfW;
    public long bfX;
    public long bfY;
    public long bfZ;
    public long bga;
    public long bgb;
    public boolean bgc;
    public long bgd;
    public long bge;
    public boolean bgf;
    public long bgg;
    public long bgh;
    public long bgi;
    public long bgj;
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
        this.bfX = 0L;
        this.bfZ = 0L;
        this.bga = 0L;
        this.bgb = 0L;
        this.bgd = 0L;
        this.bge = 0L;
        this.bgf = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.wx = 0L;
        this.wy = 0L;
        this.bfX = 0L;
        this.bfZ = 0L;
        this.bga = 0L;
        this.bgb = 0L;
        this.bgd = 0L;
        this.bge = 0L;
        this.bgf = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.bgc = z;
            if (this.bgc) {
                this.bgb = responsedMessage.getDownSize();
                this.bgg = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.bgd = responsedMessage.performanceData.yz;
                this.bge = responsedMessage.performanceData.yA;
                this.socketErrNo = responsedMessage.performanceData.yx;
                this.socketCostTime = responsedMessage.performanceData.yy;
            } else {
                this.bga = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.bfQ = j;
            this.bfR = j2;
            this.bfY = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.bfS = responsedMessage.performanceData.yp;
            this.bfT = responsedMessage.performanceData.yq;
            this.bfU = responsedMessage.performanceData.yr;
            this.wx = responsedMessage.performanceData.ys;
            this.wy = responsedMessage.performanceData.yt;
            this.bfV = responsedMessage.performanceData.yu;
            this.bfW = responsedMessage.performanceData.yv;
            this.bfX = responsedMessage.performanceData.yw;
            this.bfX += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.bgf = z2;
            this.bfZ = j4;
        }
    }

    public void Pi() {
        o oVar = (o) m.Pl().gm(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void cL(boolean z) {
        o oVar = (o) m.Pl().gm(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void gk(int i) {
        o oVar = (o) m.Pl().gm(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
