package com.baidu.tieba.enterForum.c;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.tbadkCore.u, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bEJ;
    private View bGy;
    private TextView bGz;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bGz = (TextView) view.findViewById(w.h.textview);
        this.bGy = view.findViewById(w.h.container);
        this.bEJ = viewEventCenter;
        this.bGy.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        aq.j(this.bGy, w.g.addresslist_item_bg);
        this.bGz.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bGz.setTextColor(aq.getColor(w.e.cp_cont_d));
        return true;
    }
}
