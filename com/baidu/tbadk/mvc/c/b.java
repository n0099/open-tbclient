package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int aZU;
    private boolean aZV = true;
    private com.baidu.tbadk.mvc.b.a aZW;
    private com.baidu.tbadk.mvc.d.b aZX;
    private com.baidu.tbadk.mvc.a.a aZY;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aZU = i;
        this.aZW = aVar;
        this.aZX = bVar;
        this.aZY = aVar2;
    }

    public int MQ() {
        return this.aZU;
    }

    public com.baidu.tbadk.mvc.b.a MR() {
        return this.aZW;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean MS() {
        return this.aZV;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
