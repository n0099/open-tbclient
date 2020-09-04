package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int fkt;
    protected b fku;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.fkt = i;
    }

    public g(b bVar, int i) {
        this.fku = bVar;
        this.fkt = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bzw() {
        return this.fku;
    }

    public int bzx() {
        return this.fkt;
    }
}
