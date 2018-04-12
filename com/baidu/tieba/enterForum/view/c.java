package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.f;
/* loaded from: classes2.dex */
public class c extends com.baidu.tbadk.mvc.f.a<f, com.baidu.tbadk.mvc.d.b> {
    private TextView apF;
    private ViewEventCenter cGR;
    private View cJN;
    private ImageView cJO;
    private View cJP;
    private RelativeLayout.LayoutParams cJQ;
    private int ds44;

    public c(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        this.ds44 = 0;
        this.cJN = view2.findViewById(d.g.container_edit_forum);
        this.cGR = viewEventCenter;
        this.apF = (TextView) view2.findViewById(d.g.forum_name_view);
        this.cJO = (ImageView) view2.findViewById(d.g.delete_forum_view);
        this.cJP = view2.findViewById(d.g.divider_left_name);
        this.cJO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (c.this.cGR != null) {
                    c.this.cGR.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, c.this.getData(), null, null));
                }
            }
        });
        this.ds44 = l.e(tbPageContext.getPageActivity(), d.e.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void D(f fVar) {
        super.D(fVar);
        if (fVar != null) {
            if (fVar.getType() == 1) {
                ak.c(this.apF, d.C0126d.cp_cont_d, 1);
                this.apF.setText(d.k.default_personalized_name);
                ak.i(this.cJN, d.C0126d.cp_bg_line_d);
                this.cJO.setVisibility(8);
            } else {
                ak.c(this.apF, d.C0126d.cp_cont_b, 1);
                this.apF.setText(fVar.getName());
                this.cJO.setVisibility(0);
                ak.i(this.cJN, d.f.forum_item_bg);
            }
            this.cJQ = (RelativeLayout.LayoutParams) this.cJO.getLayoutParams();
            if (this.position % 2 == 0) {
                this.cJP.setVisibility(8);
                this.cJQ.leftMargin = 0;
            } else {
                this.cJP.setVisibility(0);
                this.cJQ.leftMargin = this.ds44;
            }
            if (this.cJO.getVisibility() == 0) {
                this.cJO.setLayoutParams(this.cJQ);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        ak.i(this.cJN, d.f.forum_item_bg);
        return true;
    }
}
