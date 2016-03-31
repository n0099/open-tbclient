package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c axK = new c();
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> axL;
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> axM;

    public static c EO() {
        return axK;
    }

    private c() {
        this.axL = null;
        this.axM = null;
        this.axL = new d(this, 0);
        this.axM = new e(this, 0);
    }

    public int EP() {
        return this.axM.getMaxSize();
    }

    public void C(int i, int i2) {
        eR(i);
        eS(i2);
    }

    public void eR(int i) {
        this.axL.af(i);
    }

    public void eS(int i) {
        this.axM.af(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.axL != null) {
            this.axL.put(str, aVar);
        }
    }

    public boolean eT(int i) {
        return this.axM.ae(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.axM != null) {
            BdLog.isDebugMode();
            this.axM.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fN(String str) {
        this.axL.remove(str);
    }

    public com.baidu.adp.widget.a.a fO(String str) {
        return this.axL.get(str);
    }

    public com.baidu.adp.widget.a.a fP(String str) {
        return this.axM.get(str);
    }

    public String toString() {
        return "pic:" + this.axM.toString() + "  photo:" + this.axL.toString();
    }

    public String fV() {
        return this.axM.size() + "/" + this.axM.getMaxSize() + "/" + this.axM.evictionCount() + "_" + this.axL.size() + "/" + this.axL.getMaxSize() + "/" + this.axL.evictionCount();
    }
}
