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
    private final ViewEventCenter aAA;
    private final View aAK;
    private S azH;
    private D data;
    private TbPageContext<?> pageContext;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        this.pageContext = tbPageContext;
        this.aAK = view;
        this.aAA = viewEventCenter;
    }

    public View getRootView() {
        return this.aAK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewEventCenter lI() {
        return this.aAA;
    }

    public void a(D d, S s) {
        E(d);
        c(s);
    }

    public D getData() {
        return this.data;
    }

    public S Fd() {
        return this.azH;
    }

    public void E(D d) {
        this.data = d;
    }

    public void c(S s) {
        this.azH = s;
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
