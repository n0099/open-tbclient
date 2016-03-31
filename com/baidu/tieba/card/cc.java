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
public class cc extends a<com.baidu.tieba.card.a.x> {
    private View aRI;
    private LinearLayout aUA;
    private LinearLayout aUB;
    private LinearLayout aUC;
    private TextView aUD;
    private TextView aUE;
    private TextView aUF;
    private TextView aUG;
    private View aUH;
    private View aUI;
    private View aUJ;
    private View aUK;
    private com.baidu.tieba.card.a.x aUL;
    private String aUM;
    private String aUN;
    private TextView aUx;
    private TextView aUy;
    private LinearLayout aUz;
    private View mRootView;

    public cc(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        P(getView());
    }

    private void P(View view) {
        this.mRootView = view.findViewById(t.g.home_card_hot_topic_root_view);
        this.aUx = (TextView) view.findViewById(t.g.home_card_topic_title);
        this.aUy = (TextView) view.findViewById(t.g.home_card_topic_more);
        this.aUz = (LinearLayout) view.findViewById(t.g.home_card_topic_group_one);
        this.aUA = (LinearLayout) view.findViewById(t.g.home_card_topic_group_two);
        this.aUB = (LinearLayout) view.findViewById(t.g.home_card_topic_group_three);
        this.aUC = (LinearLayout) view.findViewById(t.g.home_card_topic_group_four);
        this.aUD = (TextView) view.findViewById(t.g.home_card_topic_one);
        this.aUE = (TextView) view.findViewById(t.g.home_card_topic_two);
        this.aUF = (TextView) view.findViewById(t.g.home_card_topic_three);
        this.aUG = (TextView) view.findViewById(t.g.home_card_topic_four);
        this.aUH = view.findViewById(t.g.home_top_div);
        this.aUI = view.findViewById(t.g.home_top_topic_div_one);
        this.aUJ = view.findViewById(t.g.home_top_topic_div_two);
        this.aRI = view.findViewById(t.g.home_card_top_divider_line);
        this.aUK = view.findViewById(t.g.home_card_bottom_divider_line);
        this.aUz.setOnClickListener(this);
        this.aUA.setOnClickListener(this);
        this.aUB.setOnClickListener(this);
        this.aUC.setOnClickListener(this);
        this.aUy.setOnClickListener(new cd(this));
    }

    public void at(String str, String str2) {
        this.aUM = str;
        this.aUN = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int Le() {
        return t.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g = com.baidu.adp.lib.h.b.g((String) view.getTag(), -1);
        if (this.aUL != null && com.baidu.tbadk.core.util.y.b(this.aUL.aWv, g) != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw(this.aUN).ac("obj_locate", String.valueOf(this.aUL.aWw)).ac("obj_name", this.aUL.aWv.get(g).Uv));
            if (g >= 0) {
                Lb().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(Lb().getPageActivity()).createNormalConfig(String.valueOf(this.aUL.aWv.get(g).Uu), this.aUL.aWv.get(g).Uv, "")));
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.mRootView, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.at.b(this.aUx, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.b(this.aUy, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.b(this.aUD, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.b(this.aUE, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.b(this.aUF, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.b(this.aUG, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.k(this.aUH, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(this.aUI, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(this.aUJ, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(this.aRI, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.k(this.aUK, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.k(this.aUz, t.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.at.k(this.aUA, t.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.at.k(this.aUB, t.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.at.k(this.aUC, t.f.card_topic_click_selector);
            o(this.aUD, 0);
            o(this.aUE, 1);
            o(this.aUF, 2);
            o(this.aUG, 3);
        }
        this.mSkinType = i;
    }

    public void a(com.baidu.tieba.card.a.x xVar) {
        if (xVar == null || StringUtils.isNull(xVar.aWu) || com.baidu.tbadk.core.util.y.p(xVar.aWv) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.aUL = xVar;
        this.aRI.setVisibility(this.aUL.aVy ? 0 : 8);
        this.aUx.setText(this.aUL.aWu.trim());
        n(this.aUD, 0);
        n(this.aUE, 1);
        n(this.aUF, 2);
        n(this.aUG, 3);
        o(this.aUD, 0);
        o(this.aUE, 1);
        o(this.aUF, 2);
        o(this.aUG, 3);
    }

    private void n(TextView textView, int i) {
        textView.setText(this.aUL.aWv.get(i).Uv.trim());
    }

    private void o(TextView textView, int i) {
        com.baidu.tieba.card.a.w wVar;
        if (this.aUL != null && com.baidu.tbadk.core.util.y.p(this.aUL.aWv) >= 4 && (wVar = (com.baidu.tieba.card.a.w) com.baidu.tbadk.core.util.y.b(this.aUL.aWv, i)) != null) {
            switch (wVar.tag) {
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

    public void cb(boolean z) {
        if (z) {
            this.aUK.setVisibility(0);
        } else {
            this.aUK.setVisibility(8);
        }
    }

    public void fO(int i) {
        ViewGroup.LayoutParams layoutParams = this.aRI.getLayoutParams();
        layoutParams.height = i;
        this.aRI.setLayoutParams(layoutParams);
    }
}
