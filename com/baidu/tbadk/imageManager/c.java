package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c axd = new c();
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> axe;
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> axf;

    public static c Ed() {
        return axd;
    }

    private c() {
        this.axe = null;
        this.axf = null;
        this.axe = new d(this, 0);
        this.axf = new e(this, 0);
    }

    public int Ee() {
        return this.axf.getMaxSize();
    }

    public void F(int i, int i2) {
        eL(i);
        eM(i2);
    }

    public void eL(int i) {
        this.axe.ag(i);
    }

    public void eM(int i) {
        this.axf.ag(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.axe != null) {
            this.axe.put(str, aVar);
        }
    }

    public boolean eN(int i) {
        return this.axf.af(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.axf != null) {
            BdLog.isDebugMode();
            this.axf.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fF(String str) {
        this.axe.remove(str);
    }

    public com.baidu.adp.widget.a.a fG(String str) {
        return this.axe.get(str);
    }

    public com.baidu.adp.widget.a.a fH(String str) {
        return this.axf.get(str);
    }

    public String toString() {
        return "pic:" + this.axf.toString() + "  photo:" + this.axe.toString();
    }

    public String fV() {
        return this.axf.size() + "/" + this.axf.getMaxSize() + "/" + this.axf.evictionCount() + "_" + this.axe.size() + "/" + this.axe.getMaxSize() + "/" + this.axe.evictionCount();
    }
}
