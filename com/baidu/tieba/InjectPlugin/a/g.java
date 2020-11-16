package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int fNo;
    protected b fNp;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.fNo = i;
    }

    public g(b bVar, int i) {
        this.fNp = bVar;
        this.fNo = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bHc() {
        return this.fNp;
    }

    public int bHd() {
        return this.fNo;
    }
}
