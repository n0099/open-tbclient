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
    private ViewEventCenter aUs;
    private View aWL;
    private TextView aWM;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aWM = (TextView) view.findViewById(n.g.textview);
        this.aWL = view.findViewById(n.g.container);
        this.aUs = viewEventCenter;
        this.aWL.setOnClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        as.i(this.aWL, n.f.addresslist_item_bg);
        this.aWM.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aWM.setTextColor(as.getColor(n.d.cp_cont_d));
        return true;
    }
}
