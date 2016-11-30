package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c ayS = new c();
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> ayT;
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> ayU;

    public static c Ep() {
        return ayS;
    }

    private c() {
        this.ayT = null;
        this.ayU = null;
        this.ayT = new d(this, 0);
        this.ayU = new e(this, 0);
    }

    public int Eq() {
        return this.ayU.getMaxSize();
    }

    public void E(int i, int i2) {
        eR(i);
        eS(i2);
    }

    public void eR(int i) {
        this.ayT.aj(i);
    }

    public void eS(int i) {
        this.ayU.aj(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.ayT != null) {
            this.ayT.put(str, aVar);
        }
    }

    public boolean eT(int i) {
        return this.ayU.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.ayU != null) {
            BdLog.isDebugMode();
            this.ayU.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fY(String str) {
        this.ayT.remove(str);
    }

    public com.baidu.adp.widget.a.a fZ(String str) {
        return this.ayT.get(str);
    }

    public com.baidu.adp.widget.a.a ga(String str) {
        return this.ayU.get(str);
    }

    public String toString() {
        return "pic:" + this.ayU.toString() + "  photo:" + this.ayT.toString();
    }

    public String df() {
        return this.ayU.size() + "/" + this.ayU.getMaxSize() + "/" + this.ayU.evictionCount() + "_" + this.ayT.size() + "/" + this.ayT.getMaxSize() + "/" + this.ayT.evictionCount();
    }
}
