package com.baidu.tbadk.mvc.g.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class c extends a {
    protected com.baidu.tbadk.mvc.g.a.d aoC;
    private NoNetworkView aoD;
    protected NavigationBar aox;

    protected abstract com.baidu.tbadk.mvc.g.a.d a(NavigationBar navigationBar);

    public c(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.g.b.a, com.baidu.tbadk.mvc.core.c
    public void oL() {
        this.aox = (NavigationBar) getView().findViewById(q.view_navigation_bar);
        this.aoC = a(this.aox);
        if (Cu()) {
            ViewGroup viewGroup = (ViewGroup) getView();
            this.aoD = new NoNetworkView(getActivity());
            this.aoD.a(new d(this));
            int indexOfChild = viewGroup.indexOfChild(this.aox);
            this.aoD.setVisibility(8);
            viewGroup.addView(this.aoD, indexOfChild + 1);
        }
        super.oL();
    }

    @Override // com.baidu.tbadk.mvc.g.b.a, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aoC.a(tbPageContext, i);
        if (this.aoD != null) {
            this.aoD.onChangeSkinType(tbPageContext, i);
        }
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.g.b.a, com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return r.mvc_template_navi_list;
    }

    protected boolean Cu() {
        return true;
    }

    public void au(boolean z) {
    }
}
