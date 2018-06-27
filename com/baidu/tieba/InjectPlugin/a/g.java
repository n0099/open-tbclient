package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int bgT;
    protected b bgU;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.bgT = i;
    }

    public g(b bVar, int i) {
        this.bgU = bVar;
        this.bgT = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b OI() {
        return this.bgU;
    }

    public int OJ() {
        return this.bgT;
    }
}
