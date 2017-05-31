package com.baidu.tieba.InjectPlugin.a;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class g {
    protected int aPY;
    protected b aPZ;
    protected TbPageContext pageContext;

    public g(TbPageContext tbPageContext, int i) {
        this.pageContext = tbPageContext;
        this.aPY = i;
    }

    public g(b bVar, int i) {
        this.aPZ = bVar;
        this.aPY = i;
    }

    public TbPageContext getPageContext() {
        return this.pageContext;
    }

    public b IG() {
        return this.aPZ;
    }

    public int IH() {
        return this.aPY;
    }
}
