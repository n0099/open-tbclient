package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bLF;
    protected b bLG;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bLF = i;
    }

    public g(b bVar, int i) {
        this.bLG = bVar;
        this.bLF = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b RQ() {
        return this.bLG;
    }

    public int RR() {
        return this.bLF;
    }
}
