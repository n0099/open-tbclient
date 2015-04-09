package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.ae, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aCS;
    private TbImageView aEA;
    private View aEd;
    private TextView aEe;
    private TextView aEf;
    private TextView aEz;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aCS = viewEventCenter;
        this.aEd = view.findViewById(com.baidu.tieba.v.container);
        this.aEz = (TextView) view.findViewById(com.baidu.tieba.v.forum_icon_sign);
        this.aEe = (TextView) view.findViewById(com.baidu.tieba.v.home_lv_like_forum);
        this.aEf = (TextView) view.findViewById(com.baidu.tieba.v.forum_lv_like_grade);
        this.aEA = (TbImageView) view.findViewById(com.baidu.tieba.v.home_lv_like_forum_icon);
        this.aEA.setDefaultBgResource(com.baidu.tieba.s.cp_cont_e);
        this.aEA.setDefaultResource(com.baidu.tieba.u.icon_default_ba_120);
        HH();
    }

    private void HH() {
        this.aEd.setOnClickListener(new z(this));
        this.aEd.setOnLongClickListener(new aa(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: c */
    public void A(com.baidu.tieba.tbadkCore.ae aeVar) {
        super.A(aeVar);
        if (aeVar != null) {
            int level = aeVar.getLevel();
            this.aEe.setText(aeVar.getName());
            if (aeVar.ald() == 0) {
                this.aEz.setVisibility(8);
            } else {
                this.aEz.setVisibility(0);
            }
            if (level == 0) {
                this.aEf.setVisibility(4);
            } else {
                this.aEf.setVisibility(0);
                ba.i((View) this.aEf, com.baidu.tbadk.core.util.c.bQ(level));
            }
            this.aEA.c(aeVar.getAvatar(), 10, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ba.i(this.aEd, com.baidu.tieba.u.addresslist_item_bg);
        this.aEA.invalidate();
        if (this.aEf.getVisibility() == 0 && getData() != null) {
            ba.i((View) this.aEf, com.baidu.tbadk.core.util.c.bQ(getData().getLevel()));
            return true;
        }
        return true;
    }
}
