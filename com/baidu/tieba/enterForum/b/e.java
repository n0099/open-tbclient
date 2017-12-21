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
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.f, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter csJ;
    private View cve;
    private TextView cvf;
    private ImageView cvg;
    private View cvh;
    private RelativeLayout.LayoutParams cvi;
    private int ds44;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ds44 = 0;
        this.cve = view.findViewById(d.g.container_edit_forum);
        this.csJ = viewEventCenter;
        this.cvf = (TextView) view.findViewById(d.g.forum_name_view);
        this.cvg = (ImageView) view.findViewById(d.g.delete_forum_view);
        this.cvh = view.findViewById(d.g.divider_left_name);
        this.cvg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.csJ != null) {
                    e.this.csJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
                }
            }
        });
        this.ds44 = l.f(tbPageContext.getPageActivity(), d.e.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void D(com.baidu.tieba.enterForum.data.f fVar) {
        super.D(fVar);
        if (fVar != null) {
            if (fVar.getType() == 1) {
                aj.c(this.cvf, d.C0095d.cp_cont_d, 1);
                this.cvf.setText(d.j.default_personalized_name);
                aj.j(this.cve, d.C0095d.cp_bg_line_d);
                this.cvg.setVisibility(8);
            } else {
                aj.c(this.cvf, d.C0095d.cp_cont_b, 1);
                this.cvf.setText(fVar.getName());
                this.cvg.setVisibility(0);
                aj.j(this.cve, d.f.forum_item_bg);
            }
            this.cvi = (RelativeLayout.LayoutParams) this.cvg.getLayoutParams();
            if (this.position % 2 == 0) {
                this.cvh.setVisibility(8);
                this.cvi.leftMargin = 0;
            } else {
                this.cvh.setVisibility(0);
                this.cvi.leftMargin = this.ds44;
            }
            if (this.cvg.getVisibility() == 0) {
                this.cvg.setLayoutParams(this.cvi);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        aj.j(this.cve, d.f.forum_item_bg);
        return true;
    }
}
