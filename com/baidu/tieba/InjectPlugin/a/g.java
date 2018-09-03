package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected b bhA;
    protected int bhz;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bhz = i;
    }

    public g(b bVar, int i) {
        this.bhA = bVar;
        this.bhz = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b ON() {
        return this.bhA;
    }

    public int OO() {
        return this.bhz;
    }
}
