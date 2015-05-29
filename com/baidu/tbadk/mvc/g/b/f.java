package com.baidu.tbadk.mvc.g.b;

import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class f extends com.baidu.tbadk.mvc.i.a.a {
    private FragmentTabWidget aoF;
    private ViewPager aoG;

    public f(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.i.a.a
    public ViewGroup.LayoutParams dX(int i) {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        Cu().onChangeSkinType(i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.a.a
    protected ViewPager getViewPager() {
        if (this.aoG != null) {
            return this.aoG;
        }
        if (getView() != null) {
            this.aoG = (ViewPager) getView().findViewById(q.fragment_pager);
            return this.aoG;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.i.a.a
    protected FragmentTabWidget Cu() {
        if (this.aoF != null) {
            return this.aoF;
        }
        if (getView() != null) {
            this.aoF = (FragmentTabWidget) getView().findViewById(q.tab_widget);
            return this.aoF;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int oK() {
        return r.mvc_template_tbpager_pager;
    }
}
