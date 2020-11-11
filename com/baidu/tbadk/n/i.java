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
    public long fvA;
    public long fvB;
    public long fvg;
    public long fvh;
    public long fvi;
    public long fvj;
    public long fvk;
    public long fvl;
    public long fvm;
    public long fvn;
    public long fvo;
    public long fvp;
    public long fvq;
    public long fvr;
    public long fvs;
    public long fvt;
    public boolean fvu;
    public long fvv;
    public long fvw;
    public boolean fvx;
    public long fvy;
    public long fvz;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fvp = 0L;
        this.fvr = 0L;
        this.fvs = 0L;
        this.fvt = 0L;
        this.fvv = 0L;
        this.fvw = 0L;
        this.fvx = false;
        this.extra = new HashMap<>();
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fvp = 0L;
        this.fvr = 0L;
        this.fvs = 0L;
        this.fvt = 0L;
        this.fvv = 0L;
        this.fvw = 0L;
        this.fvx = false;
        this.extra = new HashMap<>();
        if (responsedMessage != null) {
            this.mSubType = i;
            this.fvu = z;
            if (this.fvu) {
                this.fvt = responsedMessage.getDownSize();
                this.fvy = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.fvv = responsedMessage.performanceData.mHttpRetryNum;
                this.fvw = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.fvs = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.fvg = j;
            this.fvh = j4;
            this.fvi = j2;
            this.fvq = j3;
            this.fvo = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.fvj = responsedMessage.performanceData.mQueneTime;
            this.fvk = responsedMessage.performanceData.mNetConTime;
            this.fvl = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.fvm = responsedMessage.performanceData.mCompressTime;
            this.fvn = responsedMessage.performanceData.mAnalysisTime;
            this.fvp = responsedMessage.performanceData.mTaskWaitTime;
            this.fvp += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.fvx = z2;
            this.fvr = j6;
        }
    }

    public void bCr() {
        o oVar = (o) m.bCu().rM(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void kx(boolean z) {
        o oVar = (o) m.bCu().rM(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void rK(int i) {
        o oVar = (o) m.bCu().rM(this.mSubType);
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
