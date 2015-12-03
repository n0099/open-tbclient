package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.tbadkCore.w, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aQB;
    private View aSJ;
    private TextView aSM;
    private TextView aSN;
    private TextView aSO;
    private TbImageView aSP;
    final View.OnLongClickListener aSQ;
    final View.OnClickListener mClickListener;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mClickListener = new z(this);
        this.aSQ = new aa(this);
        this.aQB = viewEventCenter;
        this.aSJ = view.findViewById(n.f.container);
        this.aSM = (TextView) view.findViewById(n.f.forum_icon_sign);
        this.aSN = (TextView) view.findViewById(n.f.home_lv_like_forum);
        this.aSO = (TextView) view.findViewById(n.f.forum_lv_like_grade);
        this.aSP = (TbImageView) view.findViewById(n.f.home_lv_like_forum_icon);
        this.aSP.setDefaultBgResource(n.c.cp_cont_e);
        this.aSP.setDefaultResource(n.e.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.w wVar) {
        super.B(wVar);
        if (wVar != null) {
            int level = wVar.getLevel();
            this.aSN.setText(wVar.getName());
            if (wVar.aCp() == 0) {
                this.aSM.setVisibility(8);
            } else {
                this.aSM.setVisibility(0);
            }
            if (level == 0) {
                this.aSO.setVisibility(4);
            } else {
                this.aSO.setVisibility(0);
                as.i((View) this.aSO, com.baidu.tbadk.core.util.c.cp(level));
            }
            this.aSP.d(wVar.getAvatar(), 10, false);
            this.aSJ.setOnClickListener(this.mClickListener);
            this.aSJ.setOnLongClickListener(this.aSQ);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        as.i(this.aSJ, n.e.addresslist_item_bg);
        this.aSP.invalidate();
        if (this.aSO.isShown() && getData() != null) {
            as.i((View) this.aSO, com.baidu.tbadk.core.util.c.cp(getData().getLevel()));
            return true;
        }
        return true;
    }
}
