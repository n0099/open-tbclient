package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int event;
    protected b gcu;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.event = i;
    }

    public g(b bVar, int i) {
        this.gcu = bVar;
        this.event = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bJC() {
        return this.gcu;
    }

    public int bJD() {
        return this.event;
    }
}
