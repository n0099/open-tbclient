package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.ae, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aEU;
    private TextView aGD;
    private TbImageView aGE;
    private View aGh;
    private TextView aGi;
    private TextView aGj;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aEU = viewEventCenter;
        this.aGh = view.findViewById(com.baidu.tieba.q.container);
        this.aGD = (TextView) view.findViewById(com.baidu.tieba.q.forum_icon_sign);
        this.aGi = (TextView) view.findViewById(com.baidu.tieba.q.home_lv_like_forum);
        this.aGj = (TextView) view.findViewById(com.baidu.tieba.q.forum_lv_like_grade);
        this.aGE = (TbImageView) view.findViewById(com.baidu.tieba.q.home_lv_like_forum_icon);
        this.aGE.setDefaultBgResource(com.baidu.tieba.n.cp_cont_e);
        this.aGE.setDefaultResource(com.baidu.tieba.p.icon_default_ba_120);
        initListener();
    }

    private void initListener() {
        this.aGh.setOnClickListener(new z(this));
        this.aGh.setOnLongClickListener(new aa(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: c */
    public void z(com.baidu.tieba.tbadkCore.ae aeVar) {
        super.z(aeVar);
        if (aeVar != null) {
            int level = aeVar.getLevel();
            this.aGi.setText(aeVar.getName());
            if (aeVar.amP() == 0) {
                this.aGD.setVisibility(8);
            } else {
                this.aGD.setVisibility(0);
            }
            if (level == 0) {
                this.aGj.setVisibility(4);
            } else {
                this.aGj.setVisibility(0);
                ay.i((View) this.aGj, com.baidu.tbadk.core.util.c.bT(level));
            }
            this.aGE.c(aeVar.getAvatar(), 10, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ay.i(this.aGh, com.baidu.tieba.p.addresslist_item_bg);
        this.aGE.invalidate();
        if (this.aGj.getVisibility() == 0 && getData() != null) {
            ay.i((View) this.aGj, com.baidu.tbadk.core.util.c.bT(getData().getLevel()));
            return true;
        }
        return true;
    }
}
