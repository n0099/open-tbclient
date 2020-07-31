package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int eYX;
    protected b eYY;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.eYX = i;
    }

    public g(b bVar, int i) {
        this.eYY = bVar;
        this.eYX = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bqx() {
        return this.eYY;
    }

    public int bqy() {
        return this.eYX;
    }
}
