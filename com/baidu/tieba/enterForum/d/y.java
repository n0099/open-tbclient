package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.u, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aMt;
    private View aNH;
    private TextView aNI;
    private TextView aNJ;
    private TextView aOd;
    private TbImageView aOe;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aMt = viewEventCenter;
        this.aNH = view.findViewById(i.f.container);
        this.aOd = (TextView) view.findViewById(i.f.forum_icon_sign);
        this.aNI = (TextView) view.findViewById(i.f.home_lv_like_forum);
        this.aNJ = (TextView) view.findViewById(i.f.forum_lv_like_grade);
        this.aOe = (TbImageView) view.findViewById(i.f.home_lv_like_forum_icon);
        this.aOe.setDefaultBgResource(i.c.cp_cont_e);
        this.aOe.setDefaultResource(i.e.icon_default_ba_120);
        initListener();
    }

    private void initListener() {
        this.aNH.setOnClickListener(new z(this));
        this.aNH.setOnLongClickListener(new aa(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void A(com.baidu.tieba.tbadkCore.u uVar) {
        super.A(uVar);
        if (uVar != null) {
            int level = uVar.getLevel();
            this.aNI.setText(uVar.getName());
            if (uVar.app() == 0) {
                this.aOd.setVisibility(8);
            } else {
                this.aOd.setVisibility(0);
            }
            if (level == 0) {
                this.aNJ.setVisibility(4);
            } else {
                this.aNJ.setVisibility(0);
                al.i((View) this.aNJ, com.baidu.tbadk.core.util.c.cb(level));
            }
            this.aOe.d(uVar.getAvatar(), 10, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        al.i(this.aNH, i.e.addresslist_item_bg);
        this.aOe.invalidate();
        if (this.aNJ.getVisibility() == 0 && getData() != null) {
            al.i((View) this.aNJ, com.baidu.tbadk.core.util.c.cb(getData().getLevel()));
            return true;
        }
        return true;
    }
}
