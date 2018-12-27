package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int bej;
    private boolean bek = true;
    private com.baidu.tbadk.mvc.b.a bel;
    private com.baidu.tbadk.mvc.d.b bem;
    private com.baidu.tbadk.mvc.a.a ben;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.bej = i;
        this.bel = aVar;
        this.bem = bVar;
        this.ben = aVar2;
    }

    public int Oe() {
        return this.bej;
    }

    public com.baidu.tbadk.mvc.b.a Of() {
        return this.bel;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean Og() {
        return this.bek;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
