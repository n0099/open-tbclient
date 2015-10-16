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
    private ViewEventCenter aLM;
    private View aNa;
    private TextView aNv;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aNv = (TextView) view.findViewById(i.f.textview);
        this.aNa = view.findViewById(i.f.container);
        this.aLM = viewEventCenter;
        this.aNa.setOnClickListener(new x(this));
        this.aNa.setOnLongClickListener(new y(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        an.i(this.aNa, i.e.addresslist_item_bg);
        this.aNv.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aNv.setTextColor(an.getColor(i.c.cp_cont_d));
        return true;
    }
}
