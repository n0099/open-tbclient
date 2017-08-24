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
    private ViewEventCenter bYx;
    private View cbb;
    private TextView cbc;
    private ImageView cbd;
    private View cbe;
    private RelativeLayout.LayoutParams cbf;
    private int padding;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.padding = 0;
        this.cbb = view.findViewById(d.h.container_edit_forum);
        this.bYx = viewEventCenter;
        this.cbc = (TextView) view.findViewById(d.h.forum_name_view);
        this.cbd = (ImageView) view.findViewById(d.h.delete_forum_view);
        this.cbe = view.findViewById(d.h.divider_left_name);
        this.cbd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.bYx != null) {
                    e.this.bYx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
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
                ai.c(this.cbc, d.e.cp_cont_d, 1);
                this.cbc.setText(d.l.default_personalized_name);
                ai.j(this.cbb, d.e.cp_bg_line_d);
                this.cbd.setVisibility(8);
            } else {
                ai.c(this.cbc, d.e.cp_cont_b, 1);
                this.cbc.setText(gVar.getName());
                this.cbd.setVisibility(0);
                ai.j(this.cbb, d.g.forum_item_bg);
            }
            this.cbf = (RelativeLayout.LayoutParams) this.cbd.getLayoutParams();
            if (this.position % 2 == 0) {
                this.cbe.setVisibility(8);
                this.cbf.leftMargin = 0;
            } else {
                this.cbe.setVisibility(0);
                this.cbf.leftMargin = this.padding;
                this.cbf.rightMargin = this.padding;
            }
            if (this.cbd.getVisibility() == 0) {
                this.cbd.setLayoutParams(this.cbf);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        ai.j(this.cbb, d.g.forum_item_bg);
        return true;
    }
}
