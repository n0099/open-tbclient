package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int eTb;
    private boolean eTc = true;
    private com.baidu.tbadk.mvc.b.a eTd;
    private com.baidu.tbadk.mvc.d.b eTe;
    private com.baidu.tbadk.mvc.a.a eTf;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.eTb = i;
        this.eTd = aVar;
        this.eTe = bVar;
        this.eTf = aVar2;
    }

    public int buz() {
        return this.eTb;
    }

    public com.baidu.tbadk.mvc.b.a buA() {
        return this.eTd;
    }

    public com.baidu.tbadk.mvc.d.b buB() {
        return this.eTe;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.eTe = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean buC() {
        return this.eTc;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
