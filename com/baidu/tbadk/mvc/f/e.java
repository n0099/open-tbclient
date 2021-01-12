package com.baidu.tbadk.mvc.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tieba.tbadkCore.t;
/* loaded from: classes.dex */
public abstract class e<D, S extends com.baidu.tbadk.mvc.d.b> implements t {
    private D data;
    private S fFB;
    private final ViewEventCenter fGf;
    private TbPageContext<?> pageContext;
    private final View rootView;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        this.pageContext = tbPageContext;
        this.rootView = view;
        this.fGf = viewEventCenter;
    }

    public View getRootView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewEventCenter bDq() {
        return this.fGf;
    }

    public void a(D d, S s) {
        aw(d);
        b(s);
    }

    public D getData() {
        return this.data;
    }

    public S bCX() {
        return this.fFB;
    }

    public void aw(D d) {
        this.data = d;
    }

    public void b(S s) {
        this.fFB = s;
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
