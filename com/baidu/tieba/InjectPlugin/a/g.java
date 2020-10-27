package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int fHV;
    protected b fHW;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.fHV = i;
    }

    public g(b bVar, int i) {
        this.fHW = bVar;
        this.fHV = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bFk() {
        return this.fHW;
    }

    public int bFl() {
        return this.fHV;
    }
}
