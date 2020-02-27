package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int dBP;
    private boolean dBQ = true;
    private com.baidu.tbadk.mvc.b.a dBR;
    private com.baidu.tbadk.mvc.d.b dBS;
    private com.baidu.tbadk.mvc.a.a dBT;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.dBP = i;
        this.dBR = aVar;
        this.dBS = bVar;
        this.dBT = aVar2;
    }

    public int aQl() {
        return this.dBP;
    }

    public com.baidu.tbadk.mvc.b.a aQm() {
        return this.dBR;
    }

    public com.baidu.tbadk.mvc.d.b aQn() {
        return this.dBS;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.dBS = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean aQo() {
        return this.dBQ;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
