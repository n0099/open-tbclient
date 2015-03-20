package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static e akV = new e();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> akW;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> akX;

    public static e zs() {
        return akV;
    }

    private e() {
        this.akW = null;
        this.akX = null;
        this.akW = new f(this, 0);
        this.akX = new g(this, 0);
    }

    public int zt() {
        return this.akX.gh();
    }

    public void w(int i, int i2) {
        dC(i);
        dD(i2);
    }

    public void dC(int i) {
        this.akW.V(i);
    }

    public void dD(int i) {
        this.akX.V(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.akW != null) {
            this.akW.put(str, aVar);
        }
    }

    public boolean dE(int i) {
        return this.akX.U(i);
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.akX != null) {
            BdLog.isDebugMode();
            this.akX.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        c(str, aVar, false);
    }

    public void ep(String str) {
        this.akW.remove(str);
    }

    public com.baidu.adp.widget.a.a eq(String str) {
        return this.akW.get(str);
    }

    public com.baidu.adp.widget.a.a er(String str) {
        return this.akX.get(str);
    }

    public void zu() {
        this.akW.clear();
        this.akX.clear();
    }

    public String toString() {
        return "pic:" + this.akX.toString() + "  photo:" + this.akW.toString();
    }

    public String fQ() {
        return this.akX.size() + "/" + this.akX.gh() + "/" + this.akX.evictionCount() + "_" + this.akW.size() + "/" + this.akW.gh() + "/" + this.akW.evictionCount();
    }
}
