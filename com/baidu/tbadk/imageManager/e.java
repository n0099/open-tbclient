package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static e UN = new e();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> UO;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> UP;

    public static e sg() {
        return UN;
    }

    private e() {
        this.UO = null;
        this.UP = null;
        this.UO = new f(this, 0);
        this.UP = new g(this, 0);
    }

    public int sh() {
        return this.UP.cj();
    }

    public void v(int i, int i2) {
        cP(i);
        cQ(i2);
    }

    public void cP(int i) {
        this.UO.H(i);
    }

    public void cQ(int i) {
        this.UP.H(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.UO != null) {
            this.UO.put(str, aVar);
        }
    }

    public boolean cR(int i) {
        return this.UP.G(i);
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.UP != null) {
            BdLog.isDebugMode();
            this.UP.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        c(str, aVar, false);
    }

    public void dr(String str) {
        this.UO.remove(str);
    }

    public com.baidu.adp.widget.a.a ds(String str) {
        return this.UO.get(str);
    }

    public com.baidu.adp.widget.a.a dt(String str) {
        return this.UP.get(str);
    }

    public void si() {
        this.UO.clear();
        this.UP.clear();
    }

    public String toString() {
        return "pic:" + this.UP.toString() + "  photo:" + this.UO.toString();
    }

    public String bU() {
        return this.UP.size() + "/" + this.UP.cj() + "/" + this.UP.evictionCount() + "_" + this.UO.size() + "/" + this.UO.cj() + "/" + this.UO.evictionCount();
    }
}
