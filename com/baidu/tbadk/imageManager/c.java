package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c atL = new c();
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> atM;
    private com.baidu.adp.lib.f.a<String, com.baidu.adp.widget.a.a> atN;

    public static c CH() {
        return atL;
    }

    private c() {
        this.atM = null;
        this.atN = null;
        this.atM = new d(this, 0);
        this.atN = new e(this, 0);
    }

    public int CI() {
        return this.atN.getMaxSize();
    }

    public void C(int i, int i2) {
        ex(i);
        ey(i2);
    }

    public void ex(int i) {
        this.atM.T(i);
    }

    public void ey(int i) {
        this.atN.T(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.atM != null) {
            this.atM.put(str, aVar);
        }
    }

    public boolean ez(int i) {
        return this.atN.S(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.atN != null) {
            BdLog.isDebugMode();
            this.atN.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fK(String str) {
        this.atM.remove(str);
    }

    public com.baidu.adp.widget.a.a fL(String str) {
        return this.atM.get(str);
    }

    public com.baidu.adp.widget.a.a fM(String str) {
        return this.atN.get(str);
    }

    public String toString() {
        return "pic:" + this.atN.toString() + "  photo:" + this.atM.toString();
    }

    public String ck() {
        return this.atN.size() + "/" + this.atN.getMaxSize() + "/" + this.atN.evictionCount() + "_" + this.atM.size() + "/" + this.atM.getMaxSize() + "/" + this.atM.evictionCount();
    }
}
