package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bLx;
    protected b bLy;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bLx = i;
    }

    public g(b bVar, int i) {
        this.bLy = bVar;
        this.bLx = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b RO() {
        return this.bLy;
    }

    public int RP() {
        return this.bLx;
    }
}
