package com.baidu.tieba.enterForum.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    final View.OnClickListener Fn;
    private ViewEventCenter aXs;
    private View aZr;
    private TextView aZu;
    private TextView aZv;
    private TextView aZw;
    private TbImageView aZx;
    final View.OnLongClickListener aZy;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Fn = new z(this);
        this.aZy = new aa(this);
        this.aXs = viewEventCenter;
        this.aZr = view.findViewById(t.g.container);
        this.aZu = (TextView) view.findViewById(t.g.forum_icon_sign);
        this.aZv = (TextView) view.findViewById(t.g.home_lv_like_forum);
        this.aZw = (TextView) view.findViewById(t.g.forum_lv_like_grade);
        this.aZx = (TbImageView) view.findViewById(t.g.home_lv_like_forum_icon);
        this.aZx.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aZx.setDefaultResource(t.f.transparent_bg);
        this.aZx.setDefaultErrorResource(t.f.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.w wVar) {
        super.B(wVar);
        if (wVar != null) {
            int level = wVar.getLevel();
            this.aZv.setText(wVar.getName());
            if (wVar.aSV() == 0) {
                this.aZu.setVisibility(8);
            } else {
                this.aZu.setVisibility(0);
            }
            if (level == 0) {
                this.aZw.setVisibility(4);
            } else {
                this.aZw.setVisibility(0);
                at.k(this.aZw, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.aZx.c(wVar.getAvatar(), 10, false);
            this.aZr.setOnClickListener(this.Fn);
            this.aZr.setOnLongClickListener(this.aZy);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        at.k(this.aZr, t.f.addresslist_item_bg);
        this.aZx.invalidate();
        if (this.aZw.isShown() && getData() != null) {
            at.k(this.aZw, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
