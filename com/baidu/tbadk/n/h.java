package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.au;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h extends g {
    public long allDataReadTime;
    public int errCode;
    public HashMap<String, String> extra;
    public long fCb;
    public long fCc;
    public long fCd;
    public long fCe;
    public long fCf;
    public long fCg;
    public long fCh;
    public long fCi;
    public long fCj;
    public long fCk;
    public long fCl;
    public long fCm;
    public long fCn;
    public long fCo;
    public boolean fCp;
    public long fCq;
    public long fCr;
    public boolean fCs;
    public long fCt;
    public long fCu;
    public long fCv;
    public long fCw;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public h() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fCk = 0L;
        this.fCm = 0L;
        this.fCn = 0L;
        this.fCo = 0L;
        this.fCq = 0L;
        this.fCr = 0L;
        this.fCs = false;
        this.extra = new HashMap<>();
    }

    public h(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fCk = 0L;
        this.fCm = 0L;
        this.fCn = 0L;
        this.fCo = 0L;
        this.fCq = 0L;
        this.fCr = 0L;
        this.fCs = false;
        this.extra = new HashMap<>();
        if (responsedMessage != null) {
            this.mSubType = i;
            this.fCp = z;
            if (this.fCp) {
                this.fCo = responsedMessage.getDownSize();
                this.fCt = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.fCq = responsedMessage.performanceData.mHttpRetryNum;
                this.fCr = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.fCn = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.fCb = j;
            this.fCc = j4;
            this.fCd = j2;
            this.fCl = j3;
            this.fCj = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.fCe = responsedMessage.performanceData.mQueneTime;
            this.fCf = responsedMessage.performanceData.mNetConTime;
            this.fCg = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.fCh = responsedMessage.performanceData.mCompressTime;
            this.fCi = responsedMessage.performanceData.mAnalysisTime;
            this.fCk = responsedMessage.performanceData.mTaskWaitTime;
            this.fCk += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.fCs = z2;
            this.fCm = j6;
        }
    }

    public void bFi() {
        n nVar = (n) l.bFl().sL(this.mSubType);
        if (nVar != null) {
            nVar.a(this);
        }
    }

    public void kR(boolean z) {
        n nVar = (n) l.bFl().sL(this.mSubType);
        if (nVar != null) {
            nVar.a(this, z);
        }
    }

    public void sJ(int i) {
        n nVar = (n) l.bFl().sL(this.mSubType);
        if (nVar != null) {
            nVar.a(this, i);
        }
    }

    public void eg(String str, String str2) {
        if (!au.isEmpty(str) && !au.isEmpty(str2)) {
            this.extra.put(str, str2);
        }
    }
}
