package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c atQ = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> atR;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> atS;

    public static c Cf() {
        return atQ;
    }

    private c() {
        this.atR = null;
        this.atS = null;
        this.atR = new d(this, 0);
        this.atS = new e(this, 0);
    }

    public int Cg() {
        return this.atS.gd();
    }

    public void I(int i, int i2) {
        el(i);
        em(i2);
    }

    public void el(int i) {
        this.atR.U(i);
    }

    public void em(int i) {
        this.atS.U(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.atR != null) {
            this.atR.put(str, aVar);
        }
    }

    public boolean en(int i) {
        return this.atS.T(i);
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.atS != null) {
            BdLog.isDebugMode();
            this.atS.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        c(str, aVar, false);
    }

    public void fm(String str) {
        this.atR.remove(str);
    }

    public com.baidu.adp.widget.a.a fn(String str) {
        return this.atR.get(str);
    }

    public com.baidu.adp.widget.a.a fo(String str) {
        return this.atS.get(str);
    }

    public String toString() {
        return "pic:" + this.atS.toString() + "  photo:" + this.atR.toString();
    }

    public String fN() {
        return this.atS.size() + "/" + this.atS.gd() + "/" + this.atS.evictionCount() + "_" + this.atR.size() + "/" + this.atR.gd() + "/" + this.atR.evictionCount();
    }
}
