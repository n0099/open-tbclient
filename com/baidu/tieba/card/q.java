package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class q extends a<com.baidu.tieba.card.data.n> {
    private TextView anp;
    private View cGm;
    private TextView cYI;
    private LinearLayout cYJ;
    private LinearLayout cYK;
    private LinearLayout cYL;
    private LinearLayout cYM;
    private TextView cYN;
    private TextView cYO;
    private TextView cYP;
    private TextView cYQ;
    private View cYR;
    private View cYS;
    private View cYT;
    private View cYU;
    private com.baidu.tieba.card.data.n cYV;
    private String cYW;
    private String cYX;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.home_card_hot_topic_root_view);
        this.anp = (TextView) view.findViewById(e.g.home_card_topic_title);
        this.cYI = (TextView) view.findViewById(e.g.home_card_topic_more);
        this.cYJ = (LinearLayout) view.findViewById(e.g.home_card_topic_group_one);
        this.cYK = (LinearLayout) view.findViewById(e.g.home_card_topic_group_two);
        this.cYL = (LinearLayout) view.findViewById(e.g.home_card_topic_group_three);
        this.cYM = (LinearLayout) view.findViewById(e.g.home_card_topic_group_four);
        this.cYN = (TextView) view.findViewById(e.g.home_card_topic_one);
        this.cYO = (TextView) view.findViewById(e.g.home_card_topic_two);
        this.cYP = (TextView) view.findViewById(e.g.home_card_topic_three);
        this.cYQ = (TextView) view.findViewById(e.g.home_card_topic_four);
        this.cYR = view.findViewById(e.g.home_top_div);
        this.cYS = view.findViewById(e.g.home_top_topic_div_one);
        this.cYT = view.findViewById(e.g.home_top_topic_div_two);
        this.cYU = view.findViewById(e.g.home_card_top_divider_line);
        this.cGm = view.findViewById(e.g.home_card_bottom_divider_line);
        this.cYJ.setOnClickListener(this);
        this.cYK.setOnClickListener(this);
        this.cYL.setOnClickListener(this);
        this.cYM.setOnClickListener(this);
        this.cYI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.cYW = str;
        this.cYX = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int l = com.baidu.adp.lib.g.b.l((String) view.getTag(), -1);
        if (this.cYV != null && com.baidu.tbadk.core.util.v.d(this.cYV.dbY, l) != null) {
            TiebaStatic.log(new am(this.cYX).aB("obj_locate", String.valueOf(this.cYV.locate)).aB("obj_name", this.cYV.dbY.get(l).ato));
            if (l >= 0 && !com.baidu.tbadk.plugins.b.e(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.cYV.dbY.get(l).atn), this.cYV.dbY.get(l).ato, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.d.cp_bg_line_d);
            al.c(this.anp, e.d.cp_cont_d, 1);
            al.c(this.cYI, e.d.cp_cont_d, 1);
            al.c(this.cYN, e.d.cp_cont_b, 1);
            al.c(this.cYO, e.d.cp_cont_b, 1);
            al.c(this.cYP, e.d.cp_cont_b, 1);
            al.c(this.cYQ, e.d.cp_cont_b, 1);
            al.i(this.cYR, e.d.cp_bg_line_b);
            al.i(this.cYS, e.d.cp_bg_line_b);
            al.i(this.cYT, e.d.cp_bg_line_b);
            al.i(this.cYU, e.d.cp_bg_line_c);
            al.i(this.cGm, e.d.cp_bg_line_c);
            al.i(this.cYJ, e.f.card_topic_click_selector);
            al.i(this.cYK, e.f.card_topic_click_selector);
            al.i(this.cYL, e.f.card_topic_click_selector);
            al.i(this.cYM, e.f.card_topic_click_selector);
            l(this.cYN, 0);
            l(this.cYO, 1);
            l(this.cYP, 2);
            l(this.cYQ, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.dbX) || com.baidu.tbadk.core.util.v.H(nVar.dbY) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cYV = nVar;
        this.cYU.setVisibility(this.cYV.dbV ? 0 : 8);
        showBottomLine(this.cYV.dbW);
        this.anp.setText(this.cYV.dbX.trim());
        k(this.cYN, 0);
        k(this.cYO, 1);
        k(this.cYP, 2);
        k(this.cYQ, 3);
        l(this.cYN, 0);
        l(this.cYO, 1);
        l(this.cYP, 2);
        l(this.cYQ, 3);
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.cYV.dbY.get(i);
        if (!StringUtils.isNull(mVar.ato)) {
            textView.setText(mVar.ato.trim());
        }
    }

    private void l(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.cYV != null && com.baidu.tbadk.core.util.v.H(this.cYV.dbY) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.d(this.cYV.dbY, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.cGm.setVisibility(0);
        } else {
            this.cGm.setVisibility(8);
        }
    }

    public void kM(int i) {
        ViewGroup.LayoutParams layoutParams = this.cYU.getLayoutParams();
        layoutParams.height = i;
        this.cYU.setLayoutParams(layoutParams);
    }
}
