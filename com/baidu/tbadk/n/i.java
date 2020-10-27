package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public int errCode;
    public HashMap<String, String> extra;
    public long firstByteReachTime;
    public boolean fpA;
    public long fpB;
    public long fpC;
    public boolean fpD;
    public long fpE;
    public long fpF;
    public long fpG;
    public long fpH;
    public long fpl;
    public long fpm;
    public long fpn;
    public long fpo;
    public long fpp;
    public long fpq;
    public long fpr;
    public long fpt;
    public long fpu;
    public long fpv;
    public long fpw;
    public long fpx;
    public long fpy;
    public long fpz;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fpv = 0L;
        this.fpx = 0L;
        this.fpy = 0L;
        this.fpz = 0L;
        this.fpB = 0L;
        this.fpC = 0L;
        this.fpD = false;
        this.extra = new HashMap<>();
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fpv = 0L;
        this.fpx = 0L;
        this.fpy = 0L;
        this.fpz = 0L;
        this.fpB = 0L;
        this.fpC = 0L;
        this.fpD = false;
        this.extra = new HashMap<>();
        if (responsedMessage != null) {
            this.mSubType = i;
            this.fpA = z;
            if (this.fpA) {
                this.fpz = responsedMessage.getDownSize();
                this.fpE = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.fpB = responsedMessage.performanceData.mHttpRetryNum;
                this.fpC = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.fpy = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.fpl = j;
            this.fpm = j4;
            this.fpn = j2;
            this.fpw = j3;
            this.fpu = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.fpo = responsedMessage.performanceData.mQueneTime;
            this.fpp = responsedMessage.performanceData.mNetConTime;
            this.fpq = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.fpr = responsedMessage.performanceData.mCompressTime;
            this.fpt = responsedMessage.performanceData.mAnalysisTime;
            this.fpv = responsedMessage.performanceData.mTaskWaitTime;
            this.fpv += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.fpD = z2;
            this.fpx = j6;
        }
    }

    public void bzS() {
        o oVar = (o) m.bzV().rC(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void ko(boolean z) {
        o oVar = (o) m.bzV().rC(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void rA(int i) {
        o oVar = (o) m.bzV().rC(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }

    public void dZ(String str, String str2) {
        if (!at.isEmpty(str) && !at.isEmpty(str2)) {
            this.extra.put(str, str2);
        }
    }
}
