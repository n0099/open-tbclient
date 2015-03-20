package com.baidu.tbadk.mvc.g.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class e extends f {
    protected NavigationBar anm;
    protected com.baidu.tbadk.mvc.g.a.d anr;

    protected abstract com.baidu.tbadk.mvc.g.a.d a(NavigationBar navigationBar);

    public e(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.core.c
    public void ov() {
        this.anm = (NavigationBar) getView().findViewById(v.view_navigation_bar);
        this.anr = a(this.anm);
    }

    @Override // com.baidu.tbadk.mvc.g.b.f, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.anr.a(tbPageContext, i);
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.g.b.f, com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return w.mvc_template_navi_tbpager;
    }
}
