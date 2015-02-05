package com.baidu.tbadk.mvc.j;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
public abstract class d<D, S extends com.baidu.tbadk.mvc.e.c> implements y {
    private S adY;
    private final ViewEventCenter afo;
    private D data;
    private TbPageContext<?> pageContext;
    private final View rootView;

    public d(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        this.pageContext = tbPageContext;
        this.rootView = view;
        this.afo = viewEventCenter;
    }

    public View getRootView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewEventCenter wH() {
        return this.afo;
    }

    public void a(D d, S s) {
        y(d);
        e(s);
    }

    public D getData() {
        return this.data;
    }

    public S xo() {
        return this.adY;
    }

    public void y(D d) {
        this.data = d;
    }

    public void e(S s) {
        this.adY = s;
    }

    public Resources getResources() {
        return this.pageContext.getResources();
    }

    public Activity getActivity() {
        return this.pageContext.getPageActivity();
    }

    public String getString(int i) {
        return getResources().getString(i);
    }
}
