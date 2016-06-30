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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bt extends a<com.baidu.tieba.card.a.q> {
    private TextView KC;
    private View aRC;
    private String aUA;
    private String aUB;
    private TextView aUn;
    private LinearLayout aUo;
    private LinearLayout aUp;
    private LinearLayout aUq;
    private LinearLayout aUr;
    private TextView aUs;
    private TextView aUt;
    private TextView aUu;
    private TextView aUv;
    private View aUw;
    private View aUx;
    private View aUy;
    private com.baidu.tieba.card.a.q aUz;
    private View bottomLine;
    private View mRootView;

    public bt(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        S(getView());
    }

    private void S(View view) {
        this.mRootView = view.findViewById(u.g.home_card_hot_topic_root_view);
        this.KC = (TextView) view.findViewById(u.g.home_card_topic_title);
        this.aUn = (TextView) view.findViewById(u.g.home_card_topic_more);
        this.aUo = (LinearLayout) view.findViewById(u.g.home_card_topic_group_one);
        this.aUp = (LinearLayout) view.findViewById(u.g.home_card_topic_group_two);
        this.aUq = (LinearLayout) view.findViewById(u.g.home_card_topic_group_three);
        this.aUr = (LinearLayout) view.findViewById(u.g.home_card_topic_group_four);
        this.aUs = (TextView) view.findViewById(u.g.home_card_topic_one);
        this.aUt = (TextView) view.findViewById(u.g.home_card_topic_two);
        this.aUu = (TextView) view.findViewById(u.g.home_card_topic_three);
        this.aUv = (TextView) view.findViewById(u.g.home_card_topic_four);
        this.aUw = view.findViewById(u.g.home_top_div);
        this.aUx = view.findViewById(u.g.home_top_topic_div_one);
        this.aUy = view.findViewById(u.g.home_top_topic_div_two);
        this.aRC = view.findViewById(u.g.home_card_top_divider_line);
        this.bottomLine = view.findViewById(u.g.home_card_bottom_divider_line);
        this.aUo.setOnClickListener(this);
        this.aUp.setOnClickListener(this);
        this.aUq.setOnClickListener(this);
        this.aUr.setOnClickListener(this);
        this.aUn.setOnClickListener(new bu(this));
    }

    public void aw(String str, String str2) {
        this.aUA = str;
        this.aUB = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g = com.baidu.adp.lib.h.b.g((String) view.getTag(), -1);
        if (this.aUz != null && com.baidu.tbadk.core.util.y.c(this.aUz.aVK, g) != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay(this.aUB).ab("obj_locate", String.valueOf(this.aUz.aVL)).ab("obj_name", this.aUz.aVK.get(g).PF));
            if (g >= 0 && !com.baidu.tbadk.plugins.a.f(KN())) {
                KN().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(KN().getPageActivity()).createNormalConfig(String.valueOf(this.aUz.aVK.get(g).PE), this.aUz.aVK.get(g).PF, "")));
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.mRootView, u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.c(this.KC, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.aUn, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.aUs, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.aUt, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.aUu, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.aUv, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.k(this.aUw, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.aUx, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.aUy, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.aRC, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.k(this.bottomLine, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.k(this.aUo, u.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.av.k(this.aUp, u.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.av.k(this.aUq, u.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.av.k(this.aUr, u.f.card_topic_click_selector);
            o(this.aUs, 0);
            o(this.aUt, 1);
            o(this.aUu, 2);
            o(this.aUv, 3);
        }
        this.mSkinType = i;
    }

    public void a(com.baidu.tieba.card.a.q qVar) {
        if (qVar == null || StringUtils.isNull(qVar.aVJ) || com.baidu.tbadk.core.util.y.s(qVar.aVK) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.aUz = qVar;
        this.aRC.setVisibility(this.aUz.aUZ ? 0 : 8);
        this.KC.setText(this.aUz.aVJ.trim());
        n(this.aUs, 0);
        n(this.aUt, 1);
        n(this.aUu, 2);
        n(this.aUv, 3);
        o(this.aUs, 0);
        o(this.aUt, 1);
        o(this.aUu, 2);
        o(this.aUv, 3);
    }

    private void n(TextView textView, int i) {
        textView.setText(this.aUz.aVK.get(i).PF.trim());
    }

    private void o(TextView textView, int i) {
        com.baidu.tieba.card.a.p pVar;
        if (this.aUz != null && com.baidu.tbadk.core.util.y.s(this.aUz.aVK) >= 4 && (pVar = (com.baidu.tieba.card.a.p) com.baidu.tbadk.core.util.y.c(this.aUz.aVK, i)) != null) {
            switch (pVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_hottopic_tuijian), (Drawable) null);
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

    public void fH(int i) {
        ViewGroup.LayoutParams layoutParams = this.aRC.getLayoutParams();
        layoutParams.height = i;
        this.aRC.setLayoutParams(layoutParams);
    }
}
