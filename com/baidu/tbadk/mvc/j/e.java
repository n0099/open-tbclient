package com.baidu.tbadk.mvc.j;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tieba.tbadkCore.ab;
/* loaded from: classes.dex */
public abstract class e<D, S extends com.baidu.tbadk.mvc.e.c> implements ab {
    private S anD;
    private final ViewEventCenter aoV;
    private D data;
    private TbPageContext<?> pageContext;
    private final View rootView;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        this.pageContext = tbPageContext;
        this.rootView = view;
        this.aoV = viewEventCenter;
    }

    public View getRootView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewEventCenter AL() {
        return this.aoV;
    }

    public void a(D d, S s) {
        z(d);
        e(s);
    }

    public D getData() {
        return this.data;
    }

    public S Bt() {
        return this.anD;
    }

    public void z(D d) {
        this.data = d;
    }

    public void e(S s) {
        this.anD = s;
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
