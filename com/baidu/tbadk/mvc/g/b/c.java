package com.baidu.tbadk.mvc.g.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class c extends a {
    private NoNetworkView anA;
    protected NavigationBar anu;
    protected com.baidu.tbadk.mvc.g.a.d anz;

    protected abstract com.baidu.tbadk.mvc.g.a.d a(NavigationBar navigationBar);

    public c(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.g.b.a, com.baidu.tbadk.mvc.core.c
    public void ov() {
        this.anu = (NavigationBar) getView().findViewById(v.view_navigation_bar);
        this.anz = a(this.anu);
        if (BH()) {
            ViewGroup viewGroup = (ViewGroup) getView();
            this.anA = new NoNetworkView(getActivity());
            this.anA.a(new d(this));
            int indexOfChild = viewGroup.indexOfChild(this.anu);
            this.anA.setVisibility(8);
            viewGroup.addView(this.anA, indexOfChild + 1);
        }
        super.ov();
    }

    @Override // com.baidu.tbadk.mvc.g.b.a, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.anz.a(tbPageContext, i);
        if (this.anA != null) {
            this.anA.onChangeSkinType(tbPageContext, i);
        }
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.g.b.a, com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return w.mvc_template_navi_list;
    }

    protected boolean BH() {
        return true;
    }

    public void an(boolean z) {
    }
}
