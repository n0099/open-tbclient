package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c avq = new c();
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> avr;
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> avs;

    public static c CP() {
        return avq;
    }

    private c() {
        this.avr = null;
        this.avs = null;
        this.avr = new d(this, 0);
        this.avs = new e(this, 0);
    }

    public int CQ() {
        return this.avs.getMaxSize();
    }

    public void C(int i, int i2) {
        eB(i);
        eC(i2);
    }

    public void eB(int i) {
        this.avr.W(i);
    }

    public void eC(int i) {
        this.avs.W(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.avr != null) {
            this.avr.put(str, aVar);
        }
    }

    public boolean eD(int i) {
        return this.avs.V(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.avs != null) {
            BdLog.isDebugMode();
            this.avs.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fO(String str) {
        this.avr.remove(str);
    }

    public com.baidu.adp.widget.a.a fP(String str) {
        return this.avr.get(str);
    }

    public com.baidu.adp.widget.a.a fQ(String str) {
        return this.avs.get(str);
    }

    public String toString() {
        return "pic:" + this.avs.toString() + "  photo:" + this.avr.toString();
    }

    public String ck() {
        return this.avs.size() + "/" + this.avs.getMaxSize() + "/" + this.avs.evictionCount() + "_" + this.avr.size() + "/" + this.avr.getMaxSize() + "/" + this.avr.evictionCount();
    }
}
