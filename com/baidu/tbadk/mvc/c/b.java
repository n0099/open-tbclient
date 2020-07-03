package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private Object extra;
    private int ezk;
    private boolean ezl = true;
    private com.baidu.tbadk.mvc.b.a ezm;
    private com.baidu.tbadk.mvc.d.b ezn;
    private com.baidu.tbadk.mvc.a.a ezo;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.ezk = i;
        this.ezm = aVar;
        this.ezn = bVar;
        this.ezo = aVar2;
    }

    public int bgX() {
        return this.ezk;
    }

    public com.baidu.tbadk.mvc.b.a bgY() {
        return this.ezm;
    }

    public com.baidu.tbadk.mvc.d.b bgZ() {
        return this.ezn;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.ezn = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean bha() {
        return this.ezl;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
