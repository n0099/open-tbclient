package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c aCV = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aCW;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aCX;

    public static c EJ() {
        return aCV;
    }

    private c() {
        this.aCW = null;
        this.aCX = null;
        this.aCW = new d(this, 0);
        this.aCX = new e(this, 0);
    }

    public int EK() {
        return this.aCX.getMaxSize();
    }

    public void L(int i, int i2) {
        eR(i);
        eS(i2);
    }

    public void eR(int i) {
        this.aCW.aj(i);
    }

    public void eS(int i) {
        this.aCX.aj(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aCW != null) {
            this.aCW.put(str, aVar);
        }
    }

    public boolean eT(int i) {
        return this.aCX.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aCX != null) {
            BdLog.isDebugMode();
            this.aCX.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fM(String str) {
        this.aCW.remove(str);
    }

    public com.baidu.adp.widget.a.a fN(String str) {
        return this.aCW.get(str);
    }

    public com.baidu.adp.widget.a.a fO(String str) {
        return this.aCX.get(str);
    }

    public String toString() {
        return "pic:" + this.aCX.toString() + "  photo:" + this.aCW.toString();
    }

    public String el() {
        return this.aCX.size() + "/" + this.aCX.getMaxSize() + "/" + this.aCX.evictionCount() + "_" + this.aCW.size() + "/" + this.aCW.getMaxSize() + "/" + this.aCW.evictionCount();
    }
}
