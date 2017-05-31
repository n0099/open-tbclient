package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c aCJ = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aCK;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aCL;

    public static c DH() {
        return aCJ;
    }

    private c() {
        this.aCK = null;
        this.aCL = null;
        this.aCK = new d(this, 0);
        this.aCL = new e(this, 0);
    }

    public int DI() {
        return this.aCL.getMaxSize();
    }

    public void K(int i, int i2) {
        eO(i);
        eP(i2);
    }

    public void eO(int i) {
        this.aCK.aj(i);
    }

    public void eP(int i) {
        this.aCL.aj(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aCK != null) {
            this.aCK.put(str, aVar);
        }
    }

    public boolean eQ(int i) {
        return this.aCL.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aCL != null) {
            BdLog.isDebugMode();
            this.aCL.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fH(String str) {
        this.aCK.remove(str);
    }

    public void fI(String str) {
        this.aCL.remove(str);
    }

    public com.baidu.adp.widget.a.a fJ(String str) {
        return this.aCK.get(str);
    }

    public com.baidu.adp.widget.a.a fK(String str) {
        return this.aCL.get(str);
    }

    public String toString() {
        return "pic:" + this.aCL.toString() + "  photo:" + this.aCK.toString();
    }

    public String em() {
        return this.aCL.size() + "/" + this.aCL.getMaxSize() + "/" + this.aCL.evictionCount() + "_" + this.aCK.size() + "/" + this.aCK.getMaxSize() + "/" + this.aCK.evictionCount();
    }
}
