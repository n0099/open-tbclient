package com.baidu.tbadk.mvc.g.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class e extends f {
    protected com.baidu.tbadk.mvc.g.a.d aoC;
    protected NavigationBar aox;

    protected abstract com.baidu.tbadk.mvc.g.a.d a(NavigationBar navigationBar);

    public e(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void oL() {
        this.aox = (NavigationBar) getView().findViewById(q.view_navigation_bar);
        this.aoC = a(this.aox);
    }

    @Override // com.baidu.tbadk.mvc.g.b.f, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aoC.a(tbPageContext, i);
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.g.b.f, com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return r.mvc_template_navi_tbpager;
    }
}
