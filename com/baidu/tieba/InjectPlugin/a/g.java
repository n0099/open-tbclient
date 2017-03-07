package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aPn;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aPn = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public int IX() {
        return this.aPn;
    }
}
