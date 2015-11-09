package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aLU;
    private TextView aNF;
    private TbImageView aNG;
    private View aNi;
    private TextView aNj;
    private TextView aNk;

    public z(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aLU = viewEventCenter;
        this.aNi = view.findViewById(i.f.container);
        this.aNF = (TextView) view.findViewById(i.f.forum_icon_sign);
        this.aNj = (TextView) view.findViewById(i.f.home_lv_like_forum);
        this.aNk = (TextView) view.findViewById(i.f.forum_lv_like_grade);
        this.aNG = (TbImageView) view.findViewById(i.f.home_lv_like_forum_icon);
        this.aNG.setDefaultBgResource(i.c.cp_cont_e);
        this.aNG.setDefaultResource(i.e.icon_default_ba_120);
        initListener();
    }

    private void initListener() {
        this.aNi.setOnClickListener(new aa(this));
        this.aNi.setOnLongClickListener(new ab(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.v vVar) {
        super.B(vVar);
        if (vVar != null) {
            int level = vVar.getLevel();
            this.aNj.setText(vVar.getName());
            if (vVar.awE() == 0) {
                this.aNF.setVisibility(8);
            } else {
                this.aNF.setVisibility(0);
            }
            if (level == 0) {
                this.aNk.setVisibility(4);
            } else {
                this.aNk.setVisibility(0);
                an.i((View) this.aNk, com.baidu.tbadk.core.util.c.ch(level));
            }
            this.aNG.d(vVar.getAvatar(), 10, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        an.i(this.aNi, i.e.addresslist_item_bg);
        this.aNG.invalidate();
        if (this.aNk.getVisibility() == 0 && getData() != null) {
            an.i((View) this.aNk, com.baidu.tbadk.core.util.c.ch(getData().getLevel()));
            return true;
        }
        return true;
    }
}
