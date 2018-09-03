package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class c extends com.baidu.tbadk.mvc.f.a<f, com.baidu.tbadk.mvc.d.b> {
    private TextView ayn;
    private ViewEventCenter cRF;
    private View cUI;
    private TextView cUJ;
    private ImageView cUK;
    private View cUL;
    private RelativeLayout.LayoutParams cUM;
    private int ds44;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ds44 = 0;
        this.cUI = view.findViewById(f.g.container_edit_forum);
        this.cRF = viewEventCenter;
        this.ayn = (TextView) view.findViewById(f.g.forum_name_view);
        this.cUK = (ImageView) view.findViewById(f.g.delete_forum_view);
        this.cUL = view.findViewById(f.g.divider_left_name);
        this.cUK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.cRF != null) {
                    c.this.cRF.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, c.this.getData(), null, null));
                }
            }
        });
        this.cUJ = (TextView) view.findViewById(f.g.brand_label);
        this.ds44 = l.f(tbPageContext.getPageActivity(), f.e.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void G(com.baidu.tieba.enterForum.data.f fVar) {
        super.G(fVar);
        if (fVar != null) {
            if (fVar.getType() == 1) {
                am.c(this.ayn, f.d.cp_cont_d, 1);
                this.ayn.setText(f.j.default_personalized_name);
                am.i(this.cUI, f.d.cp_bg_line_d);
                this.cUK.setVisibility(8);
            } else {
                am.c(this.ayn, f.d.cp_cont_b, 1);
                this.ayn.setText(fVar.getName());
                this.cUK.setVisibility(0);
                am.i(this.cUI, f.C0146f.forum_item_bg);
            }
            this.cUM = (RelativeLayout.LayoutParams) this.cUK.getLayoutParams();
            if (this.position % 2 == 0) {
                this.cUL.setVisibility(8);
                this.cUM.leftMargin = 0;
            } else {
                this.cUL.setVisibility(0);
                this.cUM.leftMargin = this.ds44;
            }
            if (this.cUK.getVisibility() == 0) {
                this.cUK.setLayoutParams(this.cUM);
            }
            if (fVar.aox() == 1) {
                this.cUJ.setVisibility(0);
            } else {
                this.cUJ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        am.i(this.cUI, f.C0146f.forum_item_bg);
        am.i(this.cUJ, f.C0146f.enter_forum_brand_label_bg_shape);
        am.h(this.cUJ, f.d.cp_cont_i);
        return true;
    }
}
