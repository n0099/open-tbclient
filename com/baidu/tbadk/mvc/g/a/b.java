package com.baidu.tbadk.mvc.g.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.adp.lib.g.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.v;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class b extends d {
    private MorePopupWindow aew;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aey.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.nb_item_floor_more, new c(this));
    }

    public void a(View view, Drawable drawable, v vVar) {
        this.aew = new MorePopupWindow(getActivity(), view, this.aey, drawable, vVar);
    }

    @Override // com.baidu.tbadk.mvc.g.a.d, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.g.a.a(tbPageContext, this.aew.getContentView());
        return super.a(tbPageContext, i);
    }

    public void xN() {
        k.a(this.aew, getActivity());
    }
}
