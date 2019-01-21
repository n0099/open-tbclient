package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int beV;
    private boolean beW = true;
    private com.baidu.tbadk.mvc.b.a beX;
    private com.baidu.tbadk.mvc.d.b beY;
    private com.baidu.tbadk.mvc.a.a beZ;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.beV = i;
        this.beX = aVar;
        this.beY = bVar;
        this.beZ = aVar2;
    }

    public int Ow() {
        return this.beV;
    }

    public com.baidu.tbadk.mvc.b.a Ox() {
        return this.beX;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean Oy() {
        return this.beW;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
