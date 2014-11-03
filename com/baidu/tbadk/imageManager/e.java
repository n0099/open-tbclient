package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static e UR = new e();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> US;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> UT;

    public static e si() {
        return UR;
    }

    private e() {
        this.US = null;
        this.UT = null;
        this.US = new f(this, 0);
        this.UT = new g(this, 0);
    }

    public int sj() {
        return this.UT.cj();
    }

    public void v(int i, int i2) {
        cP(i);
        cQ(i2);
    }

    public void cP(int i) {
        this.US.H(i);
    }

    public void cQ(int i) {
        this.UT.H(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.US != null) {
            this.US.put(str, aVar);
        }
    }

    public boolean cR(int i) {
        return this.UT.G(i);
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.UT != null) {
            BdLog.isDebugMode();
            this.UT.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        c(str, aVar, false);
    }

    public void dr(String str) {
        this.US.remove(str);
    }

    public com.baidu.adp.widget.a.a ds(String str) {
        return this.US.get(str);
    }

    public com.baidu.adp.widget.a.a dt(String str) {
        return this.UT.get(str);
    }

    public void sk() {
        this.US.clear();
        this.UT.clear();
    }

    public String toString() {
        return "pic:" + this.UT.toString() + "  photo:" + this.US.toString();
    }

    public String bU() {
        return this.UT.size() + "/" + this.UT.cj() + "/" + this.UT.evictionCount() + "_" + this.US.size() + "/" + this.US.cj() + "/" + this.US.evictionCount();
    }
}
