package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aTu;
    protected b aTv;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aTu = i;
    }

    public g(b bVar, int i) {
        this.aTv = bVar;
        this.aTu = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b JF() {
        return this.aTv;
    }

    public int JG() {
        return this.aTu;
    }
}
