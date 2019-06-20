package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int cwP;
    private boolean cwQ = true;
    private com.baidu.tbadk.mvc.b.a cwR;
    private com.baidu.tbadk.mvc.d.b cwS;
    private com.baidu.tbadk.mvc.a.a cwT;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.cwP = i;
        this.cwR = aVar;
        this.cwS = bVar;
        this.cwT = aVar2;
    }

    public int atb() {
        return this.cwP;
    }

    public com.baidu.tbadk.mvc.b.a atc() {
        return this.cwR;
    }

    public com.baidu.tbadk.mvc.d.b atd() {
        return this.cwS;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.cwS = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean ate() {
        return this.cwQ;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
