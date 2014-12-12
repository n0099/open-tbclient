package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static e aaV = new e();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aaW;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aaX;

    public static e vL() {
        return aaV;
    }

    private e() {
        this.aaW = null;
        this.aaX = null;
        this.aaW = new f(this, 0);
        this.aaX = new g(this, 0);
    }

    public int vM() {
        return this.aaX.cK();
    }

    public void y(int i, int i2) {
        dn(i);
        dp(i2);
    }

    public void dn(int i) {
        this.aaW.P(i);
    }

    public void dp(int i) {
        this.aaX.P(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aaW != null) {
            this.aaW.put(str, aVar);
        }
    }

    public boolean dq(int i) {
        return this.aaX.O(i);
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aaX != null) {
            BdLog.isDebugMode();
            this.aaX.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        c(str, aVar, false);
    }

    public void el(String str) {
        this.aaW.remove(str);
    }

    public com.baidu.adp.widget.a.a em(String str) {
        return this.aaW.get(str);
    }

    public com.baidu.adp.widget.a.a en(String str) {
        return this.aaX.get(str);
    }

    public void vN() {
        this.aaW.clear();
        this.aaX.clear();
    }

    public String toString() {
        return "pic:" + this.aaX.toString() + "  photo:" + this.aaW.toString();
    }

    public String cu() {
        return this.aaX.size() + "/" + this.aaX.cK() + "/" + this.aaX.evictionCount() + "_" + this.aaW.size() + "/" + this.aaW.cK() + "/" + this.aaW.evictionCount();
    }
}
