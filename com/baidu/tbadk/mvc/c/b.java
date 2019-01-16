package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int beU;
    private boolean beV = true;
    private com.baidu.tbadk.mvc.b.a beW;
    private com.baidu.tbadk.mvc.d.b beX;
    private com.baidu.tbadk.mvc.a.a beY;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.beU = i;
        this.beW = aVar;
        this.beX = bVar;
        this.beY = aVar2;
    }

    public int Ow() {
        return this.beU;
    }

    public com.baidu.tbadk.mvc.b.a Ox() {
        return this.beW;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean Oy() {
        return this.beV;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
