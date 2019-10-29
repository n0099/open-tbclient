package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class p extends a<com.baidu.tieba.card.data.n> {
    private TextView bUW;
    private View eNA;
    private View eNB;
    private View eNC;
    private View eND;
    private View eNE;
    private com.baidu.tieba.card.data.n eNF;
    private String eNG;
    private String eNH;
    private TextView eNr;
    private LinearLayout eNs;
    private LinearLayout eNt;
    private LinearLayout eNu;
    private LinearLayout eNv;
    private TextView eNw;
    private TextView eNx;
    private TextView eNy;
    private TextView eNz;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.bUW = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.eNr = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.eNs = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.eNt = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.eNu = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.eNv = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.eNw = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.eNx = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.eNy = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.eNz = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.eNA = view.findViewById(R.id.home_top_div);
        this.eNB = view.findViewById(R.id.home_top_topic_div_one);
        this.eNC = view.findViewById(R.id.home_top_topic_div_two);
        this.eND = view.findViewById(R.id.home_card_top_divider_line);
        this.eNE = view.findViewById(R.id.home_card_bottom_divider_line);
        this.eNs.setOnClickListener(this);
        this.eNt.setOnClickListener(this);
        this.eNu.setOnClickListener(this);
        this.eNv.setOnClickListener(this);
        this.eNr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.f(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.eNG = str;
        this.eNH = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.g.b.toInt((String) view.getTag(), -1);
        if (this.eNF != null && com.baidu.tbadk.core.util.v.getItem(this.eNF.eQO, i) != null) {
            TiebaStatic.log(new an(this.eNH).bS("obj_locate", String.valueOf(this.eNF.locate)).bS("obj_name", this.eNF.eQO.get(i).caN));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.eNF.eQO.get(i).topicId), this.eNF.eQO.get(i).caN, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.bUW, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.eNr, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.eNw, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.eNx, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.eNy, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.eNz, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.eNA, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.eNB, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.eNC, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.eND, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.eNE, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.eNs, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.eNt, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.eNu, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.eNv, R.drawable.card_topic_click_selector);
            d(this.eNw, 0);
            d(this.eNx, 1);
            d(this.eNy, 2);
            d(this.eNz, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.eQN) || com.baidu.tbadk.core.util.v.getCount(nVar.eQO) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eNF = nVar;
        this.eND.setVisibility(this.eNF.eQL ? 0 : 8);
        showBottomLine(this.eNF.eQM);
        this.bUW.setText(this.eNF.eQN.trim());
        c(this.eNw, 0);
        c(this.eNx, 1);
        c(this.eNy, 2);
        c(this.eNz, 3);
        d(this.eNw, 0);
        d(this.eNx, 1);
        d(this.eNy, 2);
        d(this.eNz, 3);
    }

    private void c(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.eNF.eQO.get(i);
        if (!StringUtils.isNull(mVar.caN)) {
            textView.setText(mVar.caN.trim());
        }
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.eNF != null && com.baidu.tbadk.core.util.v.getCount(this.eNF.eQO) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.getItem(this.eNF.eQO, i)) != null) {
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
            this.eNE.setVisibility(0);
        } else {
            this.eNE.setVisibility(8);
        }
    }

    public void oM(int i) {
        ViewGroup.LayoutParams layoutParams = this.eND.getLayoutParams();
        layoutParams.height = i;
        this.eND.setLayoutParams(layoutParams);
    }
}
