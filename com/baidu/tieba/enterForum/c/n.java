package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.b.g, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bSq;
    private View bUU;
    private TextView bUV;
    private ImageView bUW;
    private View bUX;
    private RelativeLayout.LayoutParams bUY;
    private int padding;

    public n(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.padding = 0;
        this.bUU = view.findViewById(w.h.container_edit_forum);
        this.bSq = viewEventCenter;
        this.bUV = (TextView) view.findViewById(w.h.forum_name_view);
        this.bUW = (ImageView) view.findViewById(w.h.delete_forum_view);
        this.bUX = view.findViewById(w.h.divider_left_name);
        this.bUW.setOnClickListener(new o(this));
        this.padding = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds16);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.enterForum.b.g gVar) {
        super.E(gVar);
        if (gVar != null) {
            if (gVar.getType() == 1) {
                as.c(this.bUV, w.e.cp_cont_d, 1);
                this.bUV.setText(w.l.default_personalized_name);
                as.j(this.bUU, w.e.cp_bg_line_d);
                this.bUW.setVisibility(8);
            } else {
                as.c(this.bUV, w.e.cp_cont_b, 1);
                this.bUV.setText(gVar.getName());
                this.bUW.setVisibility(0);
                as.j(this.bUU, w.g.forum_item_bg);
            }
            this.bUY = (RelativeLayout.LayoutParams) this.bUW.getLayoutParams();
            if (this.position % 2 == 0) {
                this.bUX.setVisibility(8);
                this.bUY.leftMargin = 0;
            } else {
                this.bUX.setVisibility(0);
                this.bUY.leftMargin = this.padding;
                this.bUY.rightMargin = this.padding;
            }
            if (this.bUW.getVisibility() == 0) {
                this.bUW.setLayoutParams(this.bUY);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        as.j(this.bUU, w.g.forum_item_bg);
        return true;
    }
}
