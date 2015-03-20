package com.baidu.tbadk.mvc.g.b;

import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class f extends com.baidu.tbadk.mvc.i.a.a {
    private FragmentTabWidget anu;
    private ViewPager anv;

    public f(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.i.a.a
    public ViewGroup.LayoutParams dN(int i) {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        BC().onChangeSkinType(i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.a.a
    protected ViewPager getViewPager() {
        if (this.anv != null) {
            return this.anv;
        }
        if (getView() != null) {
            this.anv = (ViewPager) getView().findViewById(v.fragment_pager);
            return this.anv;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.i.a.a
    protected FragmentTabWidget BC() {
        if (this.anu != null) {
            return this.anu;
        }
        if (getView() != null) {
            this.anu = (FragmentTabWidget) getView().findViewById(v.tab_widget);
            return this.anu;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int ou() {
        return w.mvc_template_tbpager_pager;
    }
}
