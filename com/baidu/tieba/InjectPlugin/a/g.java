package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int fZV;
    protected b fZW;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.fZV = i;
    }

    public g(b bVar, int i) {
        this.fZW = bVar;
        this.fZV = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bJd() {
        return this.fZW;
    }

    public int bJe() {
        return this.fZV;
    }
}
