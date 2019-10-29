package com.baidu.tieba.VideoCache;
/* loaded from: classes4.dex */
public class h {
    private String bTS;
    private String dfL;
    private boolean dfM;
    private long dfN = -1;
    private long dfO = -1;
    private long dfP = 0;
    private long dfQ = 0;

    public String aCE() {
        return this.dfL;
    }

    public void qQ(String str) {
        this.dfL = str;
    }

    public String aCF() {
        return this.bTS;
    }

    public void qR(String str) {
        this.bTS = str;
    }

    public boolean aCG() {
        return this.dfM;
    }

    public void gb(boolean z) {
        this.dfM = z;
    }

    public long aCH() {
        return this.dfN;
    }

    public void bD(long j) {
        this.dfN = j;
    }

    public long aCI() {
        return this.dfO;
    }

    public void bE(long j) {
        this.dfO = j;
    }

    public long getTotalLength() {
        return this.dfP;
    }

    public void setTotalLength(long j) {
        this.dfP = j;
    }

    public void bF(long j) {
        this.dfQ = j;
    }

    public long aCJ() {
        return this.dfQ;
    }
}
