package com.baidu.tbadk.mvc.g.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.adp.lib.g.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends d {
    private MorePopupWindow aov;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aox.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.nb_item_floor_more, new c(this));
    }

    public void a(View view, Drawable drawable, s sVar) {
        this.aov = new MorePopupWindow(getActivity(), view, this.aox, drawable, sVar);
    }

    @Override // com.baidu.tbadk.mvc.g.a.d, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, this.aov.getContentView());
        return super.a(tbPageContext, i);
    }

    public void Ce() {
        k.a(this.aov, getActivity());
    }
}
