package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.g;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.f.a<g, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter cbt;
    private View cdS;
    private TextView cdT;
    private ImageView cdU;
    private View cdV;
    private RelativeLayout.LayoutParams cdW;
    private int padding;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.padding = 0;
        this.cdS = view.findViewById(d.h.container_edit_forum);
        this.cbt = viewEventCenter;
        this.cdT = (TextView) view.findViewById(d.h.forum_name_view);
        this.cdU = (ImageView) view.findViewById(d.h.delete_forum_view);
        this.cdV = view.findViewById(d.h.divider_left_name);
        this.cdU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.cbt != null) {
                    e.this.cbt.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
                }
            }
        });
        this.padding = k.g(tbPageContext.getPageActivity(), d.f.ds16);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void D(g gVar) {
        super.D(gVar);
        if (gVar != null) {
            if (gVar.getType() == 1) {
                aj.c(this.cdT, d.e.cp_cont_d, 1);
                this.cdT.setText(d.l.default_personalized_name);
                aj.j(this.cdS, d.e.cp_bg_line_d);
                this.cdU.setVisibility(8);
            } else {
                aj.c(this.cdT, d.e.cp_cont_b, 1);
                this.cdT.setText(gVar.getName());
                this.cdU.setVisibility(0);
                aj.j(this.cdS, d.g.forum_item_bg);
            }
            this.cdW = (RelativeLayout.LayoutParams) this.cdU.getLayoutParams();
            if (this.position % 2 == 0) {
                this.cdV.setVisibility(8);
                this.cdW.leftMargin = 0;
            } else {
                this.cdV.setVisibility(0);
                this.cdW.leftMargin = this.padding;
                this.cdW.rightMargin = this.padding;
            }
            if (this.cdU.getVisibility() == 0) {
                this.cdU.setLayoutParams(this.cdW);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        aj.j(this.cdS, d.g.forum_item_bg);
        return true;
    }
}
