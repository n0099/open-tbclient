package com.baidu.tieba.enterForum.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aOw;
    private View bIQ;
    private TextView bIR;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bIR = (TextView) view.findViewById(t.g.textview);
        this.bIQ = view.findViewById(t.g.container);
        this.aOw = viewEventCenter;
        this.bIQ.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        av.k(this.bIQ, t.f.addresslist_item_bg);
        this.bIR.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bIR.setTextColor(av.getColor(t.d.cp_cont_d));
        return true;
    }
}
