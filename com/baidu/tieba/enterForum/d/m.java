package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aWA;
    private View aYD;
    private TextView aYE;
    private TextView aYF;
    private ImageView aYG;

    public m(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aYD = view.findViewById(t.g.container);
        this.aWA = viewEventCenter;
        this.aYE = (TextView) view.findViewById(t.g.home_lv_like_forum);
        this.aYF = (TextView) view.findViewById(t.g.forum_lv_like_grade);
        this.aYG = (ImageView) view.findViewById(t.g.home_lv_like_forum_delete);
        this.aYG.setOnClickListener(new n(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.v vVar) {
        super.B(vVar);
        if (vVar != null) {
            int level = vVar.getLevel();
            this.aYE.setText(vVar.getName());
            if (level == 0) {
                this.aYF.setVisibility(4);
                return;
            }
            this.aYF.setVisibility(0);
            ar.k(this.aYF, BitmapHelper.getGradeResourceIdNew(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        ar.k(this.aYD, t.f.home_like_bg_with_margin);
        if (this.aYF.getVisibility() == 0 && getData() != null) {
            ar.k(this.aYF, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
