package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aMG;
    private View aNU;
    private TextView aOo;

    public v(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aOo = (TextView) view.findViewById(i.f.textview);
        this.aNU = view.findViewById(i.f.container);
        this.aMG = viewEventCenter;
        this.aNU.setOnClickListener(new w(this));
        this.aNU.setOnLongClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        al.h(this.aNU, i.e.addresslist_item_bg);
        this.aOo.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aOo.setTextColor(al.getColor(i.c.cp_cont_d));
        return true;
    }
}
