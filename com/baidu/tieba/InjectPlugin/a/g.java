package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bsf;
    protected b bsg;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bsf = i;
    }

    public g(b bVar, int i) {
        this.bsg = bVar;
        this.bsf = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b SK() {
        return this.bsg;
    }

    public int SL() {
        return this.bsf;
    }
}
