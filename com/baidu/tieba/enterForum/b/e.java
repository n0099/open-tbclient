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
/* loaded from: classes2.dex */
public class e extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.f, com.baidu.tbadk.mvc.d.b> {
    private TextView bey;
    private ViewEventCenter doV;
    private View drq;
    private ImageView drr;
    private View drs;
    private RelativeLayout.LayoutParams drt;
    private int ds44;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ds44 = 0;
        this.drq = view.findViewById(d.g.container_edit_forum);
        this.doV = viewEventCenter;
        this.bey = (TextView) view.findViewById(d.g.forum_name_view);
        this.drr = (ImageView) view.findViewById(d.g.delete_forum_view);
        this.drs = view.findViewById(d.g.divider_left_name);
        this.drr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.doV != null) {
                    e.this.doV.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
                }
            }
        });
        this.ds44 = l.t(tbPageContext.getPageActivity(), d.e.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void aI(com.baidu.tieba.enterForum.data.f fVar) {
        super.aI(fVar);
        if (fVar != null) {
            if (fVar.getType() == 1) {
                aj.e(this.bey, d.C0140d.cp_cont_d, 1);
                this.bey.setText(d.j.default_personalized_name);
                aj.s(this.drq, d.C0140d.cp_bg_line_d);
                this.drr.setVisibility(8);
            } else {
                aj.e(this.bey, d.C0140d.cp_cont_b, 1);
                this.bey.setText(fVar.getName());
                this.drr.setVisibility(0);
                aj.s(this.drq, d.f.forum_item_bg);
            }
            this.drt = (RelativeLayout.LayoutParams) this.drr.getLayoutParams();
            if (this.position % 2 == 0) {
                this.drs.setVisibility(8);
                this.drt.leftMargin = 0;
            } else {
                this.drs.setVisibility(0);
                this.drt.leftMargin = this.ds44;
            }
            if (this.drr.getVisibility() == 0) {
                this.drr.setLayoutParams(this.drt);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        aj.s(this.drq, d.f.forum_item_bg);
        return true;
    }
}
