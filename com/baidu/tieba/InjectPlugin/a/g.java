package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bnr;
    protected b bns;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bnr = i;
    }

    public g(b bVar, int i) {
        this.bns = bVar;
        this.bnr = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b QH() {
        return this.bns;
    }

    public int QI() {
        return this.bnr;
    }
}
