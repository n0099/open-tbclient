package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aQB;
    private View aSn;
    private TextView aSo;
    private TextView aSp;
    private ImageView aSq;

    public m(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aSn = view.findViewById(n.f.container);
        this.aQB = viewEventCenter;
        this.aSo = (TextView) view.findViewById(n.f.home_lv_like_forum);
        this.aSp = (TextView) view.findViewById(n.f.forum_lv_like_grade);
        this.aSq = (ImageView) view.findViewById(n.f.home_lv_like_forum_delete);
        this.aSq.setOnClickListener(new n(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.w wVar) {
        super.B(wVar);
        if (wVar != null) {
            int level = wVar.getLevel();
            this.aSo.setText(wVar.getName());
            if (level == 0) {
                this.aSp.setVisibility(4);
                return;
            }
            this.aSp.setVisibility(0);
            as.i((View) this.aSp, com.baidu.tbadk.core.util.c.cp(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        as.i(this.aSn, n.e.home_like_bg_with_margin);
        if (this.aSp.getVisibility() == 0 && getData() != null) {
            as.i((View) this.aSp, com.baidu.tbadk.core.util.c.cp(getData().getLevel()));
            return true;
        }
        return true;
    }
}
