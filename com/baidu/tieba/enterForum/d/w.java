package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bbj;
    private View bdJ;
    private TextView bdK;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bdK = (TextView) view.findViewById(t.g.textview);
        this.bdJ = view.findViewById(t.g.container);
        this.bbj = viewEventCenter;
        this.bdJ.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        at.k(this.bdJ, t.f.addresslist_item_bg);
        this.bdK.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bdK.setTextColor(at.getColor(t.d.cp_cont_d));
        return true;
    }
}
