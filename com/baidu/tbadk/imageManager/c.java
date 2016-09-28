package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c aya = new c();
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> ayb;
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> ayc;

    public static c Ek() {
        return aya;
    }

    private c() {
        this.ayb = null;
        this.ayc = null;
        this.ayb = new d(this, 0);
        this.ayc = new e(this, 0);
    }

    public int El() {
        return this.ayc.getMaxSize();
    }

    public void E(int i, int i2) {
        eO(i);
        eP(i2);
    }

    public void eO(int i) {
        this.ayb.aj(i);
    }

    public void eP(int i) {
        this.ayc.aj(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.ayb != null) {
            this.ayb.put(str, aVar);
        }
    }

    public boolean eQ(int i) {
        return this.ayc.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.ayc != null) {
            BdLog.isDebugMode();
            this.ayc.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fV(String str) {
        this.ayb.remove(str);
    }

    public com.baidu.adp.widget.a.a fW(String str) {
        return this.ayb.get(str);
    }

    public com.baidu.adp.widget.a.a fX(String str) {
        return this.ayc.get(str);
    }

    public String toString() {
        return "pic:" + this.ayc.toString() + "  photo:" + this.ayb.toString();
    }

    public String df() {
        return this.ayc.size() + "/" + this.ayc.getMaxSize() + "/" + this.ayc.evictionCount() + "_" + this.ayb.size() + "/" + this.ayb.getMaxSize() + "/" + this.ayb.evictionCount();
    }
}
