package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static e abx = new e();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aby;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> abz;

    public static e we() {
        return abx;
    }

    private e() {
        this.aby = null;
        this.abz = null;
        this.aby = new f(this, 0);
        this.abz = new g(this, 0);
    }

    public int wf() {
        return this.abz.cI();
    }

    public void y(int i, int i2) {
        dv(i);
        dw(i2);
    }

    public void dv(int i) {
        this.aby.U(i);
    }

    public void dw(int i) {
        this.abz.U(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aby != null) {
            this.aby.put(str, aVar);
        }
    }

    public boolean dx(int i) {
        return this.abz.T(i);
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.abz != null) {
            BdLog.isDebugMode();
            this.abz.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        c(str, aVar, false);
    }

    public void el(String str) {
        this.aby.remove(str);
    }

    public com.baidu.adp.widget.a.a em(String str) {
        return this.aby.get(str);
    }

    public com.baidu.adp.widget.a.a en(String str) {
        return this.abz.get(str);
    }

    public void wg() {
        this.aby.clear();
        this.abz.clear();
    }

    public String toString() {
        return "pic:" + this.abz.toString() + "  photo:" + this.aby.toString();
    }

    public String cs() {
        return this.abz.size() + "/" + this.abz.cI() + "/" + this.abz.evictionCount() + "_" + this.aby.size() + "/" + this.aby.cI() + "/" + this.aby.evictionCount();
    }
}
