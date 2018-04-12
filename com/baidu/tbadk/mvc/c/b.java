package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int aII;
    private boolean aIJ = true;
    private com.baidu.tbadk.mvc.b.a aIK;
    private com.baidu.tbadk.mvc.d.b aIL;
    private com.baidu.tbadk.mvc.a.a aIM;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aII = i;
        this.aIK = aVar;
        this.aIL = bVar;
        this.aIM = aVar2;
    }

    public int FF() {
        return this.aII;
    }

    public com.baidu.tbadk.mvc.b.a FG() {
        return this.aIK;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean FH() {
        return this.aIJ;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
