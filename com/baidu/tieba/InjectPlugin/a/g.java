package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bwv;
    protected b bww;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bwv = i;
    }

    public g(b bVar, int i) {
        this.bww = bVar;
        this.bwv = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b Uo() {
        return this.bww;
    }

    public int Up() {
        return this.bwv;
    }
}
