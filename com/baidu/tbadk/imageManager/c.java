package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c awm = new c();
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> awn;
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> awo;

    public static c CM() {
        return awm;
    }

    private c() {
        this.awn = null;
        this.awo = null;
        this.awn = new d(this, 0);
        this.awo = new e(this, 0);
    }

    public int CN() {
        return this.awo.getMaxSize();
    }

    public void J(int i, int i2) {
        er(i);
        es(i2);
    }

    public void er(int i) {
        this.awn.V(i);
    }

    public void es(int i) {
        this.awo.V(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.awn != null) {
            this.awn.put(str, aVar);
        }
    }

    public boolean et(int i) {
        return this.awo.U(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.awo != null) {
            BdLog.isDebugMode();
            this.awo.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fH(String str) {
        this.awn.remove(str);
    }

    public com.baidu.adp.widget.a.a fI(String str) {
        return this.awn.get(str);
    }

    public com.baidu.adp.widget.a.a fJ(String str) {
        return this.awo.get(str);
    }

    public String toString() {
        return "pic:" + this.awo.toString() + "  photo:" + this.awn.toString();
    }

    public String fN() {
        return this.awo.size() + "/" + this.awo.getMaxSize() + "/" + this.awo.evictionCount() + "_" + this.awn.size() + "/" + this.awn.getMaxSize() + "/" + this.awn.evictionCount();
    }
}
