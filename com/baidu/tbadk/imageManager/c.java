package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c aCX = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aCY;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aCZ;

    public static c EJ() {
        return aCX;
    }

    private c() {
        this.aCY = null;
        this.aCZ = null;
        this.aCY = new d(this, 0);
        this.aCZ = new e(this, 0);
    }

    public int EK() {
        return this.aCZ.getMaxSize();
    }

    public void L(int i, int i2) {
        eR(i);
        eS(i2);
    }

    public void eR(int i) {
        this.aCY.aj(i);
    }

    public void eS(int i) {
        this.aCZ.aj(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aCY != null) {
            this.aCY.put(str, aVar);
        }
    }

    public boolean eT(int i) {
        return this.aCZ.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aCZ != null) {
            BdLog.isDebugMode();
            this.aCZ.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fM(String str) {
        this.aCY.remove(str);
    }

    public com.baidu.adp.widget.a.a fN(String str) {
        return this.aCY.get(str);
    }

    public com.baidu.adp.widget.a.a fO(String str) {
        return this.aCZ.get(str);
    }

    public String toString() {
        return "pic:" + this.aCZ.toString() + "  photo:" + this.aCY.toString();
    }

    public String em() {
        return this.aCZ.size() + "/" + this.aCZ.getMaxSize() + "/" + this.aCZ.evictionCount() + "_" + this.aCY.size() + "/" + this.aCY.getMaxSize() + "/" + this.aCY.evictionCount();
    }
}
