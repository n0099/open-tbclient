package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public long eRN;
    public long eRO;
    public long eRP;
    public long eRQ;
    public long eRR;
    public long eRS;
    public long eRT;
    public long eRU;
    public long eRV;
    public long eRW;
    public long eRX;
    public long eRY;
    public long eRZ;
    public long eSa;
    public boolean eSb;
    public long eSc;
    public long eSd;
    public boolean eSe;
    public long eSf;
    public long eSg;
    public long eSh;
    public long eSi;
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
        this.eRW = 0L;
        this.eRY = 0L;
        this.eRZ = 0L;
        this.eSa = 0L;
        this.eSc = 0L;
        this.eSd = 0L;
        this.eSe = false;
        this.extra = new HashMap<>();
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.eRW = 0L;
        this.eRY = 0L;
        this.eRZ = 0L;
        this.eSa = 0L;
        this.eSc = 0L;
        this.eSd = 0L;
        this.eSe = false;
        this.extra = new HashMap<>();
        if (responsedMessage != null) {
            this.mSubType = i;
            this.eSb = z;
            if (this.eSb) {
                this.eSa = responsedMessage.getDownSize();
                this.eSf = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.eSc = responsedMessage.performanceData.mHttpRetryNum;
                this.eSd = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.eRZ = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.eRN = j;
            this.eRO = j4;
            this.eRP = j2;
            this.eRX = j3;
            this.eRV = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.eRQ = responsedMessage.performanceData.mQueneTime;
            this.eRR = responsedMessage.performanceData.mNetConTime;
            this.eRS = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.eRT = responsedMessage.performanceData.mCompressTime;
            this.eRU = responsedMessage.performanceData.mAnalysisTime;
            this.eRW = responsedMessage.performanceData.mTaskWaitTime;
            this.eRW += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.eSe = z2;
            this.eRY = j6;
        }
    }

    public void bul() {
        o oVar = (o) m.buo().qC(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void jC(boolean z) {
        o oVar = (o) m.buo().qC(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void qA(int i) {
        o oVar = (o) m.buo().qC(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }

    public void dL(String str, String str2) {
        if (!at.isEmpty(str) && !at.isEmpty(str2)) {
            this.extra.put(str, str2);
        }
    }
}
