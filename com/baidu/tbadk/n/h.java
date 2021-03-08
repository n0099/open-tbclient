package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.au;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h extends g {
    public long allDataReadTime;
    public long cnN;
    public int errCode;
    public HashMap<String, String> extra;
    public long fKL;
    public long fKM;
    public long fKN;
    public long fKO;
    public long fKP;
    public long fKQ;
    public long fKR;
    public long fKS;
    public long fKT;
    public long fKU;
    public long fKV;
    public long fKW;
    public long fKX;
    public boolean fKY;
    public long fKZ;
    public long fLa;
    public boolean fLb;
    public long fLc;
    public long fLd;
    public long fLe;
    public long fLf;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public h() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fKT = 0L;
        this.fKV = 0L;
        this.fKW = 0L;
        this.fKX = 0L;
        this.fKZ = 0L;
        this.fLa = 0L;
        this.fLb = false;
        this.extra = new HashMap<>();
    }

    public h(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fKT = 0L;
        this.fKV = 0L;
        this.fKW = 0L;
        this.fKX = 0L;
        this.fKZ = 0L;
        this.fLa = 0L;
        this.fLb = false;
        this.extra = new HashMap<>();
        if (responsedMessage != null) {
            this.mSubType = i;
            this.fKY = z;
            if (this.fKY) {
                this.fKX = responsedMessage.getDownSize();
                this.fLc = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.fKZ = responsedMessage.performanceData.mHttpRetryNum;
                this.fLa = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.fKW = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.fKL = j;
            this.fKM = j4;
            this.fKN = j2;
            this.fKU = j3;
            this.fKS = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.cnN = responsedMessage.performanceData.mQueneTime;
            this.fKO = responsedMessage.performanceData.mNetConTime;
            this.fKP = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.fKQ = responsedMessage.performanceData.mCompressTime;
            this.fKR = responsedMessage.performanceData.mAnalysisTime;
            this.fKT = responsedMessage.performanceData.mTaskWaitTime;
            this.fKT += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.fLb = z2;
            this.fKV = j6;
        }
    }

    public void bEh() {
        m mVar = (m) k.bEk().rx(this.mSubType);
        if (mVar != null) {
            mVar.a(this);
        }
    }

    public void lm(boolean z) {
        m mVar = (m) k.bEk().rx(this.mSubType);
        if (mVar != null) {
            mVar.a(this, z);
        }
    }

    public void rw(int i) {
        m mVar = (m) k.bEk().rx(this.mSubType);
        if (mVar != null) {
            mVar.a(this, i);
        }
    }

    public void dZ(String str, String str2) {
        if (!au.isEmpty(str) && !au.isEmpty(str2)) {
            this.extra.put(str, str2);
        }
    }
}
