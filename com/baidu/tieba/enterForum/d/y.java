package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aPL;
    final View.OnClickListener ahN;
    private View bIR;
    private TextView bIU;
    private TextView bIV;
    private TextView bIW;
    private TbImageView bIX;
    final View.OnLongClickListener bIY;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ahN = new z(this);
        this.bIY = new aa(this);
        this.aPL = viewEventCenter;
        this.bIR = view.findViewById(r.g.container);
        this.bIU = (TextView) view.findViewById(r.g.forum_icon_sign);
        this.bIV = (TextView) view.findViewById(r.g.home_lv_like_forum);
        this.bIW = (TextView) view.findViewById(r.g.forum_lv_like_grade);
        this.bIX = (TbImageView) view.findViewById(r.g.home_lv_like_forum_icon);
        this.bIX.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bIX.setDefaultResource(r.f.transparent_bg);
        this.bIX.setDefaultErrorResource(r.f.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.w wVar) {
        super.E(wVar);
        if (wVar != null) {
            int level = wVar.getLevel();
            this.bIV.setText(wVar.getName());
            if (wVar.biT() == 0) {
                this.bIU.setVisibility(8);
            } else {
                this.bIU.setVisibility(0);
            }
            if (level == 0) {
                this.bIW.setVisibility(4);
            } else {
                this.bIW.setVisibility(0);
                av.k(this.bIW, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.bIX.c(wVar.getAvatar(), 10, false);
            this.bIR.setOnClickListener(this.ahN);
            this.bIR.setOnLongClickListener(this.bIY);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        av.k(this.bIR, r.f.addresslist_item_bg);
        this.bIX.invalidate();
        if (this.bIW.isShown() && getData() != null) {
            av.k(this.bIW, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
