package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.u, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aMt;
    private View aNH;
    private TextView aOb;

    public v(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aOb = (TextView) view.findViewById(i.f.textview);
        this.aNH = view.findViewById(i.f.container);
        this.aMt = viewEventCenter;
        this.aNH.setOnClickListener(new w(this));
        this.aNH.setOnLongClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        al.i(this.aNH, i.e.addresslist_item_bg);
        this.aOb.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aOb.setTextColor(al.getColor(i.c.cp_cont_d));
        return true;
    }
}
