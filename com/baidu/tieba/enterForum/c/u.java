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
public class u extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.tbadkCore.u, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bEQ;
    private View bGf;
    private TextView bGg;
    private TextView bGh;
    private ImageView bGi;

    public u(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bEQ = viewEventCenter;
        this.bGf = view.findViewById(w.h.container);
        this.bGg = (TextView) view.findViewById(w.h.home_lv_like_forum);
        this.bGh = (TextView) view.findViewById(w.h.forum_lv_like_grade);
        this.bGi = (ImageView) view.findViewById(w.h.home_lv_like_forum_delete);
        this.bGi.setOnClickListener(new v(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.u uVar) {
        super.E(uVar);
        if (uVar != null) {
            int level = uVar.getLevel();
            this.bGg.setText(uVar.getName());
            if (level == 0) {
                this.bGh.setVisibility(4);
                return;
            }
            this.bGh.setVisibility(0);
            aq.j(this.bGh, BitmapHelper.getGradeResourceIdNew(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        aq.j(this.bGf, w.g.addresslist_item_bg);
        if (this.bGh.getVisibility() == 0 && getData() != null) {
            aq.j(this.bGh, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
