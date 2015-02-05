package com.baidu.tbadk.mvc.g.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public abstract class e extends f {
    protected NavigationBar aeS;
    protected com.baidu.tbadk.mvc.g.a.d aeX;

    protected abstract com.baidu.tbadk.mvc.g.a.d a(NavigationBar navigationBar);

    public e(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void kC() {
        this.aeS = (NavigationBar) getView().findViewById(w.view_navigation_bar);
        this.aeX = a(this.aeS);
    }

    @Override // com.baidu.tbadk.mvc.g.b.f, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aeX.a(tbPageContext, i);
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.g.b.f, com.baidu.tbadk.mvc.core.c
    protected int kB() {
        return x.mvc_template_navi_tbpager;
    }
}
