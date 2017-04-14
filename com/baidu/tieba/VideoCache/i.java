package com.baidu.tieba.VideoCache;
/* loaded from: classes.dex */
public class i {
    private String QM;
    private String aUK;
    private boolean aUL;
    private long aUM = -1;
    private long aUN = -1;
    private long aUO = 0;

    public String LE() {
        return this.aUK;
    }

    public void gP(String str) {
        this.aUK = str;
    }

    public String LF() {
        return this.QM;
    }

    public void gQ(String str) {
        this.QM = str;
    }

    public boolean LG() {
        return this.aUL;
    }

    public void cm(boolean z) {
        this.aUL = z;
    }

    public long LH() {
        return this.aUM;
    }

    public void ap(long j) {
        this.aUM = j;
    }

    public long LI() {
        return this.aUN;
    }

    public void aq(long j) {
        this.aUN = j;
    }

    public long getTotalLength() {
        return this.aUO;
    }

    public void L(long j) {
        this.aUO = j;
    }
}
