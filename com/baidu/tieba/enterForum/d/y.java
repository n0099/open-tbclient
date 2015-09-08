package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aMG;
    private View aNU;
    private TextView aNV;
    private TextView aNW;
    private TextView aOq;
    private TbImageView aOr;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aMG = viewEventCenter;
        this.aNU = view.findViewById(i.f.container);
        this.aOq = (TextView) view.findViewById(i.f.forum_icon_sign);
        this.aNV = (TextView) view.findViewById(i.f.home_lv_like_forum);
        this.aNW = (TextView) view.findViewById(i.f.forum_lv_like_grade);
        this.aOr = (TbImageView) view.findViewById(i.f.home_lv_like_forum_icon);
        this.aOr.setDefaultBgResource(i.c.cp_cont_e);
        this.aOr.setDefaultResource(i.e.icon_default_ba_120);
        initListener();
    }

    private void initListener() {
        this.aNU.setOnClickListener(new z(this));
        this.aNU.setOnLongClickListener(new aa(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.v vVar) {
        super.B(vVar);
        if (vVar != null) {
            int level = vVar.getLevel();
            this.aNV.setText(vVar.getName());
            if (vVar.atC() == 0) {
                this.aOq.setVisibility(8);
            } else {
                this.aOq.setVisibility(0);
            }
            if (level == 0) {
                this.aNW.setVisibility(4);
            } else {
                this.aNW.setVisibility(0);
                al.h((View) this.aNW, com.baidu.tbadk.core.util.c.cf(level));
            }
            this.aOr.d(vVar.getAvatar(), 10, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        al.h(this.aNU, i.e.addresslist_item_bg);
        this.aOr.invalidate();
        if (this.aNW.getVisibility() == 0 && getData() != null) {
            al.h((View) this.aNW, com.baidu.tbadk.core.util.c.cf(getData().getLevel()));
            return true;
        }
        return true;
    }
}
