package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aWA;
    private View aYZ;
    private TextView aZa;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aZa = (TextView) view.findViewById(t.g.textview);
        this.aYZ = view.findViewById(t.g.container);
        this.aWA = viewEventCenter;
        this.aYZ.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        ar.k(this.aYZ, t.f.addresslist_item_bg);
        this.aZa.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aZa.setTextColor(ar.getColor(t.d.cp_cont_d));
        return true;
    }
}
