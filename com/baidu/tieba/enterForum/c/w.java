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
    private ViewEventCenter bEQ;
    private View bGF;
    private TextView bGG;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bGG = (TextView) view.findViewById(w.h.textview);
        this.bGF = view.findViewById(w.h.container);
        this.bEQ = viewEventCenter;
        this.bGF.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        aq.j(this.bGF, w.g.addresslist_item_bg);
        this.bGG.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bGG.setTextColor(aq.getColor(w.e.cp_cont_d));
        return true;
    }
}
