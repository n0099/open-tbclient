package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aLB;
    private View aMP;
    private TextView aMQ;
    private TextView aMR;
    private ImageView aMS;

    public m(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aMP = view.findViewById(i.f.container);
        this.aLB = viewEventCenter;
        this.aMQ = (TextView) view.findViewById(i.f.home_lv_like_forum);
        this.aMR = (TextView) view.findViewById(i.f.forum_lv_like_grade);
        this.aMS = (ImageView) view.findViewById(i.f.home_lv_like_forum_delete);
        this.aMS.setOnClickListener(new n(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.v vVar) {
        super.B(vVar);
        if (vVar != null) {
            int level = vVar.getLevel();
            this.aMQ.setText(vVar.getName());
            if (level == 0) {
                this.aMR.setVisibility(4);
                return;
            }
            this.aMR.setVisibility(0);
            am.i((View) this.aMR, com.baidu.tbadk.core.util.c.ch(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        am.i(this.aMP, i.e.home_like_bg_with_margin);
        if (this.aMR.getVisibility() == 0 && getData() != null) {
            am.i((View) this.aMR, com.baidu.tbadk.core.util.c.ch(getData().getLevel()));
            return true;
        }
        return true;
    }
}
