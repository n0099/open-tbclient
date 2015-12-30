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
    private ViewEventCenter aUs;
    private View aWp;
    private TextView aWq;
    private TextView aWr;
    private ImageView aWs;

    public m(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aWp = view.findViewById(n.g.container);
        this.aUs = viewEventCenter;
        this.aWq = (TextView) view.findViewById(n.g.home_lv_like_forum);
        this.aWr = (TextView) view.findViewById(n.g.forum_lv_like_grade);
        this.aWs = (ImageView) view.findViewById(n.g.home_lv_like_forum_delete);
        this.aWs.setOnClickListener(new n(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.w wVar) {
        super.B(wVar);
        if (wVar != null) {
            int level = wVar.getLevel();
            this.aWq.setText(wVar.getName());
            if (level == 0) {
                this.aWr.setVisibility(4);
                return;
            }
            this.aWr.setVisibility(0);
            as.i((View) this.aWr, com.baidu.tbadk.core.util.c.ci(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        as.i(this.aWp, n.f.home_like_bg_with_margin);
        if (this.aWr.getVisibility() == 0 && getData() != null) {
            as.i((View) this.aWr, com.baidu.tbadk.core.util.c.ci(getData().getLevel()));
            return true;
        }
        return true;
    }
}
