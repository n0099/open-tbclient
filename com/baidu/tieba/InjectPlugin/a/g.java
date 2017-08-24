package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aTN;
    protected b aTO;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aTN = i;
    }

    public g(b bVar, int i) {
        this.aTO = bVar;
        this.aTN = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b Jx() {
        return this.aTO;
    }

    public int Jy() {
        return this.aTN;
    }
}
