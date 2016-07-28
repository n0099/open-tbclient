package com.baidu.tieba.enterForum.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.x, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bgJ;
    private View bxB;
    private TextView bxC;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bxC = (TextView) view.findViewById(u.g.textview);
        this.bxB = view.findViewById(u.g.container);
        this.bgJ = viewEventCenter;
        this.bxB.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        av.k(this.bxB, u.f.addresslist_item_bg);
        this.bxC.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bxC.setTextColor(av.getColor(u.d.cp_cont_d));
        return true;
    }
}
