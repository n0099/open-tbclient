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
    private ViewEventCenter aUs;
    private View aWL;
    private TextView aWO;
    private TextView aWP;
    private TextView aWQ;
    private TbImageView aWR;
    final View.OnLongClickListener aWS;
    final View.OnClickListener mClickListener;

    public y(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.mClickListener = new z(this);
        this.aWS = new aa(this);
        this.aUs = viewEventCenter;
        this.aWL = view.findViewById(n.g.container);
        this.aWO = (TextView) view.findViewById(n.g.forum_icon_sign);
        this.aWP = (TextView) view.findViewById(n.g.home_lv_like_forum);
        this.aWQ = (TextView) view.findViewById(n.g.forum_lv_like_grade);
        this.aWR = (TbImageView) view.findViewById(n.g.home_lv_like_forum_icon);
        this.aWR.setDefaultBgResource(n.d.cp_cont_e);
        this.aWR.setDefaultResource(n.f.icon_default_ba_120);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: c */
    public void B(com.baidu.tieba.tbadkCore.w wVar) {
        super.B(wVar);
        if (wVar != null) {
            int level = wVar.getLevel();
            this.aWP.setText(wVar.getName());
            if (wVar.aEx() == 0) {
                this.aWO.setVisibility(8);
            } else {
                this.aWO.setVisibility(0);
            }
            if (level == 0) {
                this.aWQ.setVisibility(4);
            } else {
                this.aWQ.setVisibility(0);
                as.i((View) this.aWQ, com.baidu.tbadk.core.util.c.ci(level));
            }
            this.aWR.d(wVar.getAvatar(), 10, false);
            this.aWL.setOnClickListener(this.mClickListener);
            this.aWL.setOnLongClickListener(this.aWS);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        as.i(this.aWL, n.f.addresslist_item_bg);
        this.aWR.invalidate();
        if (this.aWQ.isShown() && getData() != null) {
            as.i((View) this.aWQ, com.baidu.tbadk.core.util.c.ci(getData().getLevel()));
            return true;
        }
        return true;
    }
}
