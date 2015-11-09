package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c asF = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> asG;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> asH;

    public static c BV() {
        return asF;
    }

    private c() {
        this.asG = null;
        this.asH = null;
        this.asG = new d(this, 0);
        this.asH = new e(this, 0);
    }

    public int BW() {
        return this.asH.gd();
    }

    public void I(int i, int i2) {
        ej(i);
        ek(i2);
    }

    public void ej(int i) {
        this.asG.U(i);
    }

    public void ek(int i) {
        this.asH.U(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.asG != null) {
            this.asG.put(str, aVar);
        }
    }

    public boolean el(int i) {
        return this.asH.T(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.asH != null) {
            BdLog.isDebugMode();
            this.asH.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fo(String str) {
        this.asG.remove(str);
    }

    public com.baidu.adp.widget.a.a fp(String str) {
        return this.asG.get(str);
    }

    public com.baidu.adp.widget.a.a fq(String str) {
        return this.asH.get(str);
    }

    public String toString() {
        return "pic:" + this.asH.toString() + "  photo:" + this.asG.toString();
    }

    public String fN() {
        return this.asH.size() + "/" + this.asH.gd() + "/" + this.asH.evictionCount() + "_" + this.asG.size() + "/" + this.asG.gd() + "/" + this.asG.evictionCount();
    }
}
