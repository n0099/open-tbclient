package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.g;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.f.a<g, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter ccl;
    private View ceL;
    private TextView ceM;
    private ImageView ceN;
    private View ceO;
    private RelativeLayout.LayoutParams ceP;
    private int padding;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.padding = 0;
        this.ceL = view.findViewById(d.h.container_edit_forum);
        this.ccl = viewEventCenter;
        this.ceM = (TextView) view.findViewById(d.h.forum_name_view);
        this.ceN = (ImageView) view.findViewById(d.h.delete_forum_view);
        this.ceO = view.findViewById(d.h.divider_left_name);
        this.ceN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.ccl != null) {
                    e.this.ccl.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
                }
            }
        });
        this.padding = l.f(tbPageContext.getPageActivity(), d.f.ds16);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void D(g gVar) {
        super.D(gVar);
        if (gVar != null) {
            if (gVar.getType() == 1) {
                aj.c(this.ceM, d.e.cp_cont_d, 1);
                this.ceM.setText(d.l.default_personalized_name);
                aj.j(this.ceL, d.e.cp_bg_line_d);
                this.ceN.setVisibility(8);
            } else {
                aj.c(this.ceM, d.e.cp_cont_b, 1);
                this.ceM.setText(gVar.getName());
                this.ceN.setVisibility(0);
                aj.j(this.ceL, d.g.forum_item_bg);
            }
            this.ceP = (RelativeLayout.LayoutParams) this.ceN.getLayoutParams();
            if (this.position % 2 == 0) {
                this.ceO.setVisibility(8);
                this.ceP.leftMargin = 0;
            } else {
                this.ceO.setVisibility(0);
                this.ceP.leftMargin = this.padding;
                this.ceP.rightMargin = this.padding;
            }
            if (this.ceN.getVisibility() == 0) {
                this.ceN.setLayoutParams(this.ceP);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        aj.j(this.ceL, d.g.forum_item_bg);
        return true;
    }
}
