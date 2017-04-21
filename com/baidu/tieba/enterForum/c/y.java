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
    final View.OnClickListener aRY;
    private ViewEventCenter bHa;
    private View bIP;
    private TextView bIS;
    private TextView bIT;
    private TextView bIU;
    private TbImageView bIV;
    final View.OnLongClickListener bIW;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aRY = new z(this);
        this.bIW = new aa(this);
        this.bHa = viewEventCenter;
        this.bIP = view.findViewById(w.h.container);
        this.bIS = (TextView) view.findViewById(w.h.forum_icon_sign);
        this.bIT = (TextView) view.findViewById(w.h.home_lv_like_forum);
        this.bIU = (TextView) view.findViewById(w.h.forum_lv_like_grade);
        this.bIV = (TbImageView) view.findViewById(w.h.home_lv_like_forum_icon);
        this.bIV.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bIV.setDefaultResource(w.g.transparent_bg);
        this.bIV.setDefaultErrorResource(w.g.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.u uVar) {
        super.E(uVar);
        if (uVar != null) {
            int level = uVar.getLevel();
            this.bIT.setText(uVar.getName());
            if (uVar.bix() == 0) {
                this.bIS.setVisibility(8);
            } else {
                this.bIS.setVisibility(0);
            }
            if (level == 0) {
                this.bIU.setVisibility(4);
            } else {
                this.bIU.setVisibility(0);
                aq.j(this.bIU, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.bIV.c(uVar.getAvatar(), 10, false);
            this.bIP.setOnClickListener(this.aRY);
            this.bIP.setOnLongClickListener(this.bIW);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        aq.j(this.bIP, w.g.addresslist_item_bg);
        this.bIV.invalidate();
        if (this.bIU.isShown() && getData() != null) {
            aq.j(this.bIU, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
