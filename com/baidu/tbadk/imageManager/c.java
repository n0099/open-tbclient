package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c avt = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> avu;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> avv;

    public static c Cs() {
        return avt;
    }

    private c() {
        this.avu = null;
        this.avv = null;
        this.avu = new d(this, 0);
        this.avv = new e(this, 0);
    }

    public int Ct() {
        return this.avv.gd();
    }

    public void I(int i, int i2) {
        ek(i);
        el(i2);
    }

    public void ek(int i) {
        this.avu.U(i);
    }

    public void el(int i) {
        this.avv.U(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.avu != null) {
            this.avu.put(str, aVar);
        }
    }

    public boolean em(int i) {
        return this.avv.T(i);
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.avv != null) {
            BdLog.isDebugMode();
            this.avv.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        c(str, aVar, false);
    }

    public void fh(String str) {
        this.avu.remove(str);
    }

    public com.baidu.adp.widget.a.a fi(String str) {
        return this.avu.get(str);
    }

    public com.baidu.adp.widget.a.a fj(String str) {
        return this.avv.get(str);
    }

    public String toString() {
        return "pic:" + this.avv.toString() + "  photo:" + this.avu.toString();
    }

    public String fN() {
        return this.avv.size() + "/" + this.avv.gd() + "/" + this.avv.evictionCount() + "_" + this.avu.size() + "/" + this.avu.gd() + "/" + this.avu.evictionCount();
    }
}
