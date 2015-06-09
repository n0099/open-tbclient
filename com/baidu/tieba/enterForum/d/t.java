package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.ae, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aEU;
    private View aGh;
    private TextView aGi;
    private TextView aGj;
    private ImageView aGk;

    public t(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aEU = viewEventCenter;
        this.aGh = view.findViewById(com.baidu.tieba.q.container);
        this.aGi = (TextView) view.findViewById(com.baidu.tieba.q.home_lv_like_forum);
        this.aGj = (TextView) view.findViewById(com.baidu.tieba.q.forum_lv_like_grade);
        this.aGk = (ImageView) view.findViewById(com.baidu.tieba.q.home_lv_like_forum_delete);
        this.aGk.setOnClickListener(new u(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: c */
    public void z(com.baidu.tieba.tbadkCore.ae aeVar) {
        super.z(aeVar);
        if (aeVar != null) {
            int level = aeVar.getLevel();
            this.aGi.setText(aeVar.getName());
            if (level == 0) {
                this.aGj.setVisibility(4);
                return;
            }
            this.aGj.setVisibility(0);
            ay.i((View) this.aGj, com.baidu.tbadk.core.util.c.bT(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ay.i(this.aGh, com.baidu.tieba.p.addresslist_item_bg);
        if (this.aGj.getVisibility() == 0 && getData() != null) {
            ay.i((View) this.aGj, com.baidu.tbadk.core.util.c.bT(getData().getLevel()));
            return true;
        }
        return true;
    }
}
