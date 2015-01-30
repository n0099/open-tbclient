package com.baidu.tbadk.mvc.g.b;

import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public abstract class f extends com.baidu.tbadk.mvc.i.a.a {
    private FragmentTabWidget afd;
    private ViewPager afe;

    public f(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.i.a.a
    public ViewGroup.LayoutParams dK(int i) {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        yu().onChangeSkinType(i);
        return super.a(tbPageContext, i);
    }

    @Override // com.baidu.tbadk.mvc.i.a.a
    protected ViewPager getViewPager() {
        if (this.afe != null) {
            return this.afe;
        }
        if (getView() != null) {
            this.afe = (ViewPager) getView().findViewById(w.fragment_pager);
            return this.afe;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.i.a.a
    protected FragmentTabWidget yu() {
        if (this.afd != null) {
            return this.afd;
        }
        if (getView() != null) {
            this.afd = (FragmentTabWidget) getView().findViewById(w.tab_widget);
            return this.afd;
        }
        return null;
    }

    @Override // com.baidu.tbadk.mvc.core.c
    protected int kI() {
        return x.mvc_template_tbpager_pager;
    }
}
