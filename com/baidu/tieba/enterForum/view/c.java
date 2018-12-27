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
/* loaded from: classes4.dex */
public class c extends com.baidu.tbadk.mvc.f.a<f, com.baidu.tbadk.mvc.d.b> {
    private TextView aKj;
    private ViewEventCenter dqs;
    private int ds44;
    private View dtk;
    private TextView dtl;
    private ImageView dtm;
    private RelativeLayout.LayoutParams dtn;
    private View mDividerView;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ds44 = 0;
        this.dtk = view.findViewById(e.g.container_edit_forum);
        this.dqs = viewEventCenter;
        this.aKj = (TextView) view.findViewById(e.g.forum_name_view);
        this.dtm = (ImageView) view.findViewById(e.g.delete_forum_view);
        this.mDividerView = view.findViewById(e.g.divider_left_name);
        this.dtm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dqs != null) {
                    c.this.dqs.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, c.this.getData(), null, null));
                }
            }
        });
        this.dtl = (TextView) view.findViewById(e.g.brand_label);
        this.ds44 = l.h(tbPageContext.getPageActivity(), e.C0210e.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void L(f fVar) {
        super.L(fVar);
        if (fVar != null) {
            if (fVar.getType() == 1) {
                al.c(this.aKj, e.d.cp_cont_d, 1);
                this.aKj.setText(e.j.default_personalized_name);
                al.i(this.dtk, e.d.cp_bg_line_d);
                this.dtm.setVisibility(8);
            } else {
                al.c(this.aKj, e.d.cp_cont_b, 1);
                this.aKj.setText(fVar.getName());
                this.dtm.setVisibility(0);
                al.i(this.dtk, e.f.forum_item_bg);
            }
            this.dtn = (RelativeLayout.LayoutParams) this.dtm.getLayoutParams();
            if (this.position % 2 == 0) {
                this.mDividerView.setVisibility(8);
                this.dtn.leftMargin = 0;
            } else {
                this.mDividerView.setVisibility(0);
                this.dtn.leftMargin = this.ds44;
            }
            if (this.dtm.getVisibility() == 0) {
                this.dtm.setLayoutParams(this.dtn);
            }
            if (fVar.avJ() == 1) {
                this.dtl.setVisibility(0);
            } else {
                this.dtl.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        al.i(this.dtk, e.f.forum_item_bg);
        al.i(this.dtl, e.f.enter_forum_brand_label_bg_shape);
        al.h(this.dtl, e.d.cp_cont_i);
        return true;
    }
}
