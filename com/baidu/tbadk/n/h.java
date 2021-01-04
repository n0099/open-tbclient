package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h extends g {
    public long allDataReadTime;
    public long cmK;
    public int errCode;
    public HashMap<String, String> extra;
    public long fLH;
    public long fLI;
    public long fLJ;
    public long fLK;
    public long fLL;
    public long fLM;
    public long fLN;
    public long fLO;
    public long fLP;
    public long fLQ;
    public long fLR;
    public long fLS;
    public long fLT;
    public boolean fLU;
    public long fLV;
    public long fLW;
    public boolean fLX;
    public long fLY;
    public long fLZ;
    public long fMa;
    public long fMb;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public h() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fLP = 0L;
        this.fLR = 0L;
        this.fLS = 0L;
        this.fLT = 0L;
        this.fLV = 0L;
        this.fLW = 0L;
        this.fLX = false;
        this.extra = new HashMap<>();
    }

    public h(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fLP = 0L;
        this.fLR = 0L;
        this.fLS = 0L;
        this.fLT = 0L;
        this.fLV = 0L;
        this.fLW = 0L;
        this.fLX = false;
        this.extra = new HashMap<>();
        if (responsedMessage != null) {
            this.mSubType = i;
            this.fLU = z;
            if (this.fLU) {
                this.fLT = responsedMessage.getDownSize();
                this.fLY = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.fLV = responsedMessage.performanceData.mHttpRetryNum;
                this.fLW = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.fLS = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.fLH = j;
            this.fLI = j4;
            this.fLJ = j2;
            this.fLQ = j3;
            this.fLO = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.cmK = responsedMessage.performanceData.mQueneTime;
            this.fLK = responsedMessage.performanceData.mNetConTime;
            this.fLL = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.fLM = responsedMessage.performanceData.mCompressTime;
            this.fLN = responsedMessage.performanceData.mAnalysisTime;
            this.fLP = responsedMessage.performanceData.mTaskWaitTime;
            this.fLP += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.fLX = z2;
            this.fLR = j6;
        }
    }

    public void bHC() {
        m mVar = (m) k.bHF().sW(this.mSubType);
        if (mVar != null) {
            mVar.a(this);
        }
    }

    public void ln(boolean z) {
        m mVar = (m) k.bHF().sW(this.mSubType);
        if (mVar != null) {
            mVar.a(this, z);
        }
    }

    public void sV(int i) {
        m mVar = (m) k.bHF().sW(this.mSubType);
        if (mVar != null) {
            mVar.a(this, i);
        }
    }

    public void ef(String str, String str2) {
        if (!at.isEmpty(str) && !at.isEmpty(str2)) {
            this.extra.put(str, str2);
        }
    }
}
