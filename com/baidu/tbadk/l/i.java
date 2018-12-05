package com.baidu.tbadk.l;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class i extends g {
    public long bfN;
    public long bfO;
    public long bfP;
    public long bfQ;
    public long bfR;
    public long bfS;
    public long bfT;
    public long bfU;
    public long bfV;
    public long bfW;
    public long bfX;
    public long bfY;
    public boolean bfZ;
    public long bga;
    public long bgb;
    public boolean bgc;
    public long bgd;
    public long bge;
    public long bgf;
    public long bgg;
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
        this.bfU = 0L;
        this.bfW = 0L;
        this.bfX = 0L;
        this.bfY = 0L;
        this.bga = 0L;
        this.bgb = 0L;
        this.bgc = false;
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4) {
        this.wx = 0L;
        this.wy = 0L;
        this.bfU = 0L;
        this.bfW = 0L;
        this.bfX = 0L;
        this.bfY = 0L;
        this.bga = 0L;
        this.bgb = 0L;
        this.bgc = false;
        if (responsedMessage != null) {
            this.mSubType = i;
            this.bfZ = z;
            if (this.bfZ) {
                this.bfY = responsedMessage.getDownSize();
                this.bgd = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.bga = responsedMessage.performanceData.yz;
                this.bgb = responsedMessage.performanceData.yA;
                this.socketErrNo = responsedMessage.performanceData.yx;
                this.socketCostTime = responsedMessage.performanceData.yy;
            } else {
                this.bfX = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.bfN = j;
            this.bfO = j2;
            this.bfV = j3;
            this.isSuccess = !responsedMessage.hasError();
            this.bfP = responsedMessage.performanceData.yp;
            this.bfQ = responsedMessage.performanceData.yq;
            this.bfR = responsedMessage.performanceData.yr;
            this.wx = responsedMessage.performanceData.ys;
            this.wy = responsedMessage.performanceData.yt;
            this.bfS = responsedMessage.performanceData.yu;
            this.bfT = responsedMessage.performanceData.yv;
            this.bfU = responsedMessage.performanceData.yw;
            this.bfU += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.bgc = z2;
            this.bfW = j4;
        }
    }

    public void Ph() {
        o oVar = (o) m.Pk().gl(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void cL(boolean z) {
        o oVar = (o) m.Pk().gl(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void gj(int i) {
        o oVar = (o) m.Pk().gl(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }
}
