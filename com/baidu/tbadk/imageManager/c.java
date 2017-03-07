package com.baidu.tbadk.imageManager;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class c {
    private static c aCF = new c();
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aCG;
    private com.baidu.adp.lib.e.a<String, com.baidu.adp.widget.a.a> aCH;

    public static c El() {
        return aCF;
    }

    private c() {
        this.aCG = null;
        this.aCH = null;
        this.aCG = new d(this, 0);
        this.aCH = new e(this, 0);
    }

    public int Em() {
        return this.aCH.getMaxSize();
    }

    public void L(int i, int i2) {
        eO(i);
        eP(i2);
    }

    public void eO(int i) {
        this.aCG.ak(i);
    }

    public void eP(int i) {
        this.aCH.ak(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar) {
        a(str, aVar, false);
    }

    public void a(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aCG != null) {
            this.aCG.put(str, aVar);
        }
    }

    public boolean eQ(int i) {
        return this.aCH.aj(i);
    }

    public void b(String str, com.baidu.adp.widget.a.a aVar, boolean z) {
        if (aVar != null && this.aCH != null) {
            BdLog.isDebugMode();
            this.aCH.put(str, aVar);
        }
    }

    public void c(String str, com.baidu.adp.widget.a.a aVar) {
        b(str, aVar, false);
    }

    public void fG(String str) {
        this.aCG.remove(str);
    }

    public com.baidu.adp.widget.a.a fH(String str) {
        return this.aCG.get(str);
    }

    public com.baidu.adp.widget.a.a fI(String str) {
        return this.aCH.get(str);
    }

    public String toString() {
        return "pic:" + this.aCH.toString() + "  photo:" + this.aCG.toString();
    }

    public String em() {
        return this.aCH.size() + "/" + this.aCH.getMaxSize() + "/" + this.aCH.evictionCount() + "_" + this.aCG.size() + "/" + this.aCG.getMaxSize() + "/" + this.aCG.evictionCount();
    }
}
