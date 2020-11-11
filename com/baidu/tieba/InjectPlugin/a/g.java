package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int fNL;
    protected b fNM;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.fNL = i;
    }

    public g(b bVar, int i) {
        this.fNM = bVar;
        this.fNL = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bHJ() {
        return this.fNM;
    }

    public int bHK() {
        return this.fNL;
    }
}
