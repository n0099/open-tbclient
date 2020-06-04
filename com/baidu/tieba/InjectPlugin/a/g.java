package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int eIq;
    protected b eIr;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.eIq = i;
    }

    public g(b bVar, int i) {
        this.eIr = bVar;
        this.eIq = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bkd() {
        return this.eIr;
    }

    public int bke() {
        return this.eIq;
    }
}
