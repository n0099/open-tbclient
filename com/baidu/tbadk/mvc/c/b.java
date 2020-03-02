package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int dBQ;
    private boolean dBR = true;
    private com.baidu.tbadk.mvc.b.a dBS;
    private com.baidu.tbadk.mvc.d.b dBT;
    private com.baidu.tbadk.mvc.a.a dBU;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.dBQ = i;
        this.dBS = aVar;
        this.dBT = bVar;
        this.dBU = aVar2;
    }

    public int aQn() {
        return this.dBQ;
    }

    public com.baidu.tbadk.mvc.b.a aQo() {
        return this.dBS;
    }

    public com.baidu.tbadk.mvc.d.b aQp() {
        return this.dBT;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.dBT = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean aQq() {
        return this.dBR;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
