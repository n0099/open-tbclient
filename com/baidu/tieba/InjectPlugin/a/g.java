package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int cRm;
    protected b cRn;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.cRm = i;
    }

    public g(b bVar, int i) {
        this.cRn = bVar;
        this.cRm = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b aAE() {
        return this.cRn;
    }

    public int aAF() {
        return this.cRm;
    }
}
