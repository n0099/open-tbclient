package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long bGc;
    public long eUE;
    public long eUF;
    public long eUG;
    public long eUH;
    public long eUI;
    public long eUJ;
    public long eUK;
    public long eUL;
    public long eUM;
    public long eUN;
    public long eUO;
    public long eUP;
    public long eUQ;
    public boolean eUR;
    public long eUS;
    public long eUT;
    public boolean eUU;
    public long eUV;
    public long eUW;
    public long eUX;
    public long eUY;
    public int errCode;
    public HashMap<String, String> extra;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.eUM = 0L;
        this.eUO = 0L;
        this.eUP = 0L;
        this.eUQ = 0L;
        this.eUS = 0L;
        this.eUT = 0L;
        this.eUU = false;
        this.extra = new HashMap<>();
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.eUM = 0L;
        this.eUO = 0L;
        this.eUP = 0L;
        this.eUQ = 0L;
        this.eUS = 0L;
        this.eUT = 0L;
        this.eUU = false;
        this.extra = new HashMap<>();
        if (responsedMessage != null) {
            this.mSubType = i;
            this.eUR = z;
            if (this.eUR) {
                this.eUQ = responsedMessage.getDownSize();
                this.eUV = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.eUS = responsedMessage.performanceData.mHttpRetryNum;
                this.eUT = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.eUP = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.eUE = j;
            this.eUF = j4;
            this.eUG = j2;
            this.eUN = j3;
            this.eUL = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.bGc = responsedMessage.performanceData.mQueneTime;
            this.eUH = responsedMessage.performanceData.mNetConTime;
            this.eUI = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.eUJ = responsedMessage.performanceData.mCompressTime;
            this.eUK = responsedMessage.performanceData.mAnalysisTime;
            this.eUM = responsedMessage.performanceData.mTaskWaitTime;
            this.eUM += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.eUU = z2;
            this.eUO = j6;
        }
    }

    public void bvp() {
        o oVar = (o) m.bvs().qT(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void jD(boolean z) {
        o oVar = (o) m.bvs().qT(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void qR(int i) {
        o oVar = (o) m.bvs().qT(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }

    public void dN(String str, String str2) {
        if (!at.isEmpty(str) && !at.isEmpty(str2)) {
            this.extra.put(str, str2);
        }
    }
}
