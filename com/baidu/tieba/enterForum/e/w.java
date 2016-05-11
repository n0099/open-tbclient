package com.baidu.tieba.enterForum.e;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aXs;
    private View aZr;
    private TextView aZs;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aZs = (TextView) view.findViewById(t.g.textview);
        this.aZr = view.findViewById(t.g.container);
        this.aXs = viewEventCenter;
        this.aZr.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        at.k(this.aZr, t.f.addresslist_item_bg);
        this.aZs.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aZs.setTextColor(at.getColor(t.d.cp_cont_d));
        return true;
    }
}
