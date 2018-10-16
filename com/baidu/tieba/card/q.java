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
    private TextView aiy;
    private TextView cNA;
    private TextView cNB;
    private TextView cNC;
    private View cND;
    private View cNE;
    private View cNF;
    private View cNG;
    private com.baidu.tieba.card.data.n cNH;
    private String cNI;
    private String cNJ;
    private TextView cNu;
    private LinearLayout cNv;
    private LinearLayout cNw;
    private LinearLayout cNx;
    private LinearLayout cNy;
    private TextView cNz;
    private View czB;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.home_card_hot_topic_root_view);
        this.aiy = (TextView) view.findViewById(e.g.home_card_topic_title);
        this.cNu = (TextView) view.findViewById(e.g.home_card_topic_more);
        this.cNv = (LinearLayout) view.findViewById(e.g.home_card_topic_group_one);
        this.cNw = (LinearLayout) view.findViewById(e.g.home_card_topic_group_two);
        this.cNx = (LinearLayout) view.findViewById(e.g.home_card_topic_group_three);
        this.cNy = (LinearLayout) view.findViewById(e.g.home_card_topic_group_four);
        this.cNz = (TextView) view.findViewById(e.g.home_card_topic_one);
        this.cNA = (TextView) view.findViewById(e.g.home_card_topic_two);
        this.cNB = (TextView) view.findViewById(e.g.home_card_topic_three);
        this.cNC = (TextView) view.findViewById(e.g.home_card_topic_four);
        this.cND = view.findViewById(e.g.home_top_div);
        this.cNE = view.findViewById(e.g.home_top_topic_div_one);
        this.cNF = view.findViewById(e.g.home_top_topic_div_two);
        this.cNG = view.findViewById(e.g.home_card_top_divider_line);
        this.czB = view.findViewById(e.g.home_card_bottom_divider_line);
        this.cNv.setOnClickListener(this);
        this.cNw.setOnClickListener(this);
        this.cNx.setOnClickListener(this);
        this.cNy.setOnClickListener(this);
        this.cNu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.cNI = str;
        this.cNJ = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int l = com.baidu.adp.lib.g.b.l((String) view.getTag(), -1);
        if (this.cNH != null && com.baidu.tbadk.core.util.v.d(this.cNH.cQH, l) != null) {
            TiebaStatic.log(new am(this.cNJ).ax("obj_locate", String.valueOf(this.cNH.bIr)).ax("obj_name", this.cNH.cQH.get(l).aoy));
            if (l >= 0 && !com.baidu.tbadk.plugins.b.e(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.cNH.cQH.get(l).aox), this.cNH.cQH.get(l).aoy, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.d.cp_bg_line_d);
            al.c(this.aiy, e.d.cp_cont_d, 1);
            al.c(this.cNu, e.d.cp_cont_d, 1);
            al.c(this.cNz, e.d.cp_cont_b, 1);
            al.c(this.cNA, e.d.cp_cont_b, 1);
            al.c(this.cNB, e.d.cp_cont_b, 1);
            al.c(this.cNC, e.d.cp_cont_b, 1);
            al.i(this.cND, e.d.cp_bg_line_b);
            al.i(this.cNE, e.d.cp_bg_line_b);
            al.i(this.cNF, e.d.cp_bg_line_b);
            al.i(this.cNG, e.d.cp_bg_line_c);
            al.i(this.czB, e.d.cp_bg_line_c);
            al.i(this.cNv, e.f.card_topic_click_selector);
            al.i(this.cNw, e.f.card_topic_click_selector);
            al.i(this.cNx, e.f.card_topic_click_selector);
            al.i(this.cNy, e.f.card_topic_click_selector);
            k(this.cNz, 0);
            k(this.cNA, 1);
            k(this.cNB, 2);
            k(this.cNC, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.cQG) || com.baidu.tbadk.core.util.v.I(nVar.cQH) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cNH = nVar;
        this.cNG.setVisibility(this.cNH.cQE ? 0 : 8);
        showBottomLine(this.cNH.cQF);
        this.aiy.setText(this.cNH.cQG.trim());
        j(this.cNz, 0);
        j(this.cNA, 1);
        j(this.cNB, 2);
        j(this.cNC, 3);
        k(this.cNz, 0);
        k(this.cNA, 1);
        k(this.cNB, 2);
        k(this.cNC, 3);
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.cNH.cQH.get(i);
        if (!StringUtils.isNull(mVar.aoy)) {
            textView.setText(mVar.aoy.trim());
        }
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.cNH != null && com.baidu.tbadk.core.util.v.I(this.cNH.cQH) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.d(this.cNH.cQH, i)) != null) {
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
            this.czB.setVisibility(0);
        } else {
            this.czB.setVisibility(8);
        }
    }

    public void jQ(int i) {
        ViewGroup.LayoutParams layoutParams = this.cNG.getLayoutParams();
        layoutParams.height = i;
        this.cNG.setLayoutParams(layoutParams);
    }
}
