package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int cSm;
    protected b cSn;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.cSm = i;
    }

    public g(b bVar, int i) {
        this.cSn = bVar;
        this.cSm = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b aAU() {
        return this.cSn;
    }

    public int aAV() {
        return this.cSm;
    }
}
