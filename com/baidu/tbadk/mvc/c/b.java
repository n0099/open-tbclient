package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private Object extra;
    private int fJj;
    private boolean fJk = true;
    private com.baidu.tbadk.mvc.b.a fJl;
    private com.baidu.tbadk.mvc.d.b fJm;
    private com.baidu.tbadk.mvc.a.a fJn;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.fJj = i;
        this.fJl = aVar;
        this.fJm = bVar;
        this.fJn = aVar2;
    }

    public int bDq() {
        return this.fJj;
    }

    public com.baidu.tbadk.mvc.b.a bDr() {
        return this.fJl;
    }

    public com.baidu.tbadk.mvc.d.b bDs() {
        return this.fJm;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.fJm = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean bDt() {
        return this.fJk;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
