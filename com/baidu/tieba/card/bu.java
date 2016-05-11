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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bu extends a<com.baidu.tieba.card.a.p> {
    private TextView KC;
    private View aOf;
    private TextView aQR;
    private LinearLayout aQS;
    private LinearLayout aQT;
    private LinearLayout aQU;
    private LinearLayout aQV;
    private TextView aQW;
    private TextView aQX;
    private TextView aQY;
    private TextView aQZ;
    private View aRa;
    private View aRb;
    private View aRc;
    private com.baidu.tieba.card.a.p aRd;
    private String aRe;
    private String aRf;
    private View bottomLine;
    private View mRootView;

    public bu(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        R(getView());
    }

    private void R(View view) {
        this.mRootView = view.findViewById(t.g.home_card_hot_topic_root_view);
        this.KC = (TextView) view.findViewById(t.g.home_card_topic_title);
        this.aQR = (TextView) view.findViewById(t.g.home_card_topic_more);
        this.aQS = (LinearLayout) view.findViewById(t.g.home_card_topic_group_one);
        this.aQT = (LinearLayout) view.findViewById(t.g.home_card_topic_group_two);
        this.aQU = (LinearLayout) view.findViewById(t.g.home_card_topic_group_three);
        this.aQV = (LinearLayout) view.findViewById(t.g.home_card_topic_group_four);
        this.aQW = (TextView) view.findViewById(t.g.home_card_topic_one);
        this.aQX = (TextView) view.findViewById(t.g.home_card_topic_two);
        this.aQY = (TextView) view.findViewById(t.g.home_card_topic_three);
        this.aQZ = (TextView) view.findViewById(t.g.home_card_topic_four);
        this.aRa = view.findViewById(t.g.home_top_div);
        this.aRb = view.findViewById(t.g.home_top_topic_div_one);
        this.aRc = view.findViewById(t.g.home_top_topic_div_two);
        this.aOf = view.findViewById(t.g.home_card_top_divider_line);
        this.bottomLine = view.findViewById(t.g.home_card_bottom_divider_line);
        this.aQS.setOnClickListener(this);
        this.aQT.setOnClickListener(this);
        this.aQU.setOnClickListener(this);
        this.aQV.setOnClickListener(this);
        this.aQR.setOnClickListener(new bv(this));
    }

    public void ax(String str, String str2) {
        this.aRe = str;
        this.aRf = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int JN() {
        return t.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g = com.baidu.adp.lib.h.b.g((String) view.getTag(), -1);
        if (this.aRd != null && com.baidu.tbadk.core.util.y.c(this.aRd.aSp, g) != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw(this.aRf).ac("obj_locate", String.valueOf(this.aRd.aSq)).ac("obj_name", this.aRd.aSp.get(g).Pu));
            if (g >= 0 && !com.baidu.tbadk.plugins.a.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.aRd.aSp.get(g).Pt), this.aRd.aSp.get(g).Pu, "")));
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.mRootView, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.c(this.KC, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(this.aQR, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(this.aQW, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(this.aQX, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(this.aQY, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(this.aQZ, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.k(this.aRa, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(this.aRb, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(this.aRc, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(this.aOf, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.k(this.bottomLine, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.k(this.aQS, t.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.at.k(this.aQT, t.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.at.k(this.aQU, t.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.at.k(this.aQV, t.f.card_topic_click_selector);
            o(this.aQW, 0);
            o(this.aQX, 1);
            o(this.aQY, 2);
            o(this.aQZ, 3);
        }
        this.mSkinType = i;
    }

    public void a(com.baidu.tieba.card.a.p pVar) {
        if (pVar == null || StringUtils.isNull(pVar.aSo) || com.baidu.tbadk.core.util.y.r(pVar.aSp) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.aRd = pVar;
        this.aOf.setVisibility(this.aRd.aRD ? 0 : 8);
        this.KC.setText(this.aRd.aSo.trim());
        n(this.aQW, 0);
        n(this.aQX, 1);
        n(this.aQY, 2);
        n(this.aQZ, 3);
        o(this.aQW, 0);
        o(this.aQX, 1);
        o(this.aQY, 2);
        o(this.aQZ, 3);
    }

    private void n(TextView textView, int i) {
        textView.setText(this.aRd.aSp.get(i).Pu.trim());
    }

    private void o(TextView textView, int i) {
        com.baidu.tieba.card.a.o oVar;
        if (this.aRd != null && com.baidu.tbadk.core.util.y.r(this.aRd.aSp) >= 4 && (oVar = (com.baidu.tieba.card.a.o) com.baidu.tbadk.core.util.y.c(this.aRd.aSp, i)) != null) {
            switch (oVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_hottopic_tuijian), (Drawable) null);
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

    public void fw(int i) {
        ViewGroup.LayoutParams layoutParams = this.aOf.getLayoutParams();
        layoutParams.height = i;
        this.aOf.setLayoutParams(layoutParams);
    }
}
