package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aRj;
    private View bro;
    private TextView brp;
    private TextView brq;
    private ImageView brr;

    public m(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bro = view.findViewById(r.g.container);
        this.aRj = viewEventCenter;
        this.brp = (TextView) view.findViewById(r.g.home_lv_like_forum);
        this.brq = (TextView) view.findViewById(r.g.forum_lv_like_grade);
        this.brr = (ImageView) view.findViewById(r.g.home_lv_like_forum_delete);
        this.brr.setOnClickListener(new n(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.v vVar) {
        super.E(vVar);
        if (vVar != null) {
            int level = vVar.getLevel();
            this.brp.setText(vVar.getName());
            if (level == 0) {
                this.brq.setVisibility(4);
                return;
            }
            this.brq.setVisibility(0);
            ar.k(this.brq, BitmapHelper.getGradeResourceIdNew(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        ar.k(this.bro, r.f.home_like_bg_with_margin);
        if (this.brq.getVisibility() == 0 && getData() != null) {
            ar.k(this.brq, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
