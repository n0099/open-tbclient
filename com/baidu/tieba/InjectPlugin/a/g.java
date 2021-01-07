package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int geF;
    protected b geG;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.geF = i;
    }

    public g(b bVar, int i) {
        this.geG = bVar;
        this.geF = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b bMV() {
        return this.geG;
    }

    public int bMW() {
        return this.geF;
    }
}
