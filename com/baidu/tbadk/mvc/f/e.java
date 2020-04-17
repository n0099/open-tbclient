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
    private final ViewEventCenter ecJ;
    private S ece;
    private TbPageContext<?> pageContext;
    private final View rootView;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        this.pageContext = tbPageContext;
        this.rootView = view;
        this.ecJ = viewEventCenter;
    }

    public View getRootView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewEventCenter aZe() {
        return this.ecJ;
    }

    public void a(D d, S s) {
        ai(d);
        b(s);
    }

    public D getData() {
        return this.data;
    }

    public S aYL() {
        return this.ece;
    }

    public void ai(D d) {
        this.data = d;
    }

    public void b(S s) {
        this.ece = s;
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
