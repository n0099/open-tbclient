package com.baidu.tbadk.mvc.g.b;

import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public abstract class c extends a {
    protected NavigationBar aeS;
    protected com.baidu.tbadk.mvc.g.a.d aeX;
    private NoNetworkView aeY;

    protected abstract com.baidu.tbadk.mvc.g.a.d a(NavigationBar navigationBar);

    public c(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.g.b.a, com.baidu.tbadk.mvc.core.c
    public void kC() {
        this.aeS = (NavigationBar) getView().findViewById(w.view_navigation_bar);
        this.aeX = a(this.aeS);
        if (yn()) {
            ViewGroup viewGroup = (ViewGroup) getView();
            this.aeY = new NoNetworkView(getActivity());
            this.aeY.a(new d(this));
            int indexOfChild = viewGroup.indexOfChild(this.aeS);
            this.aeY.setVisibility(8);
            viewGroup.addView(this.aeY, indexOfChild + 1);
        }
        super.kC();
    }

    @Override // com.baidu.tbadk.mvc.g.b.a, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aeX.a(tbPageContext, i);
        if (this.aeY != null) {
            this.aeY.onChangeSkinType(tbPageContext, i);
        }
        super.a(tbPageContext, i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.g.b.a, com.baidu.tbadk.mvc.core.c
    protected int kB() {
        return x.mvc_template_navi_list;
    }

    protected boolean yn() {
        return true;
    }

    public void at(boolean z) {
    }
}
