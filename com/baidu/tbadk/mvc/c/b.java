package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int cwO;
    private boolean cwP = true;
    private com.baidu.tbadk.mvc.b.a cwQ;
    private com.baidu.tbadk.mvc.d.b cwR;
    private com.baidu.tbadk.mvc.a.a cwS;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.cwO = i;
        this.cwQ = aVar;
        this.cwR = bVar;
        this.cwS = aVar2;
    }

    public int atb() {
        return this.cwO;
    }

    public com.baidu.tbadk.mvc.b.a atc() {
        return this.cwQ;
    }

    public com.baidu.tbadk.mvc.d.b atd() {
        return this.cwR;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.cwR = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean ate() {
        return this.cwP;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
