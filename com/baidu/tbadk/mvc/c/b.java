package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int dCd;
    private boolean dCe = true;
    private com.baidu.tbadk.mvc.b.a dCf;
    private com.baidu.tbadk.mvc.d.b dCg;
    private com.baidu.tbadk.mvc.a.a dCh;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.dCd = i;
        this.dCf = aVar;
        this.dCg = bVar;
        this.dCh = aVar2;
    }

    public int aQo() {
        return this.dCd;
    }

    public com.baidu.tbadk.mvc.b.a aQp() {
        return this.dCf;
    }

    public com.baidu.tbadk.mvc.d.b aQq() {
        return this.dCg;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.dCg = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean aQr() {
        return this.dCe;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
