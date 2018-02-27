package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int byi;
    private boolean byj = true;
    private com.baidu.tbadk.mvc.b.a byk;
    private com.baidu.tbadk.mvc.d.b byl;
    private com.baidu.tbadk.mvc.a.a bym;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.byi = i;
        this.byk = aVar;
        this.byl = bVar;
        this.bym = aVar2;
    }

    public int Nc() {
        return this.byi;
    }

    public com.baidu.tbadk.mvc.b.a Nd() {
        return this.byk;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean Ne() {
        return this.byj;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
