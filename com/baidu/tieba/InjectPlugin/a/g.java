package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int dSY;
    protected b dSZ;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.dSY = i;
    }

    public g(b bVar, int i) {
        this.dSZ = bVar;
        this.dSY = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b aVB() {
        return this.dSZ;
    }

    public int aVC() {
        return this.dSY;
    }
}
