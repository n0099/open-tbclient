package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.au;
import java.util.HashMap;
/* loaded from: classes.dex */
public class i extends g {
    public long allDataReadTime;
    public int errCode;
    public HashMap<String, String> extra;
    public long firstByteReachTime;
    public long fuA;
    public long fuB;
    public long fuC;
    public long fuD;
    public boolean fuE;
    public long fuF;
    public long fuG;
    public boolean fuH;
    public long fuI;
    public long fuJ;
    public long fuK;
    public long fuL;
    public long fuq;
    public long fur;
    public long fus;
    public long fut;
    public long fuu;
    public long fuv;
    public long fuw;
    public long fux;
    public long fuy;
    public long fuz;
    public boolean isSuccess;
    public long sequenceID;
    public long socketCostTime;
    public int socketErrNo;

    public i() {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fuz = 0L;
        this.fuB = 0L;
        this.fuC = 0L;
        this.fuD = 0L;
        this.fuF = 0L;
        this.fuG = 0L;
        this.fuH = false;
        this.extra = new HashMap<>();
    }

    public i(int i, boolean z, ResponsedMessage<?> responsedMessage, long j, long j2, long j3, boolean z2, long j4, long j5, long j6) {
        this.firstByteReachTime = 0L;
        this.allDataReadTime = 0L;
        this.fuz = 0L;
        this.fuB = 0L;
        this.fuC = 0L;
        this.fuD = 0L;
        this.fuF = 0L;
        this.fuG = 0L;
        this.fuH = false;
        this.extra = new HashMap<>();
        if (responsedMessage != null) {
            this.mSubType = i;
            this.fuE = z;
            if (this.fuE) {
                this.fuD = responsedMessage.getDownSize();
                this.fuI = responsedMessage.getOrginalMessage().getClientLogID();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
                this.fuF = responsedMessage.performanceData.mHttpRetryNum;
                this.fuG = responsedMessage.performanceData.mHttpRetryCostTime;
                this.socketErrNo = responsedMessage.performanceData.mSocketErrNo;
                this.socketCostTime = responsedMessage.performanceData.mSocketCostTime;
            } else {
                this.fuC = responsedMessage.getDownSize();
                this.sequenceID = responsedMessage.getOrginalMessage().getSquencedId();
            }
            this.fuq = j;
            this.fur = j4;
            this.fus = j2;
            this.fuA = j3;
            this.fuy = j5;
            this.isSuccess = !responsedMessage.hasError();
            this.fut = responsedMessage.performanceData.mQueneTime;
            this.fuu = responsedMessage.performanceData.mNetConTime;
            this.fuv = responsedMessage.performanceData.mNetRWTime;
            this.firstByteReachTime = responsedMessage.performanceData.mFirstByteReachTime;
            this.allDataReadTime = responsedMessage.performanceData.mAllDataReadTime;
            this.fuw = responsedMessage.performanceData.mCompressTime;
            this.fux = responsedMessage.performanceData.mAnalysisTime;
            this.fuz = responsedMessage.performanceData.mTaskWaitTime;
            this.fuz += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            this.errCode = responsedMessage.getError();
            this.fuH = z2;
            this.fuB = j6;
        }
    }

    public void bBH() {
        o oVar = (o) m.bBK().sk(this.mSubType);
        if (oVar != null) {
            oVar.a(this);
        }
    }

    public void ky(boolean z) {
        o oVar = (o) m.bBK().sk(this.mSubType);
        if (oVar != null) {
            oVar.a(this, z);
        }
    }

    public void si(int i) {
        o oVar = (o) m.bBK().sk(this.mSubType);
        if (oVar != null) {
            oVar.a(this, i);
        }
    }

    public void dZ(String str, String str2) {
        if (!au.isEmpty(str) && !au.isEmpty(str2)) {
            this.extra.put(str, str2);
        }
    }
}
