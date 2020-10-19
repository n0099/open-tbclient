package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private Object extra;
    private int ffj;
    private boolean ffk = true;
    private com.baidu.tbadk.mvc.b.a ffl;
    private com.baidu.tbadk.mvc.d.b ffm;
    private com.baidu.tbadk.mvc.a.a ffn;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.ffj = i;
        this.ffl = aVar;
        this.ffm = bVar;
        this.ffn = aVar2;
    }

    public int bxj() {
        return this.ffj;
    }

    public com.baidu.tbadk.mvc.b.a bxk() {
        return this.ffl;
    }

    public com.baidu.tbadk.mvc.d.b bxl() {
        return this.ffm;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.ffm = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean bxm() {
        return this.ffk;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
