package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bbj;
    private View bdn;
    private TextView bdo;
    private TextView bdp;
    private ImageView bdq;

    public u(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bbj = viewEventCenter;
        this.bdn = view.findViewById(t.g.container);
        this.bdo = (TextView) view.findViewById(t.g.home_lv_like_forum);
        this.bdp = (TextView) view.findViewById(t.g.forum_lv_like_grade);
        this.bdq = (ImageView) view.findViewById(t.g.home_lv_like_forum_delete);
        this.bdq.setOnClickListener(new v(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.v vVar) {
        super.B(vVar);
        if (vVar != null) {
            int level = vVar.getLevel();
            this.bdo.setText(vVar.getName());
            if (level == 0) {
                this.bdp.setVisibility(4);
                return;
            }
            this.bdp.setVisibility(0);
            at.k(this.bdp, BitmapHelper.getGradeResourceIdNew(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        at.k(this.bdn, t.f.addresslist_item_bg);
        if (this.bdp.getVisibility() == 0 && getData() != null) {
            at.k(this.bdp, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
