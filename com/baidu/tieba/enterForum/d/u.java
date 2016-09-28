package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aPL;
    private View bIr;
    private TextView bIs;
    private TextView bIt;
    private ImageView bIu;

    public u(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aPL = viewEventCenter;
        this.bIr = view.findViewById(r.g.container);
        this.bIs = (TextView) view.findViewById(r.g.home_lv_like_forum);
        this.bIt = (TextView) view.findViewById(r.g.forum_lv_like_grade);
        this.bIu = (ImageView) view.findViewById(r.g.home_lv_like_forum_delete);
        this.bIu.setOnClickListener(new v(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.w wVar) {
        super.E(wVar);
        if (wVar != null) {
            int level = wVar.getLevel();
            this.bIs.setText(wVar.getName());
            if (level == 0) {
                this.bIt.setVisibility(4);
                return;
            }
            this.bIt.setVisibility(0);
            av.k(this.bIt, BitmapHelper.getGradeResourceIdNew(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        av.k(this.bIr, r.f.addresslist_item_bg);
        if (this.bIt.getVisibility() == 0 && getData() != null) {
            av.k(this.bIt, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
