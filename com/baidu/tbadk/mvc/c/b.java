package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int coH;
    private boolean coI = true;
    private com.baidu.tbadk.mvc.b.a coJ;
    private com.baidu.tbadk.mvc.d.b coK;
    private com.baidu.tbadk.mvc.a.a coL;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.coH = i;
        this.coJ = aVar;
        this.coK = bVar;
        this.coL = aVar2;
    }

    public int anY() {
        return this.coH;
    }

    public com.baidu.tbadk.mvc.b.a anZ() {
        return this.coJ;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean aoa() {
        return this.coI;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
