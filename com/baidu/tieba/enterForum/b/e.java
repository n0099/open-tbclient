package com.baidu.tieba.enterForum.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.f, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter cjP;
    private View cmm;
    private TextView cmn;
    private ImageView cmo;
    private View cmp;
    private RelativeLayout.LayoutParams cmq;
    private int padding;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.padding = 0;
        this.cmm = view.findViewById(d.g.container_edit_forum);
        this.cjP = viewEventCenter;
        this.cmn = (TextView) view.findViewById(d.g.forum_name_view);
        this.cmo = (ImageView) view.findViewById(d.g.delete_forum_view);
        this.cmp = view.findViewById(d.g.divider_left_name);
        this.cmo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.cjP != null) {
                    e.this.cjP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
                }
            }
        });
        this.padding = l.f(tbPageContext.getPageActivity(), d.e.ds16);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void D(com.baidu.tieba.enterForum.data.f fVar) {
        super.D(fVar);
        if (fVar != null) {
            if (fVar.getType() == 1) {
                aj.c(this.cmn, d.C0080d.cp_cont_d, 1);
                this.cmn.setText(d.j.default_personalized_name);
                aj.j(this.cmm, d.C0080d.cp_bg_line_d);
                this.cmo.setVisibility(8);
            } else {
                aj.c(this.cmn, d.C0080d.cp_cont_b, 1);
                this.cmn.setText(fVar.getName());
                this.cmo.setVisibility(0);
                aj.j(this.cmm, d.f.forum_item_bg);
            }
            this.cmq = (RelativeLayout.LayoutParams) this.cmo.getLayoutParams();
            if (this.position % 2 == 0) {
                this.cmp.setVisibility(8);
                this.cmq.leftMargin = 0;
            } else {
                this.cmp.setVisibility(0);
                this.cmq.leftMargin = this.padding;
                this.cmq.rightMargin = this.padding;
            }
            if (this.cmo.getVisibility() == 0) {
                this.cmo.setLayoutParams(this.cmq);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.m
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        aj.j(this.cmm, d.f.forum_item_bg);
        return true;
    }
}
