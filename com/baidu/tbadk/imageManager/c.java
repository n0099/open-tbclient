package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c aDN = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aDO;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aDP;

    public static c Eb() {
        return aDN;
    }

    private c() {
        this.aDO = null;
        this.aDP = null;
        this.aDO = new d(this, 0);
        this.aDP = new e(this, 0);
    }

    public int Ec() {
        return this.aDP.getMaxSize();
    }

    public void K(int i, int i2) {
        eQ(i);
        eR(i2);
    }

    public void eQ(int i) {
        this.aDO.aj(i);
    }

    public void eR(int i) {
        this.aDP.aj(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aDO != null) {
            this.aDO.put(str, aVar);
        }
    }

    public boolean eS(int i) {
        return this.aDP.ai(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aDP != null) {
            BdLog.isDebugMode();
            this.aDP.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void gb(String str) {
        this.aDO.remove(str);
    }

    public void gc(String str) {
        this.aDP.remove(str);
    }

    public com.baidu.adp.widget.a.a gd(String str) {
        return this.aDO.get(str);
    }

    public com.baidu.adp.widget.a.a ge(String str) {
        return this.aDP.get(str);
    }

    public void Ed() {
        this.aDO.clear();
        this.aDP.clear();
    }

    public String toString() {
        return "pic:" + this.aDP.toString() + "  photo:" + this.aDO.toString();
    }

    public String el() {
        return this.aDP.size() + "/" + this.aDP.getMaxSize() + "/" + this.aDP.evictionCount() + "_" + this.aDO.size() + "/" + this.aDO.getMaxSize() + "/" + this.aDO.evictionCount();
    }
}
