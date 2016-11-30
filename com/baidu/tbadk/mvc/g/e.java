package com.baidu.tbadk.mvc.g;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes.dex */
public abstract class e<D, S extends com.baidu.tbadk.mvc.d.b> implements s {
    private S aAk;
    private final ViewEventCenter aBg;
    private final View aBq;
    private D data;
    private TbPageContext<?> pageContext;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        this.pageContext = tbPageContext;
        this.aBq = view;
        this.aBg = viewEventCenter;
    }

    public View getRootView() {
        return this.aBq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewEventCenter lI() {
        return this.aBg;
    }

    public void a(D d, S s) {
        E(d);
        c(s);
    }

    public D getData() {
        return this.data;
    }

    public S FD() {
        return this.aAk;
    }

    public void E(D d) {
        this.data = d;
    }

    public void c(S s) {
        this.aAk = s;
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
