package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static e ame = new e();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> amf;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> amg;

    public static e Am() {
        return ame;
    }

    private e() {
        this.amf = null;
        this.amg = null;
        this.amf = new f(this, 0);
        this.amg = new g(this, 0);
    }

    public int An() {
        return this.amg.gl();
    }

    public void x(int i, int i2) {
        dL(i);
        dM(i2);
    }

    public void dL(int i) {
        this.amf.T(i);
    }

    public void dM(int i) {
        this.amg.T(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.amf != null) {
            this.amf.put(str, aVar);
        }
    }

    public boolean dN(int i) {
        return this.amg.S(i);
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.amg != null) {
            BdLog.isDebugMode();
            this.amg.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        c(str, aVar, false);
    }

    public void eJ(String str) {
        this.amf.remove(str);
    }

    public com.baidu.adp.widget.a.a eK(String str) {
        return this.amf.get(str);
    }

    public com.baidu.adp.widget.a.a eL(String str) {
        return this.amg.get(str);
    }

    public String toString() {
        return "pic:" + this.amg.toString() + "  photo:" + this.amf.toString();
    }

    public String fV() {
        return this.amg.size() + "/" + this.amg.gl() + "/" + this.amg.evictionCount() + "_" + this.amf.size() + "/" + this.amf.gl() + "/" + this.amf.evictionCount();
    }
}
