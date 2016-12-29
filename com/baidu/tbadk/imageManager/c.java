package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c ayp = new c();
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> ayq;
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> ayr;

    public static c DX() {
        return ayp;
    }

    private c() {
        this.ayq = null;
        this.ayr = null;
        this.ayq = new d(this, 0);
        this.ayr = new e(this, 0);
    }

    public int DY() {
        return this.ayr.getMaxSize();
    }

    public void E(int i, int i2) {
        eS(i);
        eT(i2);
    }

    public void eS(int i) {
        this.ayq.ak(i);
    }

    public void eT(int i) {
        this.ayr.ak(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.ayq != null) {
            this.ayq.put(str, aVar);
        }
    }

    public boolean eU(int i) {
        return this.ayr.aj(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.ayr != null) {
            BdLog.isDebugMode();
            this.ayr.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fU(String str) {
        this.ayq.remove(str);
    }

    public com.baidu.adp.widget.a.a fV(String str) {
        return this.ayq.get(str);
    }

    public com.baidu.adp.widget.a.a fW(String str) {
        return this.ayr.get(str);
    }

    public String toString() {
        return "pic:" + this.ayr.toString() + "  photo:" + this.ayq.toString();
    }

    public String df() {
        return this.ayr.size() + "/" + this.ayr.getMaxSize() + "/" + this.ayr.evictionCount() + "_" + this.ayq.size() + "/" + this.ayq.getMaxSize() + "/" + this.ayq.evictionCount();
    }
}
