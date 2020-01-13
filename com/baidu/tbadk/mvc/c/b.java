package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int dxM;
    private boolean dxN = true;
    private com.baidu.tbadk.mvc.b.a dxO;
    private com.baidu.tbadk.mvc.d.b dxP;
    private com.baidu.tbadk.mvc.a.a dxQ;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.dxM = i;
        this.dxO = aVar;
        this.dxP = bVar;
        this.dxQ = aVar2;
    }

    public int aNR() {
        return this.dxM;
    }

    public com.baidu.tbadk.mvc.b.a aNS() {
        return this.dxO;
    }

    public com.baidu.tbadk.mvc.d.b aNT() {
        return this.dxP;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.dxP = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean aNU() {
        return this.dxN;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
