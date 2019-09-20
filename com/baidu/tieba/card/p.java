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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class p extends a<com.baidu.tieba.card.data.n> {
    private TextView bCB;
    private TextView eEL;
    private LinearLayout eEM;
    private LinearLayout eEN;
    private LinearLayout eEO;
    private LinearLayout eEP;
    private TextView eEQ;
    private TextView eER;
    private TextView eES;
    private TextView eET;
    private View eEU;
    private View eEV;
    private View eEW;
    private View eEX;
    private com.baidu.tieba.card.data.n eEY;
    private String eEZ;
    private String eFa;
    private View ejX;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.bCB = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.eEL = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.eEM = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.eEN = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.eEO = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.eEP = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.eEQ = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.eER = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.eES = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.eET = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.eEU = view.findViewById(R.id.home_top_div);
        this.eEV = view.findViewById(R.id.home_top_topic_div_one);
        this.eEW = view.findViewById(R.id.home_top_topic_div_two);
        this.eEX = view.findViewById(R.id.home_card_top_divider_line);
        this.ejX = view.findViewById(R.id.home_card_bottom_divider_line);
        this.eEM.setOnClickListener(this);
        this.eEN.setOnClickListener(this);
        this.eEO.setOnClickListener(this);
        this.eEP.setOnClickListener(this);
        this.eEL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.f(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.eEZ = str;
        this.eFa = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int f = com.baidu.adp.lib.g.b.f((String) view.getTag(), -1);
        if (this.eEY != null && com.baidu.tbadk.core.util.v.c(this.eEY.eIj, f) != null) {
            TiebaStatic.log(new an(this.eFa).bT("obj_locate", String.valueOf(this.eEY.locate)).bT("obj_name", this.eEY.eIj.get(f).bJg));
            if (f >= 0 && !com.baidu.tbadk.plugins.b.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.eEY.eIj.get(f).topicId), this.eEY.eIj.get(f).bJg, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.mRootView, R.color.cp_bg_line_d);
            am.f(this.bCB, R.color.cp_cont_d, 1);
            am.f(this.eEL, R.color.cp_cont_d, 1);
            am.f(this.eEQ, R.color.cp_cont_b, 1);
            am.f(this.eER, R.color.cp_cont_b, 1);
            am.f(this.eES, R.color.cp_cont_b, 1);
            am.f(this.eET, R.color.cp_cont_b, 1);
            am.k(this.eEU, R.color.cp_bg_line_c);
            am.k(this.eEV, R.color.cp_bg_line_c);
            am.k(this.eEW, R.color.cp_bg_line_c);
            am.k(this.eEX, R.color.cp_bg_line_c);
            am.k(this.ejX, R.color.cp_bg_line_c);
            am.k(this.eEM, R.drawable.card_topic_click_selector);
            am.k(this.eEN, R.drawable.card_topic_click_selector);
            am.k(this.eEO, R.drawable.card_topic_click_selector);
            am.k(this.eEP, R.drawable.card_topic_click_selector);
            j(this.eEQ, 0);
            j(this.eER, 1);
            j(this.eES, 2);
            j(this.eET, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.eIi) || com.baidu.tbadk.core.util.v.Z(nVar.eIj) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eEY = nVar;
        this.eEX.setVisibility(this.eEY.eIg ? 0 : 8);
        showBottomLine(this.eEY.eIh);
        this.bCB.setText(this.eEY.eIi.trim());
        i(this.eEQ, 0);
        i(this.eER, 1);
        i(this.eES, 2);
        i(this.eET, 3);
        j(this.eEQ, 0);
        j(this.eER, 1);
        j(this.eES, 2);
        j(this.eET, 3);
    }

    private void i(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.eEY.eIj.get(i);
        if (!StringUtils.isNull(mVar.bJg)) {
            textView.setText(mVar.bJg.trim());
        }
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.eEY != null && com.baidu.tbadk.core.util.v.Z(this.eEY.eIj) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.c(this.eEY.eIj, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.ejX.setVisibility(0);
        } else {
            this.ejX.setVisibility(8);
        }
    }

    public void pK(int i) {
        ViewGroup.LayoutParams layoutParams = this.eEX.getLayoutParams();
        layoutParams.height = i;
        this.eEX.setLayoutParams(layoutParams);
    }
}
