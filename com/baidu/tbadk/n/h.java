package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h extends g {
    public long allDataReadTime;
    public long chW;
    public int errCode;
    public HashMap<String, String> extra;
    public long fHa;
    public long fHb;
    public long fHc;
    public long fHd;
    public long fHe;
    public long fHf;
    public long fHg;
    public long fHh;
    public long fHi;
    public long fHj;
    public long fHk;
    public long fHl;
    public long fHm;
    public boolean fHn;
    public long fHo;
    public long fHp;
    public boolean fHq;
    public long fHr;
    public long fHs;
    public long fHt;
    public long fHu;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public h() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fHi = 0L;
        this.fHk = 0L;
        this.fHl = 0L;
        this.fHm = 0L;
        this.fHo = 0L;
        this.fHp = 0L;
        this.fHq = false;
        this.extra = new HashMap<>();
    }

    public h(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fHi = 0L;
        this.fHk = 0L;
        this.fHl = 0L;
        this.fHm = 0L;
        this.fHo = 0L;
        this.fHp = 0L;
        this.fHq = false;
        this.extra = new HashMap<>();
        if (responsedMessage != null) {
            this.mSubType = i;
            this.fHn = z;
            if (this.fHn) {
                this.fHm = responsedMessage.getDownSize();
                this.fHr = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.fHo = responsedMessage.performanceData.mHttpRetryNum;
                this.fHp = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.fHl = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.fHa = j;
            this.fHb = j4;
            this.fHc = j2;
            this.fHj = j3;
            this.fHh = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.chW = responsedMessage.performanceData.mQueneTime;
            this.fHd = responsedMessage.performanceData.mNetConTime;
            this.fHe = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.fHf = responsedMessage.performanceData.mCompressTime;
            this.fHg = responsedMessage.performanceData.mAnalysisTime;
            this.fHi = responsedMessage.performanceData.mTaskWaitTime;
            this.fHi += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.fHq = z2;
            this.fHk = j6;
        }
    }

    public void bDL() {
        m mVar = (m) k.bDO().rq(this.mSubType);
        if (mVar != null) {
            mVar.a(this);
        }
    }

    public void lj(boolean z) {
        m mVar = (m) k.bDO().rq(this.mSubType);
        if (mVar != null) {
            mVar.a(this, z);
        }
    }

    public void rp(int i) {
        m mVar = (m) k.bDO().rq(this.mSubType);
        if (mVar != null) {
            mVar.a(this, i);
        }
    }

    public void ee(String str, String str2) {
        if (!at.isEmpty(str) && !at.isEmpty(str2)) {
            this.extra.put(str, str2);
        }
    }
}
