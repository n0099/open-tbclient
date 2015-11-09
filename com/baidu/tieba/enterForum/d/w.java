package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aLU;
    private TextView aND;
    private View aNi;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aND = (TextView) view.findViewById(i.f.textview);
        this.aNi = view.findViewById(i.f.container);
        this.aLU = viewEventCenter;
        this.aNi.setOnClickListener(new x(this));
        this.aNi.setOnLongClickListener(new y(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        an.i(this.aNi, i.e.addresslist_item_bg);
        this.aND.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aND.setTextColor(an.getColor(i.c.cp_cont_d));
        return true;
    }
}
