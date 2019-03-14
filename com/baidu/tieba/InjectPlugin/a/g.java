package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int cHD;
    protected b cHE;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.cHD = i;
    }

    public g(b bVar, int i) {
        this.cHE = bVar;
        this.cHD = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b aun() {
        return this.cHE;
    }

    public int auo() {
        return this.cHD;
    }
}
