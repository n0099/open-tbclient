package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int etB;
    protected b etC;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.etB = i;
    }

    public g(b bVar, int i) {
        this.etC = bVar;
        this.etB = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bdS() {
        return this.etC;
    }

    public int bdT() {
        return this.etB;
    }
}
