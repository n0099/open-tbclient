package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int eIf;
    protected b eIg;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.eIf = i;
    }

    public g(b bVar, int i) {
        this.eIg = bVar;
        this.eIf = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bkb() {
        return this.eIg;
    }

    public int bkc() {
        return this.eIf;
    }
}
