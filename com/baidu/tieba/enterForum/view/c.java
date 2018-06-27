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
    private TextView ayD;
    private ViewEventCenter cOZ;
    private View cRZ;
    private TextView cSa;
    private ImageView cSb;
    private View cSc;
    private RelativeLayout.LayoutParams cSd;
    private int ds44;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ds44 = 0;
        this.cRZ = view.findViewById(d.g.container_edit_forum);
        this.cOZ = viewEventCenter;
        this.ayD = (TextView) view.findViewById(d.g.forum_name_view);
        this.cSb = (ImageView) view.findViewById(d.g.delete_forum_view);
        this.cSc = view.findViewById(d.g.divider_left_name);
        this.cSb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.cOZ != null) {
                    c.this.cOZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, c.this.getData(), null, null));
                }
            }
        });
        this.cSa = (TextView) view.findViewById(d.g.brand_label);
        this.ds44 = l.e(tbPageContext.getPageActivity(), d.e.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void G(f fVar) {
        super.G(fVar);
        if (fVar != null) {
            if (fVar.getType() == 1) {
                am.c(this.ayD, d.C0142d.cp_cont_d, 1);
                this.ayD.setText(d.k.default_personalized_name);
                am.i(this.cRZ, d.C0142d.cp_bg_line_d);
                this.cSb.setVisibility(8);
            } else {
                am.c(this.ayD, d.C0142d.cp_cont_b, 1);
                this.ayD.setText(fVar.getName());
                this.cSb.setVisibility(0);
                am.i(this.cRZ, d.f.forum_item_bg);
            }
            this.cSd = (RelativeLayout.LayoutParams) this.cSb.getLayoutParams();
            if (this.position % 2 == 0) {
                this.cSc.setVisibility(8);
                this.cSd.leftMargin = 0;
            } else {
                this.cSc.setVisibility(0);
                this.cSd.leftMargin = this.ds44;
            }
            if (this.cSb.getVisibility() == 0) {
                this.cSb.setLayoutParams(this.cSd);
            }
            if (fVar.anY() == 1) {
                this.cSa.setVisibility(0);
            } else {
                this.cSa.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        am.i(this.cRZ, d.f.forum_item_bg);
        am.i(this.cSa, d.f.enter_forum_brand_label_bg_shape);
        am.h(this.cSa, d.C0142d.cp_cont_i);
        return true;
    }
}
