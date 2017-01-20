package com.baidu.tieba.enterForum.c;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.tbadkCore.u, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bxK;
    private TextView bzA;
    private View bzz;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bzA = (TextView) view.findViewById(r.h.textview);
        this.bzz = view.findViewById(r.h.container);
        this.bxK = viewEventCenter;
        this.bzz.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        ap.j(this.bzz, r.g.addresslist_item_bg);
        this.bzA.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bzA.setTextColor(ap.getColor(r.e.cp_cont_d));
        return true;
    }
}
