package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.tbadkCore.u, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bEJ;
    private View bFY;
    private TextView bFZ;
    private TextView bGa;
    private ImageView bGb;

    public m(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bFY = view.findViewById(w.h.container);
        this.bEJ = viewEventCenter;
        this.bFZ = (TextView) view.findViewById(w.h.home_lv_like_forum);
        this.bGa = (TextView) view.findViewById(w.h.forum_lv_like_grade);
        this.bGb = (ImageView) view.findViewById(w.h.home_lv_like_forum_delete);
        this.bGb.setOnClickListener(new n(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.u uVar) {
        super.E(uVar);
        if (uVar != null) {
            int level = uVar.getLevel();
            this.bFZ.setText(uVar.getName());
            if (level == 0) {
                this.bGa.setVisibility(4);
                return;
            }
            this.bGa.setVisibility(0);
            aq.j(this.bGa, BitmapHelper.getGradeResourceIdNew(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        aq.j(this.bFY, w.g.home_like_bg_with_margin);
        if (this.bGa.getVisibility() == 0 && getData() != null) {
            aq.j(this.bGa, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
