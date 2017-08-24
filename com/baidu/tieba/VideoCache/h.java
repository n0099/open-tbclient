package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class h {
    private String Ro;
    private String aWt;
    private boolean aWu;
    private long aWv = -1;
    private long aWw = -1;
    private long aWx = 0;

    public String Kx() {
        return this.aWt;
    }

    public void ht(String str) {
        this.aWt = str;
    }

    public String getOriginUrl() {
        return this.Ro;
    }

    public void hu(String str) {
        this.Ro = str;
    }

    public boolean Ky() {
        return this.aWu;
    }

    public void cp(boolean z) {
        this.aWu = z;
    }

    public long Kz() {
        return this.aWv;
    }

    public void as(long j) {
        this.aWv = j;
    }

    public long KA() {
        return this.aWw;
    }

    public void at(long j) {
        this.aWw = j;
    }

    public long getTotalLength() {
        return this.aWx;
    }

    public void O(long j) {
        this.aWx = j;
    }
}
