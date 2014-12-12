package com.baidu.tbadk.mvc.g.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public abstract class e extends f {
    protected com.baidu.tbadk.mvc.g.a.d aeD;
    protected NavigationBar aey;

    protected abstract com.baidu.tbadk.mvc.g.a.d a(NavigationBar navigationBar);

    public e(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kJ() {
        this.aey = (NavigationBar) getView().findViewById(w.view_navigation_bar);
        this.aeD = a(this.aey);
    }

    @Override // com.baidu.tbadk.mvc.g.b.f, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aeD.a(tbPageContext, i);
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.g.b.f, com.baidu.tbadk.mvc.core.c
    protected int kI() {
        return x.mvc_template_navi_tbpager;
    }
}
