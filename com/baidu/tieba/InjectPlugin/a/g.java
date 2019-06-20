package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int cPQ;
    protected b cPR;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.cPQ = i;
    }

    public g(b bVar, int i) {
        this.cPR = bVar;
        this.cPQ = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b azq() {
        return this.cPR;
    }

    public int azr() {
        return this.cPQ;
    }
}
