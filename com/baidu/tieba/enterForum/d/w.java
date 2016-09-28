package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aPL;
    private View bIR;
    private TextView bIS;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bIS = (TextView) view.findViewById(r.g.textview);
        this.bIR = view.findViewById(r.g.container);
        this.aPL = viewEventCenter;
        this.bIR.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        av.k(this.bIR, r.f.addresslist_item_bg);
        this.bIS.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bIS.setTextColor(av.getColor(r.d.cp_cont_d));
        return true;
    }
}
