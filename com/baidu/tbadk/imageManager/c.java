package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c atJ = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> atK;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> atL;

    public static c Ce() {
        return atJ;
    }

    private c() {
        this.atK = null;
        this.atL = null;
        this.atK = new d(this, 0);
        this.atL = new e(this, 0);
    }

    public int Cf() {
        return this.atL.gg();
    }

    public void I(int i, int i2) {
        ec(i);
        ed(i2);
    }

    public void ec(int i) {
        this.atK.U(i);
    }

    public void ed(int i) {
        this.atL.U(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.atK != null) {
            this.atK.put(str, aVar);
        }
    }

    public boolean ee(int i) {
        return this.atL.T(i);
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.atL != null) {
            BdLog.isDebugMode();
            this.atL.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        c(str, aVar, false);
    }

    public void eZ(String str) {
        this.atK.remove(str);
    }

    public com.baidu.adp.widget.a.a fa(String str) {
        return this.atK.get(str);
    }

    public com.baidu.adp.widget.a.a fb(String str) {
        return this.atL.get(str);
    }

    public String toString() {
        return "pic:" + this.atL.toString() + "  photo:" + this.atK.toString();
    }

    public String fQ() {
        return this.atL.size() + "/" + this.atL.gg() + "/" + this.atL.evictionCount() + "_" + this.atK.size() + "/" + this.atK.gg() + "/" + this.atK.evictionCount();
    }
}
