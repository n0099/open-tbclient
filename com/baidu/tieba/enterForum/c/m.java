package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.tbadkCore.u, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bHa;
    private View bIp;
    private TextView bIq;
    private TextView bIr;
    private ImageView bIs;

    public m(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bIp = view.findViewById(w.h.container);
        this.bHa = viewEventCenter;
        this.bIq = (TextView) view.findViewById(w.h.home_lv_like_forum);
        this.bIr = (TextView) view.findViewById(w.h.forum_lv_like_grade);
        this.bIs = (ImageView) view.findViewById(w.h.home_lv_like_forum_delete);
        this.bIs.setOnClickListener(new n(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.u uVar) {
        super.E(uVar);
        if (uVar != null) {
            int level = uVar.getLevel();
            this.bIq.setText(uVar.getName());
            if (level == 0) {
                this.bIr.setVisibility(4);
                return;
            }
            this.bIr.setVisibility(0);
            aq.j(this.bIr, BitmapHelper.getGradeResourceIdNew(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        aq.j(this.bIp, w.g.home_like_bg_with_margin);
        if (this.bIr.getVisibility() == 0 && getData() != null) {
            aq.j(this.bIr, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
