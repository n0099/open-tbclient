package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private Object extra;
    private int fsM;
    private boolean fsN = true;
    private com.baidu.tbadk.mvc.b.a fsO;
    private com.baidu.tbadk.mvc.d.b fsP;
    private com.baidu.tbadk.mvc.a.a fsQ;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.fsM = i;
        this.fsO = aVar;
        this.fsP = bVar;
        this.fsQ = aVar2;
    }

    public int bAR() {
        return this.fsM;
    }

    public com.baidu.tbadk.mvc.b.a bAS() {
        return this.fsO;
    }

    public com.baidu.tbadk.mvc.d.b bAT() {
        return this.fsP;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.fsP = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean bAU() {
        return this.fsN;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
