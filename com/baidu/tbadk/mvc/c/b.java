package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private Object extra;
    private com.baidu.tbadk.mvc.b.a fFA;
    private com.baidu.tbadk.mvc.d.b fFB;
    private com.baidu.tbadk.mvc.a.a fFC;
    private int fFy;
    private boolean fFz = true;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.fFy = i;
        this.fFA = aVar;
        this.fFB = bVar;
        this.fFC = aVar2;
    }

    public int bCV() {
        return this.fFy;
    }

    public com.baidu.tbadk.mvc.b.a bCW() {
        return this.fFA;
    }

    public com.baidu.tbadk.mvc.d.b bCX() {
        return this.fFB;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.fFB = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean bCY() {
        return this.fFz;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
