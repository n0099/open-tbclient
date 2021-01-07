package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private Object extra;
    private int fKf;
    private boolean fKg = true;
    private com.baidu.tbadk.mvc.b.a fKh;
    private com.baidu.tbadk.mvc.d.b fKi;
    private com.baidu.tbadk.mvc.a.a fKj;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.fKf = i;
        this.fKh = aVar;
        this.fKi = bVar;
        this.fKj = aVar2;
    }

    public int bGO() {
        return this.fKf;
    }

    public com.baidu.tbadk.mvc.b.a bGP() {
        return this.fKh;
    }

    public com.baidu.tbadk.mvc.d.b bGQ() {
        return this.fKi;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.fKi = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean bGR() {
        return this.fKg;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
