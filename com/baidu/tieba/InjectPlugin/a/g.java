package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int cHF;
    protected b cHG;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.cHF = i;
    }

    public g(b bVar, int i) {
        this.cHG = bVar;
        this.cHF = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b auk() {
        return this.cHG;
    }

    public int aul() {
        return this.cHF;
    }
}
