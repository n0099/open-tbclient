package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.data.f;
/* loaded from: classes2.dex */
public class c extends com.baidu.tbadk.mvc.f.a<f, com.baidu.tbadk.mvc.d.b> {
    private TextView aBk;
    private ViewEventCenter cXw;
    private View daB;
    private TextView daC;
    private ImageView daD;
    private View daE;
    private RelativeLayout.LayoutParams daF;
    private int ds44;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ds44 = 0;
        this.daB = view.findViewById(e.g.container_edit_forum);
        this.cXw = viewEventCenter;
        this.aBk = (TextView) view.findViewById(e.g.forum_name_view);
        this.daD = (ImageView) view.findViewById(e.g.delete_forum_view);
        this.daE = view.findViewById(e.g.divider_left_name);
        this.daD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.cXw != null) {
                    c.this.cXw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, c.this.getData(), null, null));
                }
            }
        });
        this.daC = (TextView) view.findViewById(e.g.brand_label);
        this.ds44 = l.h(tbPageContext.getPageActivity(), e.C0141e.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void H(f fVar) {
        super.H(fVar);
        if (fVar != null) {
            if (fVar.getType() == 1) {
                al.c(this.aBk, e.d.cp_cont_d, 1);
                this.aBk.setText(e.j.default_personalized_name);
                al.i(this.daB, e.d.cp_bg_line_d);
                this.daD.setVisibility(8);
            } else {
                al.c(this.aBk, e.d.cp_cont_b, 1);
                this.aBk.setText(fVar.getName());
                this.daD.setVisibility(0);
                al.i(this.daB, e.f.forum_item_bg);
            }
            this.daF = (RelativeLayout.LayoutParams) this.daD.getLayoutParams();
            if (this.position % 2 == 0) {
                this.daE.setVisibility(8);
                this.daF.leftMargin = 0;
            } else {
                this.daE.setVisibility(0);
                this.daF.leftMargin = this.ds44;
            }
            if (this.daD.getVisibility() == 0) {
                this.daD.setLayoutParams(this.daF);
            }
            if (fVar.aqm() == 1) {
                this.daC.setVisibility(0);
            } else {
                this.daC.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        al.i(this.daB, e.f.forum_item_bg);
        al.i(this.daC, e.f.enter_forum_brand_label_bg_shape);
        al.h(this.daC, e.d.cp_cont_i);
        return true;
    }
}
