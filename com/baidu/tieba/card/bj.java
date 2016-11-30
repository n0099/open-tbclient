package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bj extends a<com.baidu.tieba.card.data.q> {
    private TextView MN;
    private TextView bdS;
    private LinearLayout bdT;
    private LinearLayout bdU;
    private LinearLayout bdV;
    private LinearLayout bdW;
    private TextView bdX;
    private TextView bdY;
    private TextView bdZ;
    private TextView bea;
    private View beb;
    private View bec;
    private View bed;
    private View bee;
    private com.baidu.tieba.card.data.q bef;
    private String beg;
    private String beh;
    private View bottomLine;
    private View mRootView;

    public bj(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        W(getView());
    }

    private void W(View view) {
        this.mRootView = view.findViewById(r.g.home_card_hot_topic_root_view);
        this.MN = (TextView) view.findViewById(r.g.home_card_topic_title);
        this.bdS = (TextView) view.findViewById(r.g.home_card_topic_more);
        this.bdT = (LinearLayout) view.findViewById(r.g.home_card_topic_group_one);
        this.bdU = (LinearLayout) view.findViewById(r.g.home_card_topic_group_two);
        this.bdV = (LinearLayout) view.findViewById(r.g.home_card_topic_group_three);
        this.bdW = (LinearLayout) view.findViewById(r.g.home_card_topic_group_four);
        this.bdX = (TextView) view.findViewById(r.g.home_card_topic_one);
        this.bdY = (TextView) view.findViewById(r.g.home_card_topic_two);
        this.bdZ = (TextView) view.findViewById(r.g.home_card_topic_three);
        this.bea = (TextView) view.findViewById(r.g.home_card_topic_four);
        this.beb = view.findViewById(r.g.home_top_div);
        this.bec = view.findViewById(r.g.home_top_topic_div_one);
        this.bed = view.findViewById(r.g.home_top_topic_div_two);
        this.bee = view.findViewById(r.g.home_card_top_divider_line);
        this.bottomLine = view.findViewById(r.g.home_card_bottom_divider_line);
        this.bdT.setOnClickListener(this);
        this.bdU.setOnClickListener(this);
        this.bdV.setOnClickListener(this);
        this.bdW.setOnClickListener(this);
        this.bdS.setOnClickListener(new bk(this));
    }

    public void ay(String str, String str2) {
        this.beg = str;
        this.beh = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g = com.baidu.adp.lib.h.b.g((String) view.getTag(), -1);
        if (this.bef != null && com.baidu.tbadk.core.util.x.c(this.bef.bfD, g) != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.av(this.beh).ab("obj_locate", String.valueOf(this.bef.bfE)).ab("obj_name", this.bef.bfD.get(g).To));
            if (g >= 0 && !com.baidu.tbadk.plugins.a.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.bef.bfD.get(g).Tn), this.bef.bfD.get(g).To, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.mRootView, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.c(this.MN, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(this.bdS, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(this.bdX, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(this.bdY, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(this.bdZ, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(this.bea, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.k(this.beb, r.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(this.bec, r.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(this.bed, r.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(this.bee, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.k(this.bottomLine, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.k(this.bdT, r.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.at.k(this.bdU, r.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.at.k(this.bdV, r.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.at.k(this.bdW, r.f.card_topic_click_selector);
            o(this.bdX, 0);
            o(this.bdY, 1);
            o(this.bdZ, 2);
            o(this.bea, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.q qVar) {
        if (qVar == null || StringUtils.isNull(qVar.bfC) || com.baidu.tbadk.core.util.x.s(qVar.bfD) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.bef = qVar;
        this.bee.setVisibility(this.bef.bfA ? 0 : 8);
        showBottomLine(this.bef.bfB);
        this.MN.setText(this.bef.bfC.trim());
        n(this.bdX, 0);
        n(this.bdY, 1);
        n(this.bdZ, 2);
        n(this.bea, 3);
        o(this.bdX, 0);
        o(this.bdY, 1);
        o(this.bdZ, 2);
        o(this.bea, 3);
    }

    private void n(TextView textView, int i) {
        textView.setText(this.bef.bfD.get(i).To.trim());
    }

    private void o(TextView textView, int i) {
        com.baidu.tieba.card.data.p pVar;
        if (this.bef != null && com.baidu.tbadk.core.util.x.s(this.bef.bfD) >= 4 && (pVar = (com.baidu.tieba.card.data.p) com.baidu.tbadk.core.util.x.c(this.bef.bfD, i)) != null) {
            switch (pVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.bottomLine.setVisibility(0);
        } else {
            this.bottomLine.setVisibility(8);
        }
    }

    public void gj(int i) {
        ViewGroup.LayoutParams layoutParams = this.bee.getLayoutParams();
        layoutParams.height = i;
        this.bee.setLayoutParams(layoutParams);
    }
}
