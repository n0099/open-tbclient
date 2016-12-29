package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    final View.OnClickListener aMS;
    private ViewEventCenter aRj;
    private View brO;
    private TextView brR;
    private TextView brS;
    private TextView brT;
    private TbImageView brU;
    final View.OnLongClickListener brV;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aMS = new z(this);
        this.brV = new aa(this);
        this.aRj = viewEventCenter;
        this.brO = view.findViewById(r.g.container);
        this.brR = (TextView) view.findViewById(r.g.forum_icon_sign);
        this.brS = (TextView) view.findViewById(r.g.home_lv_like_forum);
        this.brT = (TextView) view.findViewById(r.g.forum_lv_like_grade);
        this.brU = (TbImageView) view.findViewById(r.g.home_lv_like_forum_icon);
        this.brU.setDefaultBgResource(r.d.cp_bg_line_e);
        this.brU.setDefaultResource(r.f.transparent_bg);
        this.brU.setDefaultErrorResource(r.f.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.v vVar) {
        super.E(vVar);
        if (vVar != null) {
            int level = vVar.getLevel();
            this.brS.setText(vVar.getName());
            if (vVar.bfi() == 0) {
                this.brR.setVisibility(8);
            } else {
                this.brR.setVisibility(0);
            }
            if (level == 0) {
                this.brT.setVisibility(4);
            } else {
                this.brT.setVisibility(0);
                ar.k(this.brT, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.brU.c(vVar.getAvatar(), 10, false);
            this.brO.setOnClickListener(this.aMS);
            this.brO.setOnLongClickListener(this.brV);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        ar.k(this.brO, r.f.addresslist_item_bg);
        this.brU.invalidate();
        if (this.brT.isShown() && getData() != null) {
            ar.k(this.brT, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
