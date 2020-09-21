package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int fnm;
    protected b fnn;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.fnm = i;
    }

    public g(b bVar, int i) {
        this.fnn = bVar;
        this.fnm = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bAF() {
        return this.fnn;
    }

    public int bAG() {
        return this.fnm;
    }
}
