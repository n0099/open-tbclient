package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.tbadkCore.u, com.baidu.tbadk.mvc.d.b> {
    final View.OnClickListener aLT;
    private ViewEventCenter bxK;
    private TextView bzC;
    private TextView bzD;
    private TextView bzE;
    private TbImageView bzF;
    final View.OnLongClickListener bzG;
    private View bzz;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aLT = new z(this);
        this.bzG = new aa(this);
        this.bxK = viewEventCenter;
        this.bzz = view.findViewById(r.h.container);
        this.bzC = (TextView) view.findViewById(r.h.forum_icon_sign);
        this.bzD = (TextView) view.findViewById(r.h.home_lv_like_forum);
        this.bzE = (TextView) view.findViewById(r.h.forum_lv_like_grade);
        this.bzF = (TbImageView) view.findViewById(r.h.home_lv_like_forum_icon);
        this.bzF.setDefaultBgResource(r.e.cp_bg_line_e);
        this.bzF.setDefaultResource(r.g.transparent_bg);
        this.bzF.setDefaultErrorResource(r.g.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.u uVar) {
        super.E(uVar);
        if (uVar != null) {
            int level = uVar.getLevel();
            this.bzD.setText(uVar.getName());
            if (uVar.bgY() == 0) {
                this.bzC.setVisibility(8);
            } else {
                this.bzC.setVisibility(0);
            }
            if (level == 0) {
                this.bzE.setVisibility(4);
            } else {
                this.bzE.setVisibility(0);
                ap.j((View) this.bzE, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.bzF.c(uVar.getAvatar(), 10, false);
            this.bzz.setOnClickListener(this.aLT);
            this.bzz.setOnLongClickListener(this.bzG);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        ap.j(this.bzz, r.g.addresslist_item_bg);
        this.bzF.invalidate();
        if (this.bzE.isShown() && getData() != null) {
            ap.j((View) this.bzE, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
