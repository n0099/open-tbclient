package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aQB;
    private View aSJ;
    private TextView aSK;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aSK = (TextView) view.findViewById(n.f.textview);
        this.aSJ = view.findViewById(n.f.container);
        this.aQB = viewEventCenter;
        this.aSJ.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        as.i(this.aSJ, n.e.addresslist_item_bg);
        this.aSK.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aSK.setTextColor(as.getColor(n.c.cp_cont_d));
        return true;
    }
}
