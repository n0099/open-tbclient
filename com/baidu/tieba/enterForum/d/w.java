package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aLB;
    private View aMP;
    private TextView aNk;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aNk = (TextView) view.findViewById(i.f.textview);
        this.aMP = view.findViewById(i.f.container);
        this.aLB = viewEventCenter;
        this.aMP.setOnClickListener(new x(this));
        this.aMP.setOnLongClickListener(new y(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        am.i(this.aMP, i.e.addresslist_item_bg);
        this.aNk.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aNk.setTextColor(am.getColor(i.c.cp_cont_d));
        return true;
    }
}
