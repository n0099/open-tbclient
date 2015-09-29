package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aLB;
    private View aMP;
    private TextView aMQ;
    private TextView aMR;
    private TextView aNm;
    private TbImageView aNn;

    public z(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aLB = viewEventCenter;
        this.aMP = view.findViewById(i.f.container);
        this.aNm = (TextView) view.findViewById(i.f.forum_icon_sign);
        this.aMQ = (TextView) view.findViewById(i.f.home_lv_like_forum);
        this.aMR = (TextView) view.findViewById(i.f.forum_lv_like_grade);
        this.aNn = (TbImageView) view.findViewById(i.f.home_lv_like_forum_icon);
        this.aNn.setDefaultBgResource(i.c.cp_cont_e);
        this.aNn.setDefaultResource(i.e.icon_default_ba_120);
        initListener();
    }

    private void initListener() {
        this.aMP.setOnClickListener(new aa(this));
        this.aMP.setOnLongClickListener(new ab(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.v vVar) {
        super.B(vVar);
        if (vVar != null) {
            int level = vVar.getLevel();
            this.aMQ.setText(vVar.getName());
            if (vVar.avS() == 0) {
                this.aNm.setVisibility(8);
            } else {
                this.aNm.setVisibility(0);
            }
            if (level == 0) {
                this.aMR.setVisibility(4);
            } else {
                this.aMR.setVisibility(0);
                am.i((View) this.aMR, com.baidu.tbadk.core.util.c.ch(level));
            }
            this.aNn.d(vVar.getAvatar(), 10, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        am.i(this.aMP, i.e.addresslist_item_bg);
        this.aNn.invalidate();
        if (this.aMR.getVisibility() == 0 && getData() != null) {
            am.i((View) this.aMR, com.baidu.tbadk.core.util.c.ch(getData().getLevel()));
            return true;
        }
        return true;
    }
}
