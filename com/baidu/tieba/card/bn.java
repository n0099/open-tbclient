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
public class bn extends a<com.baidu.tieba.card.data.q> {
    private TextView MN;
    private TextView baN;
    private LinearLayout baO;
    private LinearLayout baP;
    private LinearLayout baQ;
    private LinearLayout baR;
    private TextView baS;
    private TextView baT;
    private TextView baU;
    private TextView baV;
    private View baW;
    private View baX;
    private View baY;
    private View baZ;
    private com.baidu.tieba.card.data.q bba;
    private String bbb;
    private String bbc;
    private View bottomLine;
    private View mRootView;

    public bn(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        V(getView());
    }

    private void V(View view) {
        this.mRootView = view.findViewById(r.g.home_card_hot_topic_root_view);
        this.MN = (TextView) view.findViewById(r.g.home_card_topic_title);
        this.baN = (TextView) view.findViewById(r.g.home_card_topic_more);
        this.baO = (LinearLayout) view.findViewById(r.g.home_card_topic_group_one);
        this.baP = (LinearLayout) view.findViewById(r.g.home_card_topic_group_two);
        this.baQ = (LinearLayout) view.findViewById(r.g.home_card_topic_group_three);
        this.baR = (LinearLayout) view.findViewById(r.g.home_card_topic_group_four);
        this.baS = (TextView) view.findViewById(r.g.home_card_topic_one);
        this.baT = (TextView) view.findViewById(r.g.home_card_topic_two);
        this.baU = (TextView) view.findViewById(r.g.home_card_topic_three);
        this.baV = (TextView) view.findViewById(r.g.home_card_topic_four);
        this.baW = view.findViewById(r.g.home_top_div);
        this.baX = view.findViewById(r.g.home_top_topic_div_one);
        this.baY = view.findViewById(r.g.home_top_topic_div_two);
        this.baZ = view.findViewById(r.g.home_card_top_divider_line);
        this.bottomLine = view.findViewById(r.g.home_card_bottom_divider_line);
        this.baO.setOnClickListener(this);
        this.baP.setOnClickListener(this);
        this.baQ.setOnClickListener(this);
        this.baR.setOnClickListener(this);
        this.baN.setOnClickListener(new bo(this));
    }

    public void ax(String str, String str2) {
        this.bbb = str;
        this.bbc = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g = com.baidu.adp.lib.h.b.g((String) view.getTag(), -1);
        if (this.bba != null && com.baidu.tbadk.core.util.y.c(this.bba.bcE, g) != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax(this.bbc).ab("obj_locate", String.valueOf(this.bba.bcF)).ab("obj_name", this.bba.bcE.get(g).ST));
            if (g >= 0 && !com.baidu.tbadk.plugins.e.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.bba.bcE.get(g).SS), this.bba.bcE.get(g).ST, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.mRootView, r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.c(this.MN, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.baN, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.baS, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.baT, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.baU, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.baV, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.k(this.baW, r.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.baX, r.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.baY, r.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.baZ, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.k(this.bottomLine, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.k(this.baO, r.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.av.k(this.baP, r.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.av.k(this.baQ, r.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.av.k(this.baR, r.f.card_topic_click_selector);
            o(this.baS, 0);
            o(this.baT, 1);
            o(this.baU, 2);
            o(this.baV, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.q qVar) {
        if (qVar == null || StringUtils.isNull(qVar.bcD) || com.baidu.tbadk.core.util.y.s(qVar.bcE) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.bba = qVar;
        this.baZ.setVisibility(this.bba.bcB ? 0 : 8);
        showBottomLine(this.bba.bcC);
        this.MN.setText(this.bba.bcD.trim());
        n(this.baS, 0);
        n(this.baT, 1);
        n(this.baU, 2);
        n(this.baV, 3);
        o(this.baS, 0);
        o(this.baT, 1);
        o(this.baU, 2);
        o(this.baV, 3);
    }

    private void n(TextView textView, int i) {
        textView.setText(this.bba.bcE.get(i).ST.trim());
    }

    private void o(TextView textView, int i) {
        com.baidu.tieba.card.data.p pVar;
        if (this.bba != null && com.baidu.tbadk.core.util.y.s(this.bba.bcE) >= 4 && (pVar = (com.baidu.tieba.card.data.p) com.baidu.tbadk.core.util.y.c(this.bba.bcE, i)) != null) {
            switch (pVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_hottopic_tuijian), (Drawable) null);
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

    public void gi(int i) {
        ViewGroup.LayoutParams layoutParams = this.baZ.getLayoutParams();
        layoutParams.height = i;
        this.baZ.setLayoutParams(layoutParams);
    }
}
