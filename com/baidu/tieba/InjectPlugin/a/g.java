package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class g {
    protected int fkp;
    protected b fkq;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.fkp = i;
    }

    public g(b bVar, int i) {
        this.fkq = bVar;
        this.fkp = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bzv() {
        return this.fkq;
    }

    public int bzw() {
        return this.fkp;
    }
}
