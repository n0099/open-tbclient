package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.ae, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aET;
    private View aGg;
    private TextView aGh;
    private TextView aGi;
    private ImageView aGj;

    public l(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aGg = view.findViewById(com.baidu.tieba.q.container);
        this.aET = viewEventCenter;
        this.aGh = (TextView) view.findViewById(com.baidu.tieba.q.home_lv_like_forum);
        this.aGi = (TextView) view.findViewById(com.baidu.tieba.q.forum_lv_like_grade);
        this.aGj = (ImageView) view.findViewById(com.baidu.tieba.q.home_lv_like_forum_delete);
        this.aGj.setOnClickListener(new m(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: c */
    public void z(com.baidu.tieba.tbadkCore.ae aeVar) {
        super.z(aeVar);
        if (aeVar != null) {
            int level = aeVar.getLevel();
            this.aGh.setText(aeVar.getName());
            if (level == 0) {
                this.aGi.setVisibility(4);
                return;
            }
            this.aGi.setVisibility(0);
            ay.i((View) this.aGi, com.baidu.tbadk.core.util.c.bT(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ay.i(this.aGg, com.baidu.tieba.p.home_like_bg_with_margin);
        if (this.aGi.getVisibility() == 0 && getData() != null) {
            ay.i((View) this.aGi, com.baidu.tbadk.core.util.c.bT(getData().getLevel()));
            return true;
        }
        return true;
    }
}
