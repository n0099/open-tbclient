package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.f;
/* loaded from: classes2.dex */
public class c extends com.baidu.tbadk.mvc.f.a<f, com.baidu.tbadk.mvc.d.b> {
    private TextView ayq;
    private ViewEventCenter cRI;
    private View cUM;
    private TextView cUN;
    private ImageView cUO;
    private View cUP;
    private RelativeLayout.LayoutParams cUQ;
    private int ds44;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ds44 = 0;
        this.cUM = view.findViewById(d.g.container_edit_forum);
        this.cRI = viewEventCenter;
        this.ayq = (TextView) view.findViewById(d.g.forum_name_view);
        this.cUO = (ImageView) view.findViewById(d.g.delete_forum_view);
        this.cUP = view.findViewById(d.g.divider_left_name);
        this.cUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.cRI != null) {
                    c.this.cRI.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, c.this.getData(), null, null));
                }
            }
        });
        this.cUN = (TextView) view.findViewById(d.g.brand_label);
        this.ds44 = l.f(tbPageContext.getPageActivity(), d.e.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void G(f fVar) {
        super.G(fVar);
        if (fVar != null) {
            if (fVar.getType() == 1) {
                am.c(this.ayq, d.C0140d.cp_cont_d, 1);
                this.ayq.setText(d.j.default_personalized_name);
                am.i(this.cUM, d.C0140d.cp_bg_line_d);
                this.cUO.setVisibility(8);
            } else {
                am.c(this.ayq, d.C0140d.cp_cont_b, 1);
                this.ayq.setText(fVar.getName());
                this.cUO.setVisibility(0);
                am.i(this.cUM, d.f.forum_item_bg);
            }
            this.cUQ = (RelativeLayout.LayoutParams) this.cUO.getLayoutParams();
            if (this.position % 2 == 0) {
                this.cUP.setVisibility(8);
                this.cUQ.leftMargin = 0;
            } else {
                this.cUP.setVisibility(0);
                this.cUQ.leftMargin = this.ds44;
            }
            if (this.cUO.getVisibility() == 0) {
                this.cUO.setLayoutParams(this.cUQ);
            }
            if (fVar.aox() == 1) {
                this.cUN.setVisibility(0);
            } else {
                this.cUN.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        am.i(this.cUM, d.f.forum_item_bg);
        am.i(this.cUN, d.f.enter_forum_brand_label_bg_shape);
        am.h(this.cUN, d.C0140d.cp_cont_i);
        return true;
    }
}
