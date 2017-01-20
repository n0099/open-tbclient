package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c axl = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> axm;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> axn;

    public static c DS() {
        return axl;
    }

    private c() {
        this.axm = null;
        this.axn = null;
        this.axm = new d(this, 0);
        this.axn = new e(this, 0);
    }

    public int DT() {
        return this.axn.getMaxSize();
    }

    public void F(int i, int i2) {
        eT(i);
        eU(i2);
    }

    public void eT(int i) {
        this.axm.ak(i);
    }

    public void eU(int i) {
        this.axn.ak(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.axm != null) {
            this.axm.put(str, aVar);
        }
    }

    public boolean eV(int i) {
        return this.axn.aj(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.axn != null) {
            BdLog.isDebugMode();
            this.axn.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fR(String str) {
        this.axm.remove(str);
    }

    public com.baidu.adp.widget.a.a fS(String str) {
        return this.axm.get(str);
    }

    public com.baidu.adp.widget.a.a fT(String str) {
        return this.axn.get(str);
    }

    public String toString() {
        return "pic:" + this.axn.toString() + "  photo:" + this.axm.toString();
    }

    public String dd() {
        return this.axn.size() + "/" + this.axn.getMaxSize() + "/" + this.axn.evictionCount() + "_" + this.axm.size() + "/" + this.axm.getMaxSize() + "/" + this.axm.evictionCount();
    }
}
