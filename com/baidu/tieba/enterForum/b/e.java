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
    private TextView bel;
    private ViewEventCenter doJ;
    private View dre;
    private ImageView drf;
    private View drg;
    private RelativeLayout.LayoutParams drh;
    private int ds44;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ds44 = 0;
        this.dre = view.findViewById(d.g.container_edit_forum);
        this.doJ = viewEventCenter;
        this.bel = (TextView) view.findViewById(d.g.forum_name_view);
        this.drf = (ImageView) view.findViewById(d.g.delete_forum_view);
        this.drg = view.findViewById(d.g.divider_left_name);
        this.drf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.doJ != null) {
                    e.this.doJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
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
                aj.e(this.bel, d.C0141d.cp_cont_d, 1);
                this.bel.setText(d.j.default_personalized_name);
                aj.s(this.dre, d.C0141d.cp_bg_line_d);
                this.drf.setVisibility(8);
            } else {
                aj.e(this.bel, d.C0141d.cp_cont_b, 1);
                this.bel.setText(fVar.getName());
                this.drf.setVisibility(0);
                aj.s(this.dre, d.f.forum_item_bg);
            }
            this.drh = (RelativeLayout.LayoutParams) this.drf.getLayoutParams();
            if (this.position % 2 == 0) {
                this.drg.setVisibility(8);
                this.drh.leftMargin = 0;
            } else {
                this.drg.setVisibility(0);
                this.drh.leftMargin = this.ds44;
            }
            if (this.drf.getVisibility() == 0) {
                this.drf.setLayoutParams(this.drh);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        aj.s(this.dre, d.f.forum_item_bg);
        return true;
    }
}
