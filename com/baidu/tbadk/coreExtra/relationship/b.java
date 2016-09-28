package com.baidu.tbadk.coreExtra.relationship;
/* loaded from: classes.dex */
public class b {
    private String distance;
    private int hide;
    private long time;

    public b() {
    }

    public b(String str, long j, int i) {
        this.distance = str;
        this.time = j;
        this.hide = i;
    }

    public String At() {
        return this.distance;
    }

    public void eL(String str) {
        this.distance = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public int Au() {
        return this.hide;
    }

    public void dZ(int i) {
        this.hide = i;
    }
}
