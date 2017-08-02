package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.g;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.f.a<g, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bWE;
    private View bZi;
    private TextView bZj;
    private ImageView bZk;
    private View bZl;
    private RelativeLayout.LayoutParams bZm;
    private int padding;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.padding = 0;
        this.bZi = view.findViewById(d.h.container_edit_forum);
        this.bWE = viewEventCenter;
        this.bZj = (TextView) view.findViewById(d.h.forum_name_view);
        this.bZk = (ImageView) view.findViewById(d.h.delete_forum_view);
        this.bZl = view.findViewById(d.h.divider_left_name);
        this.bZk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.bWE != null) {
                    e.this.bWE.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
                }
            }
        });
        this.padding = k.g(tbPageContext.getPageActivity(), d.f.ds16);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(g gVar) {
        super.E(gVar);
        if (gVar != null) {
            if (gVar.getType() == 1) {
                ai.c(this.bZj, d.e.cp_cont_d, 1);
                this.bZj.setText(d.l.default_personalized_name);
                ai.j(this.bZi, d.e.cp_bg_line_d);
                this.bZk.setVisibility(8);
            } else {
                ai.c(this.bZj, d.e.cp_cont_b, 1);
                this.bZj.setText(gVar.getName());
                this.bZk.setVisibility(0);
                ai.j(this.bZi, d.g.forum_item_bg);
            }
            this.bZm = (RelativeLayout.LayoutParams) this.bZk.getLayoutParams();
            if (this.position % 2 == 0) {
                this.bZl.setVisibility(8);
                this.bZm.leftMargin = 0;
            } else {
                this.bZl.setVisibility(0);
                this.bZm.leftMargin = this.padding;
                this.bZm.rightMargin = this.padding;
            }
            if (this.bZk.getVisibility() == 0) {
                this.bZk.setLayoutParams(this.bZm);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        ai.j(this.bZi, d.g.forum_item_bg);
        return true;
    }
}
