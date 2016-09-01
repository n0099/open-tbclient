package com.baidu.tieba.enterForum.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aOw;
    final View.OnClickListener aif;
    private View bIQ;
    private TextView bIT;
    private TextView bIU;
    private TextView bIV;
    private TbImageView bIW;
    final View.OnLongClickListener bIX;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aif = new z(this);
        this.bIX = new aa(this);
        this.aOw = viewEventCenter;
        this.bIQ = view.findViewById(t.g.container);
        this.bIT = (TextView) view.findViewById(t.g.forum_icon_sign);
        this.bIU = (TextView) view.findViewById(t.g.home_lv_like_forum);
        this.bIV = (TextView) view.findViewById(t.g.forum_lv_like_grade);
        this.bIW = (TbImageView) view.findViewById(t.g.home_lv_like_forum_icon);
        this.bIW.setDefaultBgResource(t.d.cp_bg_line_e);
        this.bIW.setDefaultResource(t.f.transparent_bg);
        this.bIW.setDefaultErrorResource(t.f.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.w wVar) {
        super.E(wVar);
        if (wVar != null) {
            int level = wVar.getLevel();
            this.bIU.setText(wVar.getName());
            if (wVar.bii() == 0) {
                this.bIT.setVisibility(8);
            } else {
                this.bIT.setVisibility(0);
            }
            if (level == 0) {
                this.bIV.setVisibility(4);
            } else {
                this.bIV.setVisibility(0);
                av.k(this.bIV, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.bIW.c(wVar.getAvatar(), 10, false);
            this.bIQ.setOnClickListener(this.aif);
            this.bIQ.setOnLongClickListener(this.bIX);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        av.k(this.bIQ, t.f.addresslist_item_bg);
        this.bIW.invalidate();
        if (this.bIV.isShown() && getData() != null) {
            av.k(this.bIV, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
