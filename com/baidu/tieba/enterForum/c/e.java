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
    private ViewEventCenter cbZ;
    private TextView ceA;
    private ImageView ceB;
    private View ceC;
    private RelativeLayout.LayoutParams ceD;
    private View cez;
    private int padding;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.padding = 0;
        this.cez = view.findViewById(d.h.container_edit_forum);
        this.cbZ = viewEventCenter;
        this.ceA = (TextView) view.findViewById(d.h.forum_name_view);
        this.ceB = (ImageView) view.findViewById(d.h.delete_forum_view);
        this.ceC = view.findViewById(d.h.divider_left_name);
        this.ceB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.cbZ != null) {
                    e.this.cbZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
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
                aj.c(this.ceA, d.e.cp_cont_d, 1);
                this.ceA.setText(d.l.default_personalized_name);
                aj.j(this.cez, d.e.cp_bg_line_d);
                this.ceB.setVisibility(8);
            } else {
                aj.c(this.ceA, d.e.cp_cont_b, 1);
                this.ceA.setText(gVar.getName());
                this.ceB.setVisibility(0);
                aj.j(this.cez, d.g.forum_item_bg);
            }
            this.ceD = (RelativeLayout.LayoutParams) this.ceB.getLayoutParams();
            if (this.position % 2 == 0) {
                this.ceC.setVisibility(8);
                this.ceD.leftMargin = 0;
            } else {
                this.ceC.setVisibility(0);
                this.ceD.leftMargin = this.padding;
                this.ceD.rightMargin = this.padding;
            }
            if (this.ceB.getVisibility() == 0) {
                this.ceB.setLayoutParams(this.ceD);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        aj.j(this.cez, d.g.forum_item_bg);
        return true;
    }
}
