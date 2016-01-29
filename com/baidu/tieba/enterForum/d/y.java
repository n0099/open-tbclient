package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    final View.OnClickListener OS;
    private ViewEventCenter aWA;
    private View aYZ;
    private TextView aZc;
    private TextView aZd;
    private TextView aZe;
    private TbImageView aZf;
    final View.OnLongClickListener aZg;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.OS = new z(this);
        this.aZg = new aa(this);
        this.aWA = viewEventCenter;
        this.aYZ = view.findViewById(t.g.container);
        this.aZc = (TextView) view.findViewById(t.g.forum_icon_sign);
        this.aZd = (TextView) view.findViewById(t.g.home_lv_like_forum);
        this.aZe = (TextView) view.findViewById(t.g.forum_lv_like_grade);
        this.aZf = (TbImageView) view.findViewById(t.g.home_lv_like_forum_icon);
        this.aZf.setDefaultBgResource(t.d.cp_cont_e);
        this.aZf.setDefaultResource(t.f.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.v vVar) {
        super.B(vVar);
        if (vVar != null) {
            int level = vVar.getLevel();
            this.aZd.setText(vVar.getName());
            if (vVar.aLD() == 0) {
                this.aZc.setVisibility(8);
            } else {
                this.aZc.setVisibility(0);
            }
            if (level == 0) {
                this.aZe.setVisibility(4);
            } else {
                this.aZe.setVisibility(0);
                ar.k(this.aZe, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.aZf.d(vVar.getAvatar(), 10, false);
            this.aYZ.setOnClickListener(this.OS);
            this.aYZ.setOnLongClickListener(this.aZg);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        ar.k(this.aYZ, t.f.addresslist_item_bg);
        this.aZf.invalidate();
        if (this.aZe.isShown() && getData() != null) {
            ar.k(this.aZe, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
