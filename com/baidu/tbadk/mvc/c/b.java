package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int cJI;
    private boolean cJJ = true;
    private com.baidu.tbadk.mvc.b.a cJK;
    private com.baidu.tbadk.mvc.d.b cJL;
    private com.baidu.tbadk.mvc.a.a cJM;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.cJI = i;
        this.cJK = aVar;
        this.cJL = bVar;
        this.cJM = aVar2;
    }

    public int avO() {
        return this.cJI;
    }

    public com.baidu.tbadk.mvc.b.a avP() {
        return this.cJK;
    }

    public com.baidu.tbadk.mvc.d.b avQ() {
        return this.cJL;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.cJL = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean avR() {
        return this.cJJ;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
