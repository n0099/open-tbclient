package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int dOS;
    protected b dOT;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.dOS = i;
    }

    public g(b bVar, int i) {
        this.dOT = bVar;
        this.dOS = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b aTk() {
        return this.dOT;
    }

    public int aTl() {
        return this.dOS;
    }
}
