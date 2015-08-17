package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.u, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aMt;
    private View aNH;
    private TextView aNI;
    private TextView aNJ;
    private ImageView aNK;

    public l(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aNH = view.findViewById(i.f.container);
        this.aMt = viewEventCenter;
        this.aNI = (TextView) view.findViewById(i.f.home_lv_like_forum);
        this.aNJ = (TextView) view.findViewById(i.f.forum_lv_like_grade);
        this.aNK = (ImageView) view.findViewById(i.f.home_lv_like_forum_delete);
        this.aNK.setOnClickListener(new m(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void A(com.baidu.tieba.tbadkCore.u uVar) {
        super.A(uVar);
        if (uVar != null) {
            int level = uVar.getLevel();
            this.aNI.setText(uVar.getName());
            if (level == 0) {
                this.aNJ.setVisibility(4);
                return;
            }
            this.aNJ.setVisibility(0);
            al.i((View) this.aNJ, com.baidu.tbadk.core.util.c.cb(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        al.i(this.aNH, i.e.home_like_bg_with_margin);
        if (this.aNJ.getVisibility() == 0 && getData() != null) {
            al.i((View) this.aNJ, com.baidu.tbadk.core.util.c.cb(getData().getLevel()));
            return true;
        }
        return true;
    }
}
