package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.b.g, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bLQ;
    private View bNZ;
    private TextView bOa;
    private ImageView bOb;
    private View bOc;
    private RelativeLayout.LayoutParams bOd;
    private int padding;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.padding = 0;
        this.bNZ = view.findViewById(w.h.container_edit_forum);
        this.bLQ = viewEventCenter;
        this.bOa = (TextView) view.findViewById(w.h.forum_name_view);
        this.bOb = (ImageView) view.findViewById(w.h.delete_forum_view);
        this.bOc = view.findViewById(w.h.divider_left_name);
        this.bOb.setOnClickListener(new p(this));
        this.padding = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds16);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.enterForum.b.g gVar) {
        super.E(gVar);
        if (gVar != null) {
            if (gVar.getType() == 1) {
                aq.c(this.bOa, w.e.cp_cont_d, 1);
                this.bOa.setText(w.l.default_personalized_name);
                aq.j(this.bNZ, w.e.cp_bg_line_d);
                this.bOb.setVisibility(8);
            } else {
                aq.c(this.bOa, w.e.cp_cont_b, 1);
                this.bOa.setText(gVar.getName());
                this.bOb.setVisibility(0);
                aq.j(this.bNZ, w.g.forum_item_bg);
            }
            this.bOd = (RelativeLayout.LayoutParams) this.bOb.getLayoutParams();
            if (this.position % 2 == 0) {
                this.bOc.setVisibility(8);
                this.bOd.leftMargin = 0;
            } else {
                this.bOc.setVisibility(0);
                this.bOd.leftMargin = this.padding;
                this.bOd.rightMargin = this.padding;
            }
            if (this.bOb.getVisibility() == 0) {
                this.bOb.setLayoutParams(this.bOd);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        aq.j(this.bNZ, w.g.forum_item_bg);
        return true;
    }
}
