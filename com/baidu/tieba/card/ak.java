package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ak extends a<com.baidu.tieba.card.a.r> {
    private TextView aOS;
    private LinearLayout aOT;
    private LinearLayout aOU;
    private LinearLayout aOV;
    private LinearLayout aOW;
    private TextView aOX;
    private TextView aOY;
    private TextView aOZ;
    private TextView aPa;
    private View aPb;
    private View aPc;
    private View aPd;
    private View aPe;
    private View aPf;
    private com.baidu.tieba.card.a.r aPg;
    private String aPh;
    private String aPi;
    private View mRootView;

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        z(getView());
    }

    private void z(View view) {
        this.mRootView = view.findViewById(n.g.home_card_hot_topic_root_view);
        this.aOS = (TextView) view.findViewById(n.g.home_card_topic_title);
        this.aOT = (LinearLayout) view.findViewById(n.g.home_card_topic_group_one);
        this.aOU = (LinearLayout) view.findViewById(n.g.home_card_topic_group_two);
        this.aOV = (LinearLayout) view.findViewById(n.g.home_card_topic_group_three);
        this.aOW = (LinearLayout) view.findViewById(n.g.home_card_topic_group_four);
        this.aOX = (TextView) view.findViewById(n.g.home_card_topic_one);
        this.aOY = (TextView) view.findViewById(n.g.home_card_topic_two);
        this.aOZ = (TextView) view.findViewById(n.g.home_card_topic_three);
        this.aPa = (TextView) view.findViewById(n.g.home_card_topic_four);
        this.aPb = view.findViewById(n.g.home_top_div);
        this.aPc = view.findViewById(n.g.home_top_topic_div_one);
        this.aPd = view.findViewById(n.g.home_top_topic_div_two);
        this.aPe = view.findViewById(n.g.home_card_top_divider_line);
        this.aPf = view.findViewById(n.g.home_card_bottom_divider_line);
        this.aOT.setOnClickListener(this);
        this.aOU.setOnClickListener(this);
        this.aOV.setOnClickListener(this);
        this.aOW.setOnClickListener(this);
    }

    public void an(String str, String str2) {
        this.aPh = str;
        this.aPi = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int Ig() {
        return n.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log(new av(this.aPi).aa("obj_locate", String.valueOf(this.aPg.aQH)));
        int g = com.baidu.adp.lib.h.b.g((String) view.getTag(), -1);
        if (g >= 0) {
            Ie().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(Ie().getPageActivity()).createNormalConfig(String.valueOf(this.aPg.aQG.get(g).aQA), this.aPg.aQG.get(g).aQB, "")));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            as.i(this.mRootView, n.d.cp_bg_line_d);
            as.b(this.aOS, n.d.cp_cont_d, 1);
            as.b(this.aOX, n.d.cp_cont_b, 1);
            as.b(this.aOY, n.d.cp_cont_b, 1);
            as.b(this.aOZ, n.d.cp_cont_b, 1);
            as.b(this.aPa, n.d.cp_cont_b, 1);
            as.i(this.aPb, n.d.cp_bg_line_b);
            as.i(this.aPc, n.d.cp_bg_line_b);
            as.i(this.aPd, n.d.cp_bg_line_b);
            as.i(this.aPe, n.d.cp_bg_line_c);
            as.i(this.aPf, n.d.cp_bg_line_c);
            as.i(this.aOT, n.f.card_topic_click_selector);
            as.i(this.aOU, n.f.card_topic_click_selector);
            as.i(this.aOV, n.f.card_topic_click_selector);
            as.i(this.aOW, n.f.card_topic_click_selector);
        }
        this.mSkinType = i;
    }

    public void a(com.baidu.tieba.card.a.r rVar) {
        if (rVar == null || StringUtils.isNull(rVar.aQF) || com.baidu.tbadk.core.util.y.l(rVar.aQG) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        am.Iq().gJ(this.aPh);
        this.aPg = rVar;
        this.aPe.setVisibility(this.aPg.aQE ? 0 : 8);
        this.aOS.setText(this.aPg.aQF.trim());
        m(this.aOX, 0);
        m(this.aOY, 1);
        m(this.aOZ, 2);
        m(this.aPa, 3);
    }

    private void m(TextView textView, int i) {
        com.baidu.tieba.card.a.q qVar = this.aPg.aQG.get(i);
        if (qVar.aQC) {
            textView.setText(UtilHelper.getFixedText(qVar.aQB.trim(), 7, true));
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, as.getDrawable(n.f.pic_home_hot), (Drawable) null);
            return;
        }
        textView.setText(UtilHelper.getFixedText(qVar.aQB.trim(), 9, true));
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
