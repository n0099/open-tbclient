package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.x, com.baidu.tbadk.mvc.d.b> {
    final View.OnClickListener afk;
    private ViewEventCenter bgJ;
    private View bxB;
    private TextView bxE;
    private TextView bxF;
    private TextView bxG;
    private TbImageView bxH;
    final View.OnLongClickListener bxI;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.afk = new z(this);
        this.bxI = new aa(this);
        this.bgJ = viewEventCenter;
        this.bxB = view.findViewById(u.g.container);
        this.bxE = (TextView) view.findViewById(u.g.forum_icon_sign);
        this.bxF = (TextView) view.findViewById(u.g.home_lv_like_forum);
        this.bxG = (TextView) view.findViewById(u.g.forum_lv_like_grade);
        this.bxH = (TbImageView) view.findViewById(u.g.home_lv_like_forum_icon);
        this.bxH.setDefaultBgResource(u.d.cp_bg_line_e);
        this.bxH.setDefaultResource(u.f.transparent_bg);
        this.bxH.setDefaultErrorResource(u.f.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.x xVar) {
        super.E(xVar);
        if (xVar != null) {
            int level = xVar.getLevel();
            this.bxF.setText(xVar.getName());
            if (xVar.beC() == 0) {
                this.bxE.setVisibility(8);
            } else {
                this.bxE.setVisibility(0);
            }
            if (level == 0) {
                this.bxG.setVisibility(4);
            } else {
                this.bxG.setVisibility(0);
                av.k(this.bxG, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.bxH.c(xVar.getAvatar(), 10, false);
            this.bxB.setOnClickListener(this.afk);
            this.bxB.setOnLongClickListener(this.bxI);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        av.k(this.bxB, u.f.addresslist_item_bg);
        this.bxH.invalidate();
        if (this.bxG.isShown() && getData() != null) {
            av.k(this.bxG, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
