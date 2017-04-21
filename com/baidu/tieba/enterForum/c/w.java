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
    private ViewEventCenter bHa;
    private View bIP;
    private TextView bIQ;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bIQ = (TextView) view.findViewById(w.h.textview);
        this.bIP = view.findViewById(w.h.container);
        this.bHa = viewEventCenter;
        this.bIP.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        aq.j(this.bIP, w.g.addresslist_item_bg);
        this.bIQ.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bIQ.setTextColor(aq.getColor(w.e.cp_cont_d));
        return true;
    }
}
