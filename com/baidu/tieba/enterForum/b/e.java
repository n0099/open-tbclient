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
    private TextView bcH;
    private ViewEventCenter dme;
    private RelativeLayout.LayoutParams doA;
    private View dox;
    private ImageView doy;
    private View doz;
    private int ds44;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ds44 = 0;
        this.dox = view.findViewById(d.g.container_edit_forum);
        this.dme = viewEventCenter;
        this.bcH = (TextView) view.findViewById(d.g.forum_name_view);
        this.doy = (ImageView) view.findViewById(d.g.delete_forum_view);
        this.doz = view.findViewById(d.g.divider_left_name);
        this.doy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.dme != null) {
                    e.this.dme.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
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
                aj.e(this.bcH, d.C0108d.cp_cont_d, 1);
                this.bcH.setText(d.j.default_personalized_name);
                aj.s(this.dox, d.C0108d.cp_bg_line_d);
                this.doy.setVisibility(8);
            } else {
                aj.e(this.bcH, d.C0108d.cp_cont_b, 1);
                this.bcH.setText(fVar.getName());
                this.doy.setVisibility(0);
                aj.s(this.dox, d.f.forum_item_bg);
            }
            this.doA = (RelativeLayout.LayoutParams) this.doy.getLayoutParams();
            if (this.position % 2 == 0) {
                this.doz.setVisibility(8);
                this.doA.leftMargin = 0;
            } else {
                this.doz.setVisibility(0);
                this.doA.leftMargin = this.ds44;
            }
            if (this.doy.getVisibility() == 0) {
                this.doy.setLayoutParams(this.doA);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        aj.s(this.dox, d.f.forum_item_bg);
        return true;
    }
}
