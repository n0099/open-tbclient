package com.baidu.tbadk.mvc.g.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public abstract class c extends a {
    protected NavigationBar aeV;
    protected com.baidu.tbadk.mvc.g.a.d afa;
    private NoNetworkView afb;

    protected abstract com.baidu.tbadk.mvc.g.a.d a(NavigationBar navigationBar);

    public c(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.g.b.a, com.baidu.tbadk.mvc.core.c
    public void kJ() {
        this.aeV = (NavigationBar) getView().findViewById(w.view_navigation_bar);
        this.afa = a(this.aeV);
        if (yt()) {
            ViewGroup viewGroup = (ViewGroup) getView();
            this.afb = new NoNetworkView(getActivity());
            this.afb.a(new d(this));
            int indexOfChild = viewGroup.indexOfChild(this.aeV);
            this.afb.setVisibility(8);
            viewGroup.addView(this.afb, indexOfChild + 1);
        }
        super.kJ();
    }

    @Override // com.baidu.tbadk.mvc.g.b.a, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.afa.a(tbPageContext, i);
        if (this.afb != null) {
            this.afb.onChangeSkinType(tbPageContext, i);
        }
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.g.b.a, com.baidu.tbadk.mvc.core.c
    protected int kI() {
        return x.mvc_template_navi_list;
    }

    protected boolean yt() {
        return true;
    }

    public void at(boolean z) {
    }
}
