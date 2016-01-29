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
public class av extends a<com.baidu.tieba.card.a.u> {
    private View aOS;
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
    private View aRd;
    private com.baidu.tieba.card.a.u aRe;
    private String aRf;
    private String aRg;
    private View mRootView;

    public av(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        L(getView());
    }

    private void L(View view) {
        this.mRootView = view.findViewById(t.g.home_card_hot_topic_root_view);
        this.aQR = (TextView) view.findViewById(t.g.home_card_topic_title);
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
        this.aOS = view.findViewById(t.g.home_card_top_divider_line);
        this.aRd = view.findViewById(t.g.home_card_bottom_divider_line);
        this.aQS.setOnClickListener(this);
        this.aQT.setOnClickListener(this);
        this.aQU.setOnClickListener(this);
        this.aQV.setOnClickListener(this);
    }

    public void an(String str, String str2) {
        this.aRf = str;
        this.aRg = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int JM() {
        return t.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g = com.baidu.adp.lib.h.b.g((String) view.getTag(), -1);
        if (this.aRe != null && com.baidu.tbadk.core.util.x.b(this.aRe.aSJ, g) != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au(this.aRg).aa("obj_locate", String.valueOf(this.aRe.aSK)).aa("obj_name", this.aRe.aSJ.get(g).Wm));
            if (g >= 0) {
                JK().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(JK().getPageActivity()).createNormalConfig(String.valueOf(this.aRe.aSJ.get(g).Wl), this.aRe.aSJ.get(g).Wm, "")));
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.k(this.mRootView, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.ar.b(this.aQR, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ar.b(this.aQW, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ar.b(this.aQX, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ar.b(this.aQY, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ar.b(this.aQZ, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ar.k(this.aRa, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ar.k(this.aRb, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ar.k(this.aRc, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ar.k(this.aOS, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.k(this.aRd, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.ar.k(this.aQS, t.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.ar.k(this.aQT, t.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.ar.k(this.aQU, t.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.ar.k(this.aQV, t.f.card_topic_click_selector);
            o(this.aQW, 0);
            o(this.aQX, 1);
            o(this.aQY, 2);
            o(this.aQZ, 3);
        }
        this.mSkinType = i;
    }

    public void a(com.baidu.tieba.card.a.u uVar) {
        if (uVar == null || StringUtils.isNull(uVar.aSI) || com.baidu.tbadk.core.util.x.o(uVar.aSJ) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.aRe = uVar;
        this.aOS.setVisibility(this.aRe.aRQ ? 0 : 8);
        this.aQR.setText(this.aRe.aSI.trim());
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
        com.baidu.tieba.card.a.t tVar = this.aRe.aSJ.get(i);
        textView.setText(tVar.Wm.trim());
        if (tVar.aSG) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(t.f.pic_home_hot), (Drawable) null);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    private void o(TextView textView, int i) {
        com.baidu.tieba.card.a.t tVar;
        if (this.aRe != null && com.baidu.tbadk.core.util.x.o(this.aRe.aSJ) >= 4 && (tVar = (com.baidu.tieba.card.a.t) com.baidu.tbadk.core.util.x.b(this.aRe.aSJ, i)) != null) {
            switch (tVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void bS(boolean z) {
        if (z) {
            this.aRd.setVisibility(0);
        } else {
            this.aRd.setVisibility(8);
        }
    }

    public void fA(int i) {
        ViewGroup.LayoutParams layoutParams = this.aOS.getLayoutParams();
        layoutParams.height = i;
        this.aOS.setLayoutParams(layoutParams);
    }
}
