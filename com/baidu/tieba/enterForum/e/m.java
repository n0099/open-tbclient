package com.baidu.tieba.enterForum.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aOw;
    private View bIp;
    private TextView bIq;
    private TextView bIr;
    private ImageView bIs;

    public m(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bIp = view.findViewById(t.g.container);
        this.aOw = viewEventCenter;
        this.bIq = (TextView) view.findViewById(t.g.home_lv_like_forum);
        this.bIr = (TextView) view.findViewById(t.g.forum_lv_like_grade);
        this.bIs = (ImageView) view.findViewById(t.g.home_lv_like_forum_delete);
        this.bIs.setOnClickListener(new n(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.w wVar) {
        super.E(wVar);
        if (wVar != null) {
            int level = wVar.getLevel();
            this.bIq.setText(wVar.getName());
            if (level == 0) {
                this.bIr.setVisibility(4);
                return;
            }
            this.bIr.setVisibility(0);
            av.k(this.bIr, BitmapHelper.getGradeResourceIdNew(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        av.k(this.bIp, t.f.home_like_bg_with_margin);
        if (this.bIr.getVisibility() == 0 && getData() != null) {
            av.k(this.bIr, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
