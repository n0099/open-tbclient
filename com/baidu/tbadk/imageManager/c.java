package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c auB = new c();
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> auC;
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> auD;

    public static c CQ() {
        return auB;
    }

    private c() {
        this.auC = null;
        this.auD = null;
        this.auC = new d(this, 0);
        this.auD = new e(this, 0);
    }

    public int CR() {
        return this.auD.getMaxSize();
    }

    public void C(int i, int i2) {
        eB(i);
        eC(i2);
    }

    public void eB(int i) {
        this.auC.T(i);
    }

    public void eC(int i) {
        this.auD.T(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.auC != null) {
            this.auC.put(str, aVar);
        }
    }

    public boolean eD(int i) {
        return this.auD.S(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.auD != null) {
            BdLog.isDebugMode();
            this.auD.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fQ(String str) {
        this.auC.remove(str);
    }

    public com.baidu.adp.widget.a.a fR(String str) {
        return this.auC.get(str);
    }

    public com.baidu.adp.widget.a.a fS(String str) {
        return this.auD.get(str);
    }

    public String toString() {
        return "pic:" + this.auD.toString() + "  photo:" + this.auC.toString();
    }

    public String cl() {
        return this.auD.size() + "/" + this.auD.getMaxSize() + "/" + this.auD.evictionCount() + "_" + this.auC.size() + "/" + this.auC.getMaxSize() + "/" + this.auC.evictionCount();
    }
}
