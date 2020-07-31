package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int eFA;
    private boolean eFB = true;
    private com.baidu.tbadk.mvc.b.a eFC;
    private com.baidu.tbadk.mvc.d.b eFD;
    private com.baidu.tbadk.mvc.a.a eFE;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.eFA = i;
        this.eFC = aVar;
        this.eFD = bVar;
        this.eFE = aVar2;
    }

    public int bkI() {
        return this.eFA;
    }

    public com.baidu.tbadk.mvc.b.a bkJ() {
        return this.eFC;
    }

    public com.baidu.tbadk.mvc.d.b bkK() {
        return this.eFD;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.eFD = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean bkL() {
        return this.eFB;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
