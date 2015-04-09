package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.ae, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aCS;
    private View aEd;
    private TextView aEx;

    public v(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aEx = (TextView) view.findViewById(com.baidu.tieba.v.textview);
        this.aEd = view.findViewById(com.baidu.tieba.v.container);
        this.aCS = viewEventCenter;
        this.aEd.setOnClickListener(new w(this));
        this.aEd.setOnLongClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ba.i(this.aEd, com.baidu.tieba.u.addresslist_item_bg);
        this.aEx.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aEx.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_d));
        return true;
    }
}
