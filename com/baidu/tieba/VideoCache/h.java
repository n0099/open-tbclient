package com.baidu.tieba.VideoCache;
/* loaded from: classes4.dex */
public class h {
    private String bBk;
    private String cWq;
    private boolean cWr;
    private long cWs = -1;
    private long cWt = -1;
    private long cWu = 0;
    private long cWv = 0;

    public String aCv() {
        return this.cWq;
    }

    public void sg(String str) {
        this.cWq = str;
    }

    public String aCw() {
        return this.bBk;
    }

    public void sh(String str) {
        this.bBk = str;
    }

    public boolean aCx() {
        return this.cWr;
    }

    public void gm(boolean z) {
        this.cWr = z;
    }

    public long aCy() {
        return this.cWs;
    }

    public void bO(long j) {
        this.cWs = j;
    }

    public long aCz() {
        return this.cWt;
    }

    public void bP(long j) {
        this.cWt = j;
    }

    public long getTotalLength() {
        return this.cWu;
    }

    public void bh(long j) {
        this.cWu = j;
    }

    public void bQ(long j) {
        this.cWv = j;
    }

    public long aCA() {
        return this.cWv;
    }
}
