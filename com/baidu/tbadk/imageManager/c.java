package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c ayx = new c();
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> ayy;
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> ayz;

    public static c Ek() {
        return ayx;
    }

    private c() {
        this.ayy = null;
        this.ayz = null;
        this.ayy = new d(this, 0);
        this.ayz = new e(this, 0);
    }

    public int El() {
        return this.ayz.getMaxSize();
    }

    public void E(int i, int i2) {
        eP(i);
        eQ(i2);
    }

    public void eP(int i) {
        this.ayy.aj(i);
    }

    public void eQ(int i) {
        this.ayz.aj(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.ayy != null) {
            this.ayy.put(str, aVar);
        }
    }

    public boolean eR(int i) {
        return this.ayz.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.ayz != null) {
            BdLog.isDebugMode();
            this.ayz.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fR(String str) {
        this.ayy.remove(str);
    }

    public com.baidu.adp.widget.a.a fS(String str) {
        return this.ayy.get(str);
    }

    public com.baidu.adp.widget.a.a fT(String str) {
        return this.ayz.get(str);
    }

    public String toString() {
        return "pic:" + this.ayz.toString() + "  photo:" + this.ayy.toString();
    }

    public String df() {
        return this.ayz.size() + "/" + this.ayz.getMaxSize() + "/" + this.ayz.evictionCount() + "_" + this.ayy.size() + "/" + this.ayy.getMaxSize() + "/" + this.ayy.evictionCount();
    }
}
