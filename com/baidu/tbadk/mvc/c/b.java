package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int ecb;
    private boolean ecc = true;
    private com.baidu.tbadk.mvc.b.a ecd;
    private com.baidu.tbadk.mvc.d.b ece;
    private com.baidu.tbadk.mvc.a.a ecf;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.ecb = i;
        this.ecd = aVar;
        this.ece = bVar;
        this.ecf = aVar2;
    }

    public int aYJ() {
        return this.ecb;
    }

    public com.baidu.tbadk.mvc.b.a aYK() {
        return this.ecd;
    }

    public com.baidu.tbadk.mvc.d.b aYL() {
        return this.ece;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.ece = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean aYM() {
        return this.ecc;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
