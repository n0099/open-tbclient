package com.baidu.tieba.VideoCache;
/* loaded from: classes9.dex */
public class h {
    private String dxm;
    private String eMl;
    private boolean eMm;
    private long eMn = -1;
    private long eMo = -1;
    private long eMp = 0;
    private long eMq = 0;

    public String blE() {
        return this.eMl;
    }

    public void zu(String str) {
        this.eMl = str;
    }

    public String getOriginUrl() {
        return this.dxm;
    }

    public void zv(String str) {
        this.dxm = str;
    }

    public boolean blF() {
        return this.eMm;
    }

    public void iX(boolean z) {
        this.eMm = z;
    }

    public long blG() {
        return this.eMn;
    }

    public void cW(long j) {
        this.eMn = j;
    }

    public long blH() {
        return this.eMo;
    }

    public void cX(long j) {
        this.eMo = j;
    }

    public long getTotalLength() {
        return this.eMp;
    }

    public void setTotalLength(long j) {
        this.eMp = j;
    }

    public void cY(long j) {
        this.eMq = j;
    }

    public long blI() {
        return this.eMq;
    }
}
