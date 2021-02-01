package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class z {
    private int FrsMaxCache;
    private int FrsPn;
    private int maxCache;

    public int getMaxCache() {
        if (this.maxCache == 0) {
            return Integer.MAX_VALUE;
        }
        return this.maxCache;
    }

    public void setMaxCache(String str) {
        this.maxCache = com.baidu.adp.lib.f.b.toInt(str, 0);
    }

    public int getFrsMaxCache() {
        return this.FrsMaxCache;
    }

    public void setFrsMaxCache(String str) {
        this.FrsMaxCache = com.baidu.adp.lib.f.b.toInt(str, 0);
    }

    public int getFrsPn() {
        return this.FrsPn;
    }

    public void setFrsPn(String str) {
        this.FrsPn = com.baidu.adp.lib.f.b.toInt(str, 0);
    }
}
