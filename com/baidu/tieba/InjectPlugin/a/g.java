package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int cPP;
    protected b cPQ;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.cPP = i;
    }

    public g(b bVar, int i) {
        this.cPQ = bVar;
        this.cPP = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b azq() {
        return this.cPQ;
    }

    public int azr() {
        return this.cPP;
    }
}
