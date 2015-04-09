package com.baidu.tbadk.mvc.g.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.adp.lib.g.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends d {
    private MorePopupWindow ans;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.anu.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.nb_item_floor_more, new c(this));
    }

    public void a(View view, Drawable drawable, q qVar) {
        this.ans = new MorePopupWindow(getActivity(), view, this.anu, drawable, qVar);
    }

    @Override // com.baidu.tbadk.mvc.g.a.d, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, this.ans.getContentView());
        return super.a(tbPageContext, i);
    }

    public void Br() {
        k.a(this.ans, getActivity());
    }
}
