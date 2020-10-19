package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public int errCode;
    public HashMap<String, String> extra;
    public long fgM;
    public long fgN;
    public long fgO;
    public long fgP;
    public long fgQ;
    public long fgR;
    public long fgS;
    public long fgT;
    public long fgU;
    public long fgV;
    public long fgW;
    public long fgX;
    public long fgY;
    public long fgZ;
    public boolean fha;
    public long fhb;
    public long fhc;
    public boolean fhd;
    public long fhe;
    public long fhf;
    public long fhg;
    public long fhh;
    public long firstByteReachTime;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fgV = 0L;
        this.fgX = 0L;
        this.fgY = 0L;
        this.fgZ = 0L;
        this.fhb = 0L;
        this.fhc = 0L;
        this.fhd = false;
        this.extra = new HashMap<>();
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fgV = 0L;
        this.fgX = 0L;
        this.fgY = 0L;
        this.fgZ = 0L;
        this.fhb = 0L;
        this.fhc = 0L;
        this.fhd = false;
        this.extra = new HashMap<>();
        if (responsedMessage != null) {
            this.mSubType = i;
            this.fha = z;
            if (this.fha) {
                this.fgZ = responsedMessage.getDownSize();
                this.fhe = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.fhb = responsedMessage.performanceData.mHttpRetryNum;
                this.fhc = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.fgY = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.fgM = j;
            this.fgN = j4;
            this.fgO = j2;
            this.fgW = j3;
            this.fgU = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.fgP = responsedMessage.performanceData.mQueneTime;
            this.fgQ = responsedMessage.performanceData.mNetConTime;
            this.fgR = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.fgS = responsedMessage.performanceData.mCompressTime;
            this.fgT = responsedMessage.performanceData.mAnalysisTime;
            this.fgV = responsedMessage.performanceData.mTaskWaitTime;
            this.fgV += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.fhd = z2;
            this.fgX = j6;
        }
    }

    public void bxZ() {
        o oVar = (o) m.byc().rr(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void kb(boolean z) {
        o oVar = (o) m.byc().rr(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void rp(int i) {
        o oVar = (o) m.byc().rr(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }

    public void dS(String str, String str2) {
        if (!at.isEmpty(str) && !at.isEmpty(str2)) {
            this.extra.put(str, str2);
        }
    }
}
