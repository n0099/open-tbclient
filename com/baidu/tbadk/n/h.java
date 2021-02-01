package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.au;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h extends g {
    public long allDataReadTime;
    public long cmm;
    public int errCode;
    public HashMap<String, String> extra;
    public long fJA;
    public boolean fJB;
    public long fJC;
    public long fJD;
    public long fJE;
    public long fJF;
    public long fJl;
    public long fJm;
    public long fJn;
    public long fJo;
    public long fJp;
    public long fJq;
    public long fJr;
    public long fJs;
    public long fJt;
    public long fJu;
    public long fJv;
    public long fJw;
    public long fJx;
    public boolean fJy;
    public long fJz;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public h() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fJt = 0L;
        this.fJv = 0L;
        this.fJw = 0L;
        this.fJx = 0L;
        this.fJz = 0L;
        this.fJA = 0L;
        this.fJB = false;
        this.extra = new HashMap<>();
    }

    public h(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fJt = 0L;
        this.fJv = 0L;
        this.fJw = 0L;
        this.fJx = 0L;
        this.fJz = 0L;
        this.fJA = 0L;
        this.fJB = false;
        this.extra = new HashMap<>();
        if (responsedMessage != null) {
            this.mSubType = i;
            this.fJy = z;
            if (this.fJy) {
                this.fJx = responsedMessage.getDownSize();
                this.fJC = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.fJz = responsedMessage.performanceData.mHttpRetryNum;
                this.fJA = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.fJw = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.fJl = j;
            this.fJm = j4;
            this.fJn = j2;
            this.fJu = j3;
            this.fJs = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.cmm = responsedMessage.performanceData.mQueneTime;
            this.fJo = responsedMessage.performanceData.mNetConTime;
            this.fJp = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.fJq = responsedMessage.performanceData.mCompressTime;
            this.fJr = responsedMessage.performanceData.mAnalysisTime;
            this.fJt = responsedMessage.performanceData.mTaskWaitTime;
            this.fJt += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.fJB = z2;
            this.fJv = j6;
        }
    }

    public void bEd() {
        m mVar = (m) k.bEg().rv(this.mSubType);
        if (mVar != null) {
            mVar.a(this);
        }
    }

    public void lm(boolean z) {
        m mVar = (m) k.bEg().rv(this.mSubType);
        if (mVar != null) {
            mVar.a(this, z);
        }
    }

    public void ru(int i) {
        m mVar = (m) k.bEg().rv(this.mSubType);
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
