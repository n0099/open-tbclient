package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.ae, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aCK;
    private View aDV;
    private TextView aEp;

    public v(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aEp = (TextView) view.findViewById(com.baidu.tieba.v.textview);
        this.aDV = view.findViewById(com.baidu.tieba.v.container);
        this.aCK = viewEventCenter;
        this.aDV.setOnClickListener(new w(this));
        this.aDV.setOnLongClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ba.i(this.aDV, com.baidu.tieba.u.addresslist_item_bg);
        this.aEp.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aEp.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_d));
        return true;
    }
}
