package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aRj;
    private View brO;
    private TextView brP;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.brP = (TextView) view.findViewById(r.g.textview);
        this.brO = view.findViewById(r.g.container);
        this.aRj = viewEventCenter;
        this.brO.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        ar.k(this.brO, r.f.addresslist_item_bg);
        this.brP.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.brP.setTextColor(ar.getColor(r.d.cp_cont_d));
        return true;
    }
}
