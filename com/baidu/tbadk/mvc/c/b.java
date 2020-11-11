package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private Object extra;
    private int ftD;
    private boolean ftE = true;
    private com.baidu.tbadk.mvc.b.a ftF;
    private com.baidu.tbadk.mvc.d.b ftG;
    private com.baidu.tbadk.mvc.a.a ftH;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.ftD = i;
        this.ftF = aVar;
        this.ftG = bVar;
        this.ftH = aVar2;
    }

    public int bBB() {
        return this.ftD;
    }

    public com.baidu.tbadk.mvc.b.a bBC() {
        return this.ftF;
    }

    public com.baidu.tbadk.mvc.d.b bBD() {
        return this.ftG;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.ftG = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean bBE() {
        return this.ftE;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
