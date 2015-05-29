package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.ae, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aET;
    private TextView aGC;
    private TbImageView aGD;
    private View aGg;
    private TextView aGh;
    private TextView aGi;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aET = viewEventCenter;
        this.aGg = view.findViewById(com.baidu.tieba.q.container);
        this.aGC = (TextView) view.findViewById(com.baidu.tieba.q.forum_icon_sign);
        this.aGh = (TextView) view.findViewById(com.baidu.tieba.q.home_lv_like_forum);
        this.aGi = (TextView) view.findViewById(com.baidu.tieba.q.forum_lv_like_grade);
        this.aGD = (TbImageView) view.findViewById(com.baidu.tieba.q.home_lv_like_forum_icon);
        this.aGD.setDefaultBgResource(com.baidu.tieba.n.cp_cont_e);
        this.aGD.setDefaultResource(com.baidu.tieba.p.icon_default_ba_120);
        initListener();
    }

    private void initListener() {
        this.aGg.setOnClickListener(new z(this));
        this.aGg.setOnLongClickListener(new aa(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: c */
    public void z(com.baidu.tieba.tbadkCore.ae aeVar) {
        super.z(aeVar);
        if (aeVar != null) {
            int level = aeVar.getLevel();
            this.aGh.setText(aeVar.getName());
            if (aeVar.amO() == 0) {
                this.aGC.setVisibility(8);
            } else {
                this.aGC.setVisibility(0);
            }
            if (level == 0) {
                this.aGi.setVisibility(4);
            } else {
                this.aGi.setVisibility(0);
                ay.i((View) this.aGi, com.baidu.tbadk.core.util.c.bT(level));
            }
            this.aGD.c(aeVar.getAvatar(), 10, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ay.i(this.aGg, com.baidu.tieba.p.addresslist_item_bg);
        this.aGD.invalidate();
        if (this.aGi.getVisibility() == 0 && getData() != null) {
            ay.i((View) this.aGi, com.baidu.tbadk.core.util.c.bT(getData().getLevel()));
            return true;
        }
        return true;
    }
}
