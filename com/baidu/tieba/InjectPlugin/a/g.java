package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int eSC;
    protected b eSD;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.eSC = i;
    }

    public g(b bVar, int i) {
        this.eSD = bVar;
        this.eSC = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bmD() {
        return this.eSD;
    }

    public int bmE() {
        return this.eSC;
    }
}
