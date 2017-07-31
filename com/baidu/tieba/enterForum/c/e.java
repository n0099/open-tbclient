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
    private ViewEventCenter bXK;
    private View cao;
    private TextView cap;
    private ImageView caq;
    private View car;
    private RelativeLayout.LayoutParams cas;
    private int padding;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.padding = 0;
        this.cao = view.findViewById(d.h.container_edit_forum);
        this.bXK = viewEventCenter;
        this.cap = (TextView) view.findViewById(d.h.forum_name_view);
        this.caq = (ImageView) view.findViewById(d.h.delete_forum_view);
        this.car = view.findViewById(d.h.divider_left_name);
        this.caq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.bXK != null) {
                    e.this.bXK.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
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
                ai.c(this.cap, d.e.cp_cont_d, 1);
                this.cap.setText(d.l.default_personalized_name);
                ai.j(this.cao, d.e.cp_bg_line_d);
                this.caq.setVisibility(8);
            } else {
                ai.c(this.cap, d.e.cp_cont_b, 1);
                this.cap.setText(gVar.getName());
                this.caq.setVisibility(0);
                ai.j(this.cao, d.g.forum_item_bg);
            }
            this.cas = (RelativeLayout.LayoutParams) this.caq.getLayoutParams();
            if (this.position % 2 == 0) {
                this.car.setVisibility(8);
                this.cas.leftMargin = 0;
            } else {
                this.car.setVisibility(0);
                this.cas.leftMargin = this.padding;
                this.cas.rightMargin = this.padding;
            }
            if (this.caq.getVisibility() == 0) {
                this.caq.setLayoutParams(this.cas);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        ai.j(this.cao, d.g.forum_item_bg);
        return true;
    }
}
