package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static e abu = new e();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> abv;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> abw;

    public static e vY() {
        return abu;
    }

    private e() {
        this.abv = null;
        this.abw = null;
        this.abv = new f(this, 0);
        this.abw = new g(this, 0);
    }

    public int vZ() {
        return this.abw.cI();
    }

    public void y(int i, int i2) {
        dv(i);
        dw(i2);
    }

    public void dv(int i) {
        this.abv.U(i);
    }

    public void dw(int i) {
        this.abw.U(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.abv != null) {
            this.abv.put(str, aVar);
        }
    }

    public boolean dx(int i) {
        return this.abw.T(i);
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.abw != null) {
            BdLog.isDebugMode();
            this.abw.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        c(str, aVar, false);
    }

    public void ei(String str) {
        this.abv.remove(str);
    }

    public com.baidu.adp.widget.a.a ej(String str) {
        return this.abv.get(str);
    }

    public com.baidu.adp.widget.a.a ek(String str) {
        return this.abw.get(str);
    }

    public void wa() {
        this.abv.clear();
        this.abw.clear();
    }

    public String toString() {
        return "pic:" + this.abw.toString() + "  photo:" + this.abv.toString();
    }

    public String cs() {
        return this.abw.size() + "/" + this.abw.cI() + "/" + this.abw.evictionCount() + "_" + this.abv.size() + "/" + this.abv.cI() + "/" + this.abv.evictionCount();
    }
}
