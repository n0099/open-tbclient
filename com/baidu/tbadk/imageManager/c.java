package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c atR = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> atS;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> atT;

    public static c Cc() {
        return atR;
    }

    private c() {
        this.atS = null;
        this.atT = null;
        this.atS = new d(this, 0);
        this.atT = new e(this, 0);
    }

    public int Cd() {
        return this.atT.gd();
    }

    public void I(int i, int i2) {
        el(i);
        em(i2);
    }

    public void el(int i) {
        this.atS.U(i);
    }

    public void em(int i) {
        this.atT.U(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.atS != null) {
            this.atS.put(str, aVar);
        }
    }

    public boolean en(int i) {
        return this.atT.T(i);
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.atT != null) {
            BdLog.isDebugMode();
            this.atT.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        c(str, aVar, false);
    }

    public void fm(String str) {
        this.atS.remove(str);
    }

    public com.baidu.adp.widget.a.a fn(String str) {
        return this.atS.get(str);
    }

    public com.baidu.adp.widget.a.a fo(String str) {
        return this.atT.get(str);
    }

    public String toString() {
        return "pic:" + this.atT.toString() + "  photo:" + this.atS.toString();
    }

    public String fN() {
        return this.atT.size() + "/" + this.atT.gd() + "/" + this.atT.evictionCount() + "_" + this.atS.size() + "/" + this.atS.gd() + "/" + this.atS.evictionCount();
    }
}
