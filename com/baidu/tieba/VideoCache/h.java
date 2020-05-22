package com.baidu.tieba.VideoCache;
/* loaded from: classes9.dex */
public class h {
    private String dxm;
    private String eMa;
    private boolean eMb;
    private long eMc = -1;
    private long eMd = -1;
    private long eMe = 0;
    private long eMf = 0;

    public String blC() {
        return this.eMa;
    }

    public void zu(String str) {
        this.eMa = str;
    }

    public String getOriginUrl() {
        return this.dxm;
    }

    public void zv(String str) {
        this.dxm = str;
    }

    public boolean blD() {
        return this.eMb;
    }

    public void iX(boolean z) {
        this.eMb = z;
    }

    public long blE() {
        return this.eMc;
    }

    public void cW(long j) {
        this.eMc = j;
    }

    public long blF() {
        return this.eMd;
    }

    public void cX(long j) {
        this.eMd = j;
    }

    public long getTotalLength() {
        return this.eMe;
    }

    public void setTotalLength(long j) {
        this.eMe = j;
    }

    public void cY(long j) {
        this.eMf = j;
    }

    public long blG() {
        return this.eMf;
    }
}
