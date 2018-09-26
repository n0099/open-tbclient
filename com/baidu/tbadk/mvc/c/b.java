package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int aVv;
    private boolean aVw = true;
    private com.baidu.tbadk.mvc.b.a aVx;
    private com.baidu.tbadk.mvc.d.b aVy;
    private com.baidu.tbadk.mvc.a.a aVz;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aVv = i;
        this.aVx = aVar;
        this.aVy = bVar;
        this.aVz = aVar2;
    }

    public int KS() {
        return this.aVv;
    }

    public com.baidu.tbadk.mvc.b.a KT() {
        return this.aVx;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean KU() {
        return this.aVw;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
