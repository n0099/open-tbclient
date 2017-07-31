package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aTL;
    protected b aTM;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aTL = i;
    }

    public g(b bVar, int i) {
        this.aTM = bVar;
        this.aTL = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b Jx() {
        return this.aTM;
    }

    public int Jy() {
        return this.aTL;
    }
}
