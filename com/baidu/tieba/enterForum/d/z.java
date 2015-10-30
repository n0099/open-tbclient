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
    private ViewEventCenter aLM;
    private View aNa;
    private TextView aNb;
    private TextView aNc;
    private TextView aNx;
    private TbImageView aNy;

    public z(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aLM = viewEventCenter;
        this.aNa = view.findViewById(i.f.container);
        this.aNx = (TextView) view.findViewById(i.f.forum_icon_sign);
        this.aNb = (TextView) view.findViewById(i.f.home_lv_like_forum);
        this.aNc = (TextView) view.findViewById(i.f.forum_lv_like_grade);
        this.aNy = (TbImageView) view.findViewById(i.f.home_lv_like_forum_icon);
        this.aNy.setDefaultBgResource(i.c.cp_cont_e);
        this.aNy.setDefaultResource(i.e.icon_default_ba_120);
        initListener();
    }

    private void initListener() {
        this.aNa.setOnClickListener(new aa(this));
        this.aNa.setOnLongClickListener(new ab(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.v vVar) {
        super.B(vVar);
        if (vVar != null) {
            int level = vVar.getLevel();
            this.aNb.setText(vVar.getName());
            if (vVar.avW() == 0) {
                this.aNx.setVisibility(8);
            } else {
                this.aNx.setVisibility(0);
            }
            if (level == 0) {
                this.aNc.setVisibility(4);
            } else {
                this.aNc.setVisibility(0);
                an.i((View) this.aNc, com.baidu.tbadk.core.util.c.ch(level));
            }
            this.aNy.d(vVar.getAvatar(), 10, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        an.i(this.aNa, i.e.addresslist_item_bg);
        this.aNy.invalidate();
        if (this.aNc.getVisibility() == 0 && getData() != null) {
            an.i((View) this.aNc, com.baidu.tbadk.core.util.c.ch(getData().getLevel()));
            return true;
        }
        return true;
    }
}
