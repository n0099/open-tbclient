package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.x, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bgJ;
    private View bxb;
    private TextView bxc;
    private TextView bxd;
    private ImageView bxe;

    public u(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bgJ = viewEventCenter;
        this.bxb = view.findViewById(u.g.container);
        this.bxc = (TextView) view.findViewById(u.g.home_lv_like_forum);
        this.bxd = (TextView) view.findViewById(u.g.forum_lv_like_grade);
        this.bxe = (ImageView) view.findViewById(u.g.home_lv_like_forum_delete);
        this.bxe.setOnClickListener(new v(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.x xVar) {
        super.E(xVar);
        if (xVar != null) {
            int level = xVar.getLevel();
            this.bxc.setText(xVar.getName());
            if (level == 0) {
                this.bxd.setVisibility(4);
                return;
            }
            this.bxd.setVisibility(0);
            av.k(this.bxd, BitmapHelper.getGradeResourceIdNew(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        av.k(this.bxb, u.f.addresslist_item_bg);
        if (this.bxd.getVisibility() == 0 && getData() != null) {
            av.k(this.bxd, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
