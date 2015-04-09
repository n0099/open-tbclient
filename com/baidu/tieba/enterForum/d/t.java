package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.tbadkCore.ae, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aCS;
    private View aEd;
    private TextView aEe;
    private TextView aEf;
    private ImageView aEg;

    public t(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aCS = viewEventCenter;
        this.aEd = view.findViewById(com.baidu.tieba.v.container);
        this.aEe = (TextView) view.findViewById(com.baidu.tieba.v.home_lv_like_forum);
        this.aEf = (TextView) view.findViewById(com.baidu.tieba.v.forum_lv_like_grade);
        this.aEg = (ImageView) view.findViewById(com.baidu.tieba.v.home_lv_like_forum_delete);
        this.aEg.setOnClickListener(new u(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: c */
    public void A(com.baidu.tieba.tbadkCore.ae aeVar) {
        super.A(aeVar);
        if (aeVar != null) {
            int level = aeVar.getLevel();
            this.aEe.setText(aeVar.getName());
            if (level == 0) {
                this.aEf.setVisibility(4);
                return;
            }
            this.aEf.setVisibility(0);
            ba.i((View) this.aEf, com.baidu.tbadk.core.util.c.bQ(level));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        ba.i(this.aEd, com.baidu.tieba.u.addresslist_item_bg);
        if (this.aEf.getVisibility() == 0 && getData() != null) {
            ba.i((View) this.aEf, com.baidu.tbadk.core.util.c.bQ(getData().getLevel()));
            return true;
        }
        return true;
    }
}
