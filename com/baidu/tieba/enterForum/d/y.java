package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    final View.OnClickListener aNB;
    private ViewEventCenter aRS;
    private View bLK;
    private TextView bLN;
    private TextView bLO;
    private TextView bLP;
    private TbImageView bLQ;
    final View.OnLongClickListener bLR;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aNB = new z(this);
        this.bLR = new aa(this);
        this.aRS = viewEventCenter;
        this.bLK = view.findViewById(r.g.container);
        this.bLN = (TextView) view.findViewById(r.g.forum_icon_sign);
        this.bLO = (TextView) view.findViewById(r.g.home_lv_like_forum);
        this.bLP = (TextView) view.findViewById(r.g.forum_lv_like_grade);
        this.bLQ = (TbImageView) view.findViewById(r.g.home_lv_like_forum_icon);
        this.bLQ.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bLQ.setDefaultResource(r.f.transparent_bg);
        this.bLQ.setDefaultErrorResource(r.f.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.w wVar) {
        super.E(wVar);
        if (wVar != null) {
            int level = wVar.getLevel();
            this.bLO.setText(wVar.getName());
            if (wVar.blt() == 0) {
                this.bLN.setVisibility(8);
            } else {
                this.bLN.setVisibility(0);
            }
            if (level == 0) {
                this.bLP.setVisibility(4);
            } else {
                this.bLP.setVisibility(0);
                at.k(this.bLP, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.bLQ.c(wVar.getAvatar(), 10, false);
            this.bLK.setOnClickListener(this.aNB);
            this.bLK.setOnLongClickListener(this.bLR);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        at.k(this.bLK, r.f.addresslist_item_bg);
        this.bLQ.invalidate();
        if (this.bLP.isShown() && getData() != null) {
            at.k(this.bLP, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
