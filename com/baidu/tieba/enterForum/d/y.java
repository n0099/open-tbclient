package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.v, com.baidu.tbadk.mvc.d.b> {
    final View.OnClickListener OZ;
    private ViewEventCenter bbj;
    private View bdJ;
    private TextView bdM;
    private TextView bdN;
    private TextView bdO;
    private TbImageView bdP;
    final View.OnLongClickListener bdQ;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.OZ = new z(this);
        this.bdQ = new aa(this);
        this.bbj = viewEventCenter;
        this.bdJ = view.findViewById(t.g.container);
        this.bdM = (TextView) view.findViewById(t.g.forum_icon_sign);
        this.bdN = (TextView) view.findViewById(t.g.home_lv_like_forum);
        this.bdO = (TextView) view.findViewById(t.g.forum_lv_like_grade);
        this.bdP = (TbImageView) view.findViewById(t.g.home_lv_like_forum_icon);
        this.bdP.setDefaultBgResource(t.d.cp_bg_line_e);
        this.bdP.setDefaultResource(t.f.transparent_bg);
        this.bdP.setDefaultErrorResource(t.f.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.v vVar) {
        super.B(vVar);
        if (vVar != null) {
            int level = vVar.getLevel();
            this.bdN.setText(vVar.getName());
            if (vVar.aSw() == 0) {
                this.bdM.setVisibility(8);
            } else {
                this.bdM.setVisibility(0);
            }
            if (level == 0) {
                this.bdO.setVisibility(4);
            } else {
                this.bdO.setVisibility(0);
                at.k(this.bdO, BitmapHelper.getGradeResourceIdNew(level));
            }
            this.bdP.c(vVar.getAvatar(), 10, false);
            this.bdJ.setOnClickListener(this.OZ);
            this.bdJ.setOnLongClickListener(this.bdQ);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        at.k(this.bdJ, t.f.addresslist_item_bg);
        this.bdP.invalidate();
        if (this.bdO.isShown() && getData() != null) {
            at.k(this.bdO, BitmapHelper.getGradeResourceIdNew(getData().getLevel()));
            return true;
        }
        return true;
    }
}
