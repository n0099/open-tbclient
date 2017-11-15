package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aUt;
    protected b aUu;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aUt = i;
    }

    public g(b bVar, int i) {
        this.aUu = bVar;
        this.aUt = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b Kd() {
        return this.aUu;
    }

    public int Ke() {
        return this.aUt;
    }
}
