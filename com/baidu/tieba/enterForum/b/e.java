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
    private ViewEventCenter cjC;
    private View clS;
    private TextView clT;
    private ImageView clU;
    private View clV;
    private RelativeLayout.LayoutParams clW;
    private int padding;

    public e(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.padding = 0;
        this.clS = view.findViewById(d.g.container_edit_forum);
        this.cjC = viewEventCenter;
        this.clT = (TextView) view.findViewById(d.g.forum_name_view);
        this.clU = (ImageView) view.findViewById(d.g.delete_forum_view);
        this.clV = view.findViewById(d.g.divider_left_name);
        this.clU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.cjC != null) {
                    e.this.cjC.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, e.this.getData(), null, null));
                }
            }
        });
        this.padding = l.f(tbPageContext.getPageActivity(), d.e.ds16);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void D(com.baidu.tieba.enterForum.data.f fVar) {
        super.D(fVar);
        if (fVar != null) {
            if (fVar.getType() == 1) {
                aj.c(this.clT, d.C0080d.cp_cont_d, 1);
                this.clT.setText(d.j.default_personalized_name);
                aj.j(this.clS, d.C0080d.cp_bg_line_d);
                this.clU.setVisibility(8);
            } else {
                aj.c(this.clT, d.C0080d.cp_cont_b, 1);
                this.clT.setText(fVar.getName());
                this.clU.setVisibility(0);
                aj.j(this.clS, d.f.forum_item_bg);
            }
            this.clW = (RelativeLayout.LayoutParams) this.clU.getLayoutParams();
            if (this.position % 2 == 0) {
                this.clV.setVisibility(8);
                this.clW.leftMargin = 0;
            } else {
                this.clV.setVisibility(0);
                this.clW.leftMargin = this.padding;
                this.clW.rightMargin = this.padding;
            }
            if (this.clU.getVisibility() == 0) {
                this.clU.setLayoutParams(this.clW);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.m
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        aj.j(this.clS, d.f.forum_item_bg);
        return true;
    }
}
