package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aXy;
    protected b aXz;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aXy = i;
    }

    public g(b bVar, int i) {
        this.aXz = bVar;
        this.aXy = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b KQ() {
        return this.aXz;
    }

    public int KR() {
        return this.aXy;
    }
}
