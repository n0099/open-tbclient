package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bhy;
    protected b bhz;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bhy = i;
    }

    public g(b bVar, int i) {
        this.bhz = bVar;
        this.bhy = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b OO() {
        return this.bhz;
    }

    public int OP() {
        return this.bhy;
    }
}
