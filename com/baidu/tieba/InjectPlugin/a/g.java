package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int dTC;
    protected b dTD;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.dTC = i;
    }

    public g(b bVar, int i) {
        this.dTD = bVar;
        this.dTC = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b aVI() {
        return this.dTD;
    }

    public int aVJ() {
        return this.dTC;
    }
}
