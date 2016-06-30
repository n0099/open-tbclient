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
public class m extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.x, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bfx;
    private View buN;
    private TextView buO;
    private TextView buP;
    private ImageView buQ;

    public m(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.buN = view.findViewById(u.g.container);
        this.bfx = viewEventCenter;
        this.buO = (TextView) view.findViewById(u.g.home_lv_like_forum);
        this.buP = (TextView) view.findViewById(u.g.forum_lv_like_grade);
        this.buQ = (ImageView) view.findViewById(u.g.home_lv_like_forum_delete);
        this.buQ.setOnClickListener(new n(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.x xVar) {
        super.B(xVar);
        if (xVar != null) {
            int level = xVar.getLevel();
            this.buO.setText(xVar.getName());
            if (level == 0) {
                this.buP.setVisibility(4);
                return;
            }
            this.buP.setVisibility(0);
            av.k(this.buP, BitmapHelper.getGradeResourceIdNew(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        av.k(this.buN, u.f.home_like_bg_with_margin);
        if (this.buP.getVisibility() == 0 && getData() != null) {
            av.k(this.buP, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
