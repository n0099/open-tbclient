package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int coE;
    private boolean coF = true;
    private com.baidu.tbadk.mvc.b.a coG;
    private com.baidu.tbadk.mvc.d.b coH;
    private com.baidu.tbadk.mvc.a.a coI;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.coE = i;
        this.coG = aVar;
        this.coH = bVar;
        this.coI = aVar2;
    }

    public int aob() {
        return this.coE;
    }

    public com.baidu.tbadk.mvc.b.a aoc() {
        return this.coG;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean aod() {
        return this.coF;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
