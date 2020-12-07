package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int fUZ;
    protected b fVa;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.fUZ = i;
    }

    public g(b bVar, int i) {
        this.fVa = bVar;
        this.fUZ = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bKC() {
        return this.fVa;
    }

    public int bKD() {
        return this.fUZ;
    }
}
