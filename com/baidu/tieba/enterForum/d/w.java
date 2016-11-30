package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aRS;
    private View bLK;
    private TextView bLL;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bLL = (TextView) view.findViewById(r.g.textview);
        this.bLK = view.findViewById(r.g.container);
        this.aRS = viewEventCenter;
        this.bLK.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        at.k(this.bLK, r.f.addresslist_item_bg);
        this.bLL.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bLL.setTextColor(at.getColor(r.d.cp_cont_d));
        return true;
    }
}
