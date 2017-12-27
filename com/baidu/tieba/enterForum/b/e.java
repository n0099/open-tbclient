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
    private ViewEventCenter dhh;
    private View djA;
    private TextView djB;
    private ImageView djC;
    private View djD;
    private RelativeLayout.LayoutParams djE;
    private int ds44;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ds44 = 0;
        this.djA = view.findViewById(d.g.container_edit_forum);
        this.dhh = viewEventCenter;
        this.djB = (TextView) view.findViewById(d.g.forum_name_view);
        this.djC = (ImageView) view.findViewById(d.g.delete_forum_view);
        this.djD = view.findViewById(d.g.divider_left_name);
        this.djC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.dhh != null) {
                    e.this.dhh.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
                }
            }
        });
        this.ds44 = l.s(tbPageContext.getPageActivity(), d.e.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void aI(com.baidu.tieba.enterForum.data.f fVar) {
        super.aI(fVar);
        if (fVar != null) {
            if (fVar.getType() == 1) {
                aj.e(this.djB, d.C0108d.cp_cont_d, 1);
                this.djB.setText(d.j.default_personalized_name);
                aj.s(this.djA, d.C0108d.cp_bg_line_d);
                this.djC.setVisibility(8);
            } else {
                aj.e(this.djB, d.C0108d.cp_cont_b, 1);
                this.djB.setText(fVar.getName());
                this.djC.setVisibility(0);
                aj.s(this.djA, d.f.forum_item_bg);
            }
            this.djE = (RelativeLayout.LayoutParams) this.djC.getLayoutParams();
            if (this.position % 2 == 0) {
                this.djD.setVisibility(8);
                this.djE.leftMargin = 0;
            } else {
                this.djD.setVisibility(0);
                this.djE.leftMargin = this.ds44;
            }
            if (this.djC.getVisibility() == 0) {
                this.djC.setLayoutParams(this.djE);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        aj.s(this.djA, d.f.forum_item_bg);
        return true;
    }
}
