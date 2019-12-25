package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int dxE;
    private boolean dxF = true;
    private com.baidu.tbadk.mvc.b.a dxG;
    private com.baidu.tbadk.mvc.d.b dxH;
    private com.baidu.tbadk.mvc.a.a dxI;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.dxE = i;
        this.dxG = aVar;
        this.dxH = bVar;
        this.dxI = aVar2;
    }

    public int aNy() {
        return this.dxE;
    }

    public com.baidu.tbadk.mvc.b.a aNz() {
        return this.dxG;
    }

    public com.baidu.tbadk.mvc.d.b aNA() {
        return this.dxH;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.dxH = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean aNB() {
        return this.dxF;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
