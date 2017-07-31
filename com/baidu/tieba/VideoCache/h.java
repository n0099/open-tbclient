package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class h {
    private String Rm;
    private String aWr;
    private boolean aWs;
    private long aWt = -1;
    private long aWu = -1;
    private long aWv = 0;

    public String Kx() {
        return this.aWr;
    }

    public void hq(String str) {
        this.aWr = str;
    }

    public String getOriginUrl() {
        return this.Rm;
    }

    public void hr(String str) {
        this.Rm = str;
    }

    public boolean Ky() {
        return this.aWs;
    }

    public void cp(boolean z) {
        this.aWs = z;
    }

    public long Kz() {
        return this.aWt;
    }

    public void as(long j) {
        this.aWt = j;
    }

    public long KA() {
        return this.aWu;
    }

    public void at(long j) {
        this.aWu = j;
    }

    public long getTotalLength() {
        return this.aWv;
    }

    public void O(long j) {
        this.aWv = j;
    }
}
