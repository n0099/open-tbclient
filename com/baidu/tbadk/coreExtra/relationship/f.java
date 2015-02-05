package com.baidu.tbadk.coreExtra.relationship;
/* loaded from: classes.dex */
public class f {
    private String distance;
    private int hide;
    private long time;

    public f() {
    }

    public f(String str, long j, int i) {
        this.distance = str;
        this.time = j;
        this.hide = i;
    }

    public String getDistance() {
        return this.distance;
    }

    public void dz(String str) {
        this.distance = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public int ti() {
        return this.hide;
    }

    public void cV(int i) {
        this.hide = i;
    }
}
