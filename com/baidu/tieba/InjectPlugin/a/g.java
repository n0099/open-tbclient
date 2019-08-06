package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int cRt;
    protected b cRu;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.cRt = i;
    }

    public g(b bVar, int i) {
        this.cRu = bVar;
        this.cRt = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b aAG() {
        return this.cRu;
    }

    public int aAH() {
        return this.cRt;
    }
}
