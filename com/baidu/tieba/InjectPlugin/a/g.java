package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aTM;
    protected b aTN;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aTM = i;
    }

    public g(b bVar, int i) {
        this.aTN = bVar;
        this.aTM = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b Jx() {
        return this.aTN;
    }

    public int Jy() {
        return this.aTM;
    }
}
