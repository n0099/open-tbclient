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
    final View.OnClickListener aew;
    private ViewEventCenter bfx;
    private View bvn;
    private TextView bvq;
    private TextView bvr;
    private TextView bvs;
    private TbImageView bvt;
    final View.OnLongClickListener bvu;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aew = new z(this);
        this.bvu = new aa(this);
        this.bfx = viewEventCenter;
        this.bvn = view.findViewById(u.g.container);
        this.bvq = (TextView) view.findViewById(u.g.forum_icon_sign);
        this.bvr = (TextView) view.findViewById(u.g.home_lv_like_forum);
        this.bvs = (TextView) view.findViewById(u.g.forum_lv_like_grade);
        this.bvt = (TbImageView) view.findViewById(u.g.home_lv_like_forum_icon);
        this.bvt.setDefaultBgResource(u.d.cp_bg_line_e);
        this.bvt.setDefaultResource(u.f.transparent_bg);
        this.bvt.setDefaultErrorResource(u.f.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.x xVar) {
        super.B(xVar);
        if (xVar != null) {
            int level = xVar.getLevel();
            this.bvr.setText(xVar.getName());
            if (xVar.bbo() == 0) {
                this.bvq.setVisibility(8);
            } else {
                this.bvq.setVisibility(0);
            }
            if (level == 0) {
                this.bvs.setVisibility(4);
            } else {
                this.bvs.setVisibility(0);
                av.k(this.bvs, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.bvt.c(xVar.getAvatar(), 10, false);
            this.bvn.setOnClickListener(this.aew);
            this.bvn.setOnLongClickListener(this.bvu);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        av.k(this.bvn, u.f.addresslist_item_bg);
        this.bvt.invalidate();
        if (this.bvs.isShown() && getData() != null) {
            av.k(this.bvs, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
