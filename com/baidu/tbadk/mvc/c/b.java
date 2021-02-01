package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private Object extra;
    private int fHK;
    private boolean fHL = true;
    private com.baidu.tbadk.mvc.b.a fHM;
    private com.baidu.tbadk.mvc.d.b fHN;
    private com.baidu.tbadk.mvc.a.a fHO;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.fHK = i;
        this.fHM = aVar;
        this.fHN = bVar;
        this.fHO = aVar2;
    }

    public int bDn() {
        return this.fHK;
    }

    public com.baidu.tbadk.mvc.b.a bDo() {
        return this.fHM;
    }

    public com.baidu.tbadk.mvc.d.b bDp() {
        return this.fHN;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.fHN = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean bDq() {
        return this.fHL;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
