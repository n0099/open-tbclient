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
    private TextView bcz;
    private ViewEventCenter dlJ;
    private View dob;
    private ImageView dod;
    private View doe;
    private RelativeLayout.LayoutParams dof;
    private int ds44;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ds44 = 0;
        this.dob = view.findViewById(d.g.container_edit_forum);
        this.dlJ = viewEventCenter;
        this.bcz = (TextView) view.findViewById(d.g.forum_name_view);
        this.dod = (ImageView) view.findViewById(d.g.delete_forum_view);
        this.doe = view.findViewById(d.g.divider_left_name);
        this.dod.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.dlJ != null) {
                    e.this.dlJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
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
                aj.e(this.bcz, d.C0107d.cp_cont_d, 1);
                this.bcz.setText(d.j.default_personalized_name);
                aj.s(this.dob, d.C0107d.cp_bg_line_d);
                this.dod.setVisibility(8);
            } else {
                aj.e(this.bcz, d.C0107d.cp_cont_b, 1);
                this.bcz.setText(fVar.getName());
                this.dod.setVisibility(0);
                aj.s(this.dob, d.f.forum_item_bg);
            }
            this.dof = (RelativeLayout.LayoutParams) this.dod.getLayoutParams();
            if (this.position % 2 == 0) {
                this.doe.setVisibility(8);
                this.dof.leftMargin = 0;
            } else {
                this.doe.setVisibility(0);
                this.dof.leftMargin = this.ds44;
            }
            if (this.dod.getVisibility() == 0) {
                this.dod.setLayoutParams(this.dof);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        aj.s(this.dob, d.f.forum_item_bg);
        return true;
    }
}
