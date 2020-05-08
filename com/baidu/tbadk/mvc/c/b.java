package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int ecg;
    private boolean ech = true;
    private com.baidu.tbadk.mvc.b.a eci;
    private com.baidu.tbadk.mvc.d.b ecj;
    private com.baidu.tbadk.mvc.a.a eck;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.ecg = i;
        this.eci = aVar;
        this.ecj = bVar;
        this.eck = aVar2;
    }

    public int aYH() {
        return this.ecg;
    }

    public com.baidu.tbadk.mvc.b.a aYI() {
        return this.eci;
    }

    public com.baidu.tbadk.mvc.d.b aYJ() {
        return this.ecj;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.ecj = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean aYK() {
        return this.ech;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
