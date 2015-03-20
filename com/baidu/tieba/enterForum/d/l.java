package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.ae, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aCK;
    private View aDV;
    private TextView aDW;
    private TextView aDX;
    private ImageView aDY;

    public l(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aDV = view.findViewById(com.baidu.tieba.v.container);
        this.aCK = viewEventCenter;
        this.aDW = (TextView) view.findViewById(com.baidu.tieba.v.home_lv_like_forum);
        this.aDX = (TextView) view.findViewById(com.baidu.tieba.v.forum_lv_like_grade);
        this.aDY = (ImageView) view.findViewById(com.baidu.tieba.v.home_lv_like_forum_delete);
        this.aDY.setOnClickListener(new m(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: c */
    public void A(com.baidu.tieba.tbadkCore.ae aeVar) {
        super.A(aeVar);
        if (aeVar != null) {
            int level = aeVar.getLevel();
            this.aDW.setText(aeVar.getName());
            if (level == 0) {
                this.aDX.setVisibility(4);
                return;
            }
            this.aDX.setVisibility(0);
            ba.i((View) this.aDX, com.baidu.tbadk.core.util.c.bQ(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ba.i(this.aDV, com.baidu.tieba.u.home_like_bg_with_margin);
        if (this.aDX.getVisibility() == 0 && getData() != null) {
            ba.i((View) this.aDX, com.baidu.tbadk.core.util.c.bQ(getData().getLevel()));
            return true;
        }
        return true;
    }
}
