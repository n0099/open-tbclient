package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int bef;
    private boolean beh = true;
    private com.baidu.tbadk.mvc.b.a bei;
    private com.baidu.tbadk.mvc.d.b bej;
    private com.baidu.tbadk.mvc.a.a bek;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.bef = i;
        this.bei = aVar;
        this.bej = bVar;
        this.bek = aVar2;
    }

    public int Od() {
        return this.bef;
    }

    public com.baidu.tbadk.mvc.b.a Oe() {
        return this.bei;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean Of() {
        return this.beh;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
