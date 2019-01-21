package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bww;
    protected b bwx;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bww = i;
    }

    public g(b bVar, int i) {
        this.bwx = bVar;
        this.bww = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b Uo() {
        return this.bwx;
    }

    public int Up() {
        return this.bww;
    }
}
