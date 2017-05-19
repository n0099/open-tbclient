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
    private ViewEventCenter bGb;
    private View bIl;
    private TextView bIm;
    private ImageView bIn;
    private View bIo;
    private RelativeLayout.LayoutParams bIp;
    private int padding;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.padding = 0;
        this.bIl = view.findViewById(w.h.container_edit_forum);
        this.bGb = viewEventCenter;
        this.bIm = (TextView) view.findViewById(w.h.forum_name_view);
        this.bIn = (ImageView) view.findViewById(w.h.delete_forum_view);
        this.bIo = view.findViewById(w.h.divider_left_name);
        this.bIn.setOnClickListener(new p(this));
        this.padding = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds16);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.enterForum.b.g gVar) {
        super.E(gVar);
        if (gVar != null) {
            if (gVar.getType() == 1) {
                aq.c(this.bIm, w.e.cp_cont_d, 1);
                this.bIm.setText(w.l.default_personalized_name);
                aq.j(this.bIl, w.e.cp_bg_line_d);
                this.bIn.setVisibility(8);
            } else {
                aq.c(this.bIm, w.e.cp_cont_b, 1);
                this.bIm.setText(gVar.getName());
                this.bIn.setVisibility(0);
                aq.j(this.bIl, w.g.forum_item_bg);
            }
            this.bIp = (RelativeLayout.LayoutParams) this.bIn.getLayoutParams();
            if (this.position % 2 == 0) {
                this.bIo.setVisibility(8);
                this.bIp.leftMargin = 0;
            } else {
                this.bIo.setVisibility(0);
                this.bIp.leftMargin = this.padding;
                this.bIp.rightMargin = this.padding;
            }
            if (this.bIn.getVisibility() == 0) {
                this.bIn.setLayoutParams(this.bIp);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        aq.j(this.bIl, w.g.forum_item_bg);
        return true;
    }
}
