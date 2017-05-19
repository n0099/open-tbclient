package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c aCW = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aCX;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aCY;

    public static c DN() {
        return aCW;
    }

    private c() {
        this.aCX = null;
        this.aCY = null;
        this.aCX = new d(this, 0);
        this.aCY = new e(this, 0);
    }

    public int DO() {
        return this.aCY.getMaxSize();
    }

    public void L(int i, int i2) {
        eN(i);
        eO(i2);
    }

    public void eN(int i) {
        this.aCX.ai(i);
    }

    public void eO(int i) {
        this.aCY.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aCX != null) {
            this.aCX.put(str, aVar);
        }
    }

    public boolean eP(int i) {
        return this.aCY.ah(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aCY != null) {
            BdLog.isDebugMode();
            this.aCY.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fJ(String str) {
        this.aCX.remove(str);
    }

    public com.baidu.adp.widget.a.a fK(String str) {
        return this.aCX.get(str);
    }

    public com.baidu.adp.widget.a.a fL(String str) {
        return this.aCY.get(str);
    }

    public String toString() {
        return "pic:" + this.aCY.toString() + "  photo:" + this.aCX.toString();
    }

    public String em() {
        return this.aCY.size() + "/" + this.aCY.getMaxSize() + "/" + this.aCY.evictionCount() + "_" + this.aCX.size() + "/" + this.aCX.getMaxSize() + "/" + this.aCX.evictionCount();
    }
}
