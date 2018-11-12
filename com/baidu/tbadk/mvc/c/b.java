package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int baI;
    private boolean baJ = true;
    private com.baidu.tbadk.mvc.b.a baK;
    private com.baidu.tbadk.mvc.d.b baL;
    private com.baidu.tbadk.mvc.a.a baM;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.baI = i;
        this.baK = aVar;
        this.baL = bVar;
        this.baM = aVar2;
    }

    public int MZ() {
        return this.baI;
    }

    public com.baidu.tbadk.mvc.b.a Na() {
        return this.baK;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean Nb() {
        return this.baJ;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
