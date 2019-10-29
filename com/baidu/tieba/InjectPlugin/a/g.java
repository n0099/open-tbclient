package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int dbG;
    protected b dbH;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.dbG = i;
    }

    public g(b bVar, int i) {
        this.dbH = bVar;
        this.dbG = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b aBe() {
        return this.dbH;
    }

    public int aBf() {
        return this.dbG;
    }
}
