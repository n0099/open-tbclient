package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int cyl;
    private boolean cym = true;
    private com.baidu.tbadk.mvc.b.a cyn;
    private com.baidu.tbadk.mvc.d.b cyo;
    private com.baidu.tbadk.mvc.a.a cyp;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.cyl = i;
        this.cyn = aVar;
        this.cyo = bVar;
        this.cyp = aVar2;
    }

    public int aul() {
        return this.cyl;
    }

    public com.baidu.tbadk.mvc.b.a aum() {
        return this.cyn;
    }

    public com.baidu.tbadk.mvc.d.b aun() {
        return this.cyo;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.cyo = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean auo() {
        return this.cym;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
