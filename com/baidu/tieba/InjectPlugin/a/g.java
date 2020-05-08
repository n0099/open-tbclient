package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int etG;
    protected b etH;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.etG = i;
    }

    public g(b bVar, int i) {
        this.etH = bVar;
        this.etG = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bdQ() {
        return this.etH;
    }

    public int bdR() {
        return this.etG;
    }
}
