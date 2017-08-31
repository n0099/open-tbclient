package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aTx;
    protected b aTy;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aTx = i;
    }

    public g(b bVar, int i) {
        this.aTy = bVar;
        this.aTx = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b JF() {
        return this.aTy;
    }

    public int JG() {
        return this.aTx;
    }
}
