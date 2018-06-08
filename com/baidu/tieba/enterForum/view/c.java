package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.f;
/* loaded from: classes2.dex */
public class c extends com.baidu.tbadk.mvc.f.a<f, com.baidu.tbadk.mvc.d.b> {
    private TextView axM;
    private ViewEventCenter cRe;
    private View cTZ;
    private ImageView cUa;
    private View cUb;
    private RelativeLayout.LayoutParams cUc;
    private int ds44;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ds44 = 0;
        this.cTZ = view.findViewById(d.g.container_edit_forum);
        this.cRe = viewEventCenter;
        this.axM = (TextView) view.findViewById(d.g.forum_name_view);
        this.cUa = (ImageView) view.findViewById(d.g.delete_forum_view);
        this.cUb = view.findViewById(d.g.divider_left_name);
        this.cUa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.cRe != null) {
                    c.this.cRe.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, c.this.getData(), null, null));
                }
            }
        });
        this.ds44 = l.e(tbPageContext.getPageActivity(), d.e.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void G(f fVar) {
        super.G(fVar);
        if (fVar != null) {
            if (fVar.getType() == 1) {
                al.c(this.axM, d.C0141d.cp_cont_d, 1);
                this.axM.setText(d.k.default_personalized_name);
                al.i(this.cTZ, d.C0141d.cp_bg_line_d);
                this.cUa.setVisibility(8);
            } else {
                al.c(this.axM, d.C0141d.cp_cont_b, 1);
                this.axM.setText(fVar.getName());
                this.cUa.setVisibility(0);
                al.i(this.cTZ, d.f.forum_item_bg);
            }
            this.cUc = (RelativeLayout.LayoutParams) this.cUa.getLayoutParams();
            if (this.position % 2 == 0) {
                this.cUb.setVisibility(8);
                this.cUc.leftMargin = 0;
            } else {
                this.cUb.setVisibility(0);
                this.cUc.leftMargin = this.ds44;
            }
            if (this.cUa.getVisibility() == 0) {
                this.cUa.setLayoutParams(this.cUc);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        al.i(this.cTZ, d.f.forum_item_bg);
        return true;
    }
}
