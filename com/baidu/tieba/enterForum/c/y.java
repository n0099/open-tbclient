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
    final View.OnClickListener aRG;
    private ViewEventCenter bEQ;
    private View bGF;
    private TextView bGI;
    private TextView bGJ;
    private TextView bGK;
    private TbImageView bGL;
    final View.OnLongClickListener bGM;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aRG = new z(this);
        this.bGM = new aa(this);
        this.bEQ = viewEventCenter;
        this.bGF = view.findViewById(w.h.container);
        this.bGI = (TextView) view.findViewById(w.h.forum_icon_sign);
        this.bGJ = (TextView) view.findViewById(w.h.home_lv_like_forum);
        this.bGK = (TextView) view.findViewById(w.h.forum_lv_like_grade);
        this.bGL = (TbImageView) view.findViewById(w.h.home_lv_like_forum_icon);
        this.bGL.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bGL.setDefaultResource(w.g.transparent_bg);
        this.bGL.setDefaultErrorResource(w.g.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.u uVar) {
        super.E(uVar);
        if (uVar != null) {
            int level = uVar.getLevel();
            this.bGJ.setText(uVar.getName());
            if (uVar.bgL() == 0) {
                this.bGI.setVisibility(8);
            } else {
                this.bGI.setVisibility(0);
            }
            if (level == 0) {
                this.bGK.setVisibility(4);
            } else {
                this.bGK.setVisibility(0);
                aq.j(this.bGK, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.bGL.c(uVar.getAvatar(), 10, false);
            this.bGF.setOnClickListener(this.aRG);
            this.bGF.setOnLongClickListener(this.bGM);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        aq.j(this.bGF, w.g.addresslist_item_bg);
        this.bGL.invalidate();
        if (this.bGK.isShown() && getData() != null) {
            aq.j(this.bGK, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
