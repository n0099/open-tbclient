package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aLU;
    private View aNi;
    private TextView aNj;
    private TextView aNk;
    private ImageView aNl;

    public u(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aLU = viewEventCenter;
        this.aNi = view.findViewById(i.f.container);
        this.aNj = (TextView) view.findViewById(i.f.home_lv_like_forum);
        this.aNk = (TextView) view.findViewById(i.f.forum_lv_like_grade);
        this.aNl = (ImageView) view.findViewById(i.f.home_lv_like_forum_delete);
        this.aNl.setOnClickListener(new v(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.v vVar) {
        super.B(vVar);
        if (vVar != null) {
            int level = vVar.getLevel();
            this.aNj.setText(vVar.getName());
            if (level == 0) {
                this.aNk.setVisibility(4);
                return;
            }
            this.aNk.setVisibility(0);
            an.i((View) this.aNk, com.baidu.tbadk.core.util.c.ch(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        an.i(this.aNi, i.e.addresslist_item_bg);
        if (this.aNk.getVisibility() == 0 && getData() != null) {
            an.i((View) this.aNk, com.baidu.tbadk.core.util.c.ch(getData().getLevel()));
            return true;
        }
        return true;
    }
}
