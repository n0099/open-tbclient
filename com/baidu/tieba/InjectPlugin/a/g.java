package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int cHG;
    protected b cHH;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.cHG = i;
    }

    public g(b bVar, int i) {
        this.cHH = bVar;
        this.cHG = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b auk() {
        return this.cHH;
    }

    public int aul() {
        return this.cHG;
    }
}
