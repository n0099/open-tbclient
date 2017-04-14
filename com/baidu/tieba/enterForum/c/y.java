package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.tbadkCore.u, com.baidu.tbadk.mvc.d.b> {
    final View.OnClickListener aRW;
    private ViewEventCenter bEJ;
    private TextView bGB;
    private TextView bGC;
    private TextView bGD;
    private TbImageView bGE;
    final View.OnLongClickListener bGF;
    private View bGy;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aRW = new z(this);
        this.bGF = new aa(this);
        this.bEJ = viewEventCenter;
        this.bGy = view.findViewById(w.h.container);
        this.bGB = (TextView) view.findViewById(w.h.forum_icon_sign);
        this.bGC = (TextView) view.findViewById(w.h.home_lv_like_forum);
        this.bGD = (TextView) view.findViewById(w.h.forum_lv_like_grade);
        this.bGE = (TbImageView) view.findViewById(w.h.home_lv_like_forum_icon);
        this.bGE.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bGE.setDefaultResource(w.g.transparent_bg);
        this.bGE.setDefaultErrorResource(w.g.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.u uVar) {
        super.E(uVar);
        if (uVar != null) {
            int level = uVar.getLevel();
            this.bGC.setText(uVar.getName());
            if (uVar.bhw() == 0) {
                this.bGB.setVisibility(8);
            } else {
                this.bGB.setVisibility(0);
            }
            if (level == 0) {
                this.bGD.setVisibility(4);
            } else {
                this.bGD.setVisibility(0);
                aq.j(this.bGD, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.bGE.c(uVar.getAvatar(), 10, false);
            this.bGy.setOnClickListener(this.aRW);
            this.bGy.setOnLongClickListener(this.bGF);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        aq.j(this.bGy, w.g.addresslist_item_bg);
        this.bGE.invalidate();
        if (this.bGD.isShown() && getData() != null) {
            aq.j(this.bGD, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
