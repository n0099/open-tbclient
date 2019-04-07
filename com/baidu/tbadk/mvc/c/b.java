package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int coG;
    private boolean coH = true;
    private com.baidu.tbadk.mvc.b.a coI;
    private com.baidu.tbadk.mvc.d.b coJ;
    private com.baidu.tbadk.mvc.a.a coK;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.coG = i;
        this.coI = aVar;
        this.coJ = bVar;
        this.coK = aVar2;
    }

    public int anY() {
        return this.coG;
    }

    public com.baidu.tbadk.mvc.b.a anZ() {
        return this.coI;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean aoa() {
        return this.coH;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
