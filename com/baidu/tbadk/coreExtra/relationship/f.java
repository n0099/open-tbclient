package com.baidu.tbadk.coreExtra.relationship;
/* loaded from: classes.dex */
public class f {
    private String distance;
    private int hide;
    private long time;

    public f(String str, long j, int i) {
        this.distance = str;
        this.time = j;
        this.hide = i;
    }

    public String getDistance() {
        return this.distance;
    }

    public void cF(String str) {
        this.distance = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public int pB() {
        return this.hide;
    }

    public void co(int i) {
        this.hide = i;
    }
}
