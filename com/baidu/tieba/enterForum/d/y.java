package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.ae, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aCK;
    private View aDV;
    private TextView aDW;
    private TextView aDX;
    private TextView aEr;
    private TbImageView aEs;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aCK = viewEventCenter;
        this.aDV = view.findViewById(com.baidu.tieba.v.container);
        this.aEr = (TextView) view.findViewById(com.baidu.tieba.v.forum_icon_sign);
        this.aDW = (TextView) view.findViewById(com.baidu.tieba.v.home_lv_like_forum);
        this.aDX = (TextView) view.findViewById(com.baidu.tieba.v.forum_lv_like_grade);
        this.aEs = (TbImageView) view.findViewById(com.baidu.tieba.v.home_lv_like_forum_icon);
        this.aEs.setDefaultBgResource(com.baidu.tieba.s.cp_cont_e);
        this.aEs.setDefaultResource(com.baidu.tieba.u.icon_default_ba_120);
        HB();
    }

    private void HB() {
        this.aDV.setOnClickListener(new z(this));
        this.aDV.setOnLongClickListener(new aa(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: c */
    public void A(com.baidu.tieba.tbadkCore.ae aeVar) {
        super.A(aeVar);
        if (aeVar != null) {
            int level = aeVar.getLevel();
            this.aDW.setText(aeVar.getName());
            if (aeVar.akO() == 0) {
                this.aEr.setVisibility(8);
            } else {
                this.aEr.setVisibility(0);
            }
            if (level == 0) {
                this.aDX.setVisibility(4);
            } else {
                this.aDX.setVisibility(0);
                ba.i((View) this.aDX, com.baidu.tbadk.core.util.c.bQ(level));
            }
            this.aEs.c(aeVar.getAvatar(), 10, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ba.i(this.aDV, com.baidu.tieba.u.addresslist_item_bg);
        this.aEs.invalidate();
        if (this.aDX.getVisibility() == 0 && getData() != null) {
            ba.i((View) this.aDX, com.baidu.tbadk.core.util.c.bQ(getData().getLevel()));
            return true;
        }
        return true;
    }
}
