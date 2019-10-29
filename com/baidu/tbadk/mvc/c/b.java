package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private boolean cKA = true;
    private com.baidu.tbadk.mvc.b.a cKB;
    private com.baidu.tbadk.mvc.d.b cKC;
    private com.baidu.tbadk.mvc.a.a cKD;
    private int cKz;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.cKz = i;
        this.cKB = aVar;
        this.cKC = bVar;
        this.cKD = aVar2;
    }

    public int avQ() {
        return this.cKz;
    }

    public com.baidu.tbadk.mvc.b.a avR() {
        return this.cKB;
    }

    public com.baidu.tbadk.mvc.d.b avS() {
        return this.cKC;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.cKC = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean avT() {
        return this.cKA;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
