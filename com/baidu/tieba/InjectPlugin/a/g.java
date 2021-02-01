package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int event;
    protected b gco;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.event = i;
    }

    public g(b bVar, int i) {
        this.gco = bVar;
        this.event = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bJx() {
        return this.gco;
    }

    public int bJy() {
        return this.event;
    }
}
