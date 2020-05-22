package com.baidu.tbadk.mvc.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes.dex */
public abstract class e<D, S extends com.baidu.tbadk.mvc.d.b> implements r {
    private D data;
    private S eqv;
    private final ViewEventCenter era;
    private TbPageContext<?> pageContext;
    private final View rootView;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        this.pageContext = tbPageContext;
        this.rootView = view;
        this.era = viewEventCenter;
    }

    public View getRootView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewEventCenter bfm() {
        return this.era;
    }

    public void a(D d, S s) {
        an(d);
        b(s);
    }

    public D getData() {
        return this.data;
    }

    public S beT() {
        return this.eqv;
    }

    public void an(D d) {
        this.data = d;
    }

    public void b(S s) {
        this.eqv = s;
    }

    public TbPageContext<?> getPageContext() {
        return this.pageContext;
    }

    public Context getContext() {
        return this.pageContext.getContext();
    }

    public Resources getResources() {
        return this.pageContext.getResources();
    }

    public Activity getActivity() {
        return this.pageContext.getPageActivity();
    }

    public BdUniqueId getUniqueId() {
        return this.pageContext.getUniqueId();
    }

    public String getString(int i) {
        return getResources().getString(i);
    }
}
