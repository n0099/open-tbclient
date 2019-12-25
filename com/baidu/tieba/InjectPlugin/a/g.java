package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int dOK;
    protected b dOL;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.dOK = i;
    }

    public g(b bVar, int i) {
        this.dOL = bVar;
        this.dOK = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b aSQ() {
        return this.dOL;
    }

    public int aSR() {
        return this.dOK;
    }
}
