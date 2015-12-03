package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c auI = new c();
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> auJ;
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> auK;

    public static c CX() {
        return auI;
    }

    private c() {
        this.auJ = null;
        this.auK = null;
        this.auJ = new d(this, 0);
        this.auK = new e(this, 0);
    }

    public int CY() {
        return this.auK.getMaxSize();
    }

    public void J(int i, int i2) {
        ex(i);
        ey(i2);
    }

    public void ex(int i) {
        this.auJ.V(i);
    }

    public void ey(int i) {
        this.auK.V(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.auJ != null) {
            this.auJ.put(str, aVar);
        }
    }

    public boolean ez(int i) {
        return this.auK.U(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.auK != null) {
            BdLog.isDebugMode();
            this.auK.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fD(String str) {
        this.auJ.remove(str);
    }

    public com.baidu.adp.widget.a.a fE(String str) {
        return this.auJ.get(str);
    }

    public com.baidu.adp.widget.a.a fF(String str) {
        return this.auK.get(str);
    }

    public String toString() {
        return "pic:" + this.auK.toString() + "  photo:" + this.auJ.toString();
    }

    public String fN() {
        return this.auK.size() + "/" + this.auK.getMaxSize() + "/" + this.auK.evictionCount() + "_" + this.auJ.size() + "/" + this.auJ.getMaxSize() + "/" + this.auJ.evictionCount();
    }
}
