package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class e {
    private static e ald = new e();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> ale;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> alf;

    public static e zy() {
        return ald;
    }

    private e() {
        this.ale = null;
        this.alf = null;
        this.ale = new f(this, 0);
        this.alf = new g(this, 0);
    }

    public int zz() {
        return this.alf.gh();
    }

    public void w(int i, int i2) {
        dC(i);
        dD(i2);
    }

    public void dC(int i) {
        this.ale.V(i);
    }

    public void dD(int i) {
        this.alf.V(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.ale != null) {
            this.ale.put(str, aVar);
        }
    }

    public boolean dE(int i) {
        return this.alf.U(i);
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.alf != null) {
            BdLog.isDebugMode();
            this.alf.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        c(str, aVar, false);
    }

    public void es(String str) {
        this.ale.remove(str);
    }

    public com.baidu.adp.widget.a.a et(String str) {
        return this.ale.get(str);
    }

    public com.baidu.adp.widget.a.a eu(String str) {
        return this.alf.get(str);
    }

    public void zA() {
        this.ale.clear();
        this.alf.clear();
    }

    public String toString() {
        return "pic:" + this.alf.toString() + "  photo:" + this.ale.toString();
    }

    public String fQ() {
        return this.alf.size() + "/" + this.alf.gh() + "/" + this.alf.evictionCount() + "_" + this.ale.size() + "/" + this.ale.gh() + "/" + this.ale.evictionCount();
    }
}
