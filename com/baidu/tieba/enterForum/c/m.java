package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.tbadkCore.u, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bxK;
    private View byZ;
    private TextView bza;
    private TextView bzb;
    private ImageView bzc;

    public m(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.byZ = view.findViewById(r.h.container);
        this.bxK = viewEventCenter;
        this.bza = (TextView) view.findViewById(r.h.home_lv_like_forum);
        this.bzb = (TextView) view.findViewById(r.h.forum_lv_like_grade);
        this.bzc = (ImageView) view.findViewById(r.h.home_lv_like_forum_delete);
        this.bzc.setOnClickListener(new n(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: c */
    public void E(com.baidu.tieba.tbadkCore.u uVar) {
        super.E(uVar);
        if (uVar != null) {
            int level = uVar.getLevel();
            this.bza.setText(uVar.getName());
            if (level == 0) {
                this.bzb.setVisibility(4);
                return;
            }
            this.bzb.setVisibility(0);
            ap.j((View) this.bzb, BitmapHelper.getGradeResourceIdNew(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        ap.j(this.byZ, r.g.home_like_bg_with_margin);
        if (this.bzb.getVisibility() == 0 && getData() != null) {
            ap.j((View) this.bzb, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
