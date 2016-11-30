package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aRS;
    private View bLk;
    private TextView bLl;
    private TextView bLm;
    private ImageView bLn;

    public m(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bLk = view.findViewById(r.g.container);
        this.aRS = viewEventCenter;
        this.bLl = (TextView) view.findViewById(r.g.home_lv_like_forum);
        this.bLm = (TextView) view.findViewById(r.g.forum_lv_like_grade);
        this.bLn = (ImageView) view.findViewById(r.g.home_lv_like_forum_delete);
        this.bLn.setOnClickListener(new n(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.w wVar) {
        super.E(wVar);
        if (wVar != null) {
            int level = wVar.getLevel();
            this.bLl.setText(wVar.getName());
            if (level == 0) {
                this.bLm.setVisibility(4);
                return;
            }
            this.bLm.setVisibility(0);
            at.k(this.bLm, BitmapHelper.getGradeResourceIdNew(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        at.k(this.bLk, r.f.home_like_bg_with_margin);
        if (this.bLm.getVisibility() == 0 && getData() != null) {
            at.k(this.bLm, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
