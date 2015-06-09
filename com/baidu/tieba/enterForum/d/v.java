package com.baidu.tieba.enterForum.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.ae, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aEU;
    private TextView aGB;
    private View aGh;

    public v(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aGB = (TextView) view.findViewById(com.baidu.tieba.q.textview);
        this.aGh = view.findViewById(com.baidu.tieba.q.container);
        this.aEU = viewEventCenter;
        this.aGh.setOnClickListener(new w(this));
        this.aGh.setOnLongClickListener(new x(this));
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ay.i(this.aGh, com.baidu.tieba.p.addresslist_item_bg);
        this.aGB.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_jinba_list_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aGB.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_d));
        return true;
    }
}
