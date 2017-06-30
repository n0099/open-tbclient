package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aRq;
    protected b aRr;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aRq = i;
    }

    public g(b bVar, int i) {
        this.aRr = bVar;
        this.aRq = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b Je() {
        return this.aRr;
    }

    public int Jf() {
        return this.aRq;
    }
}
