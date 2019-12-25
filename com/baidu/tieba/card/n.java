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
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.m;
/* loaded from: classes6.dex */
public class n extends a<com.baidu.tieba.card.data.n> {
    private TextView cGB;
    private View fEA;
    private View fEB;
    private com.baidu.tieba.card.data.n fEC;
    private String fED;
    private String fEE;
    private TextView fEo;
    private LinearLayout fEp;
    private LinearLayout fEq;
    private LinearLayout fEr;
    private LinearLayout fEs;
    private TextView fEt;
    private TextView fEu;
    private TextView fEv;
    private TextView fEw;
    private View fEx;
    private View fEy;
    private View fEz;
    private View mRootView;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.cGB = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.fEo = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.fEp = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.fEq = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.fEr = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.fEs = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.fEt = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.fEu = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.fEv = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.fEw = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.fEx = view.findViewById(R.id.home_top_div);
        this.fEy = view.findViewById(R.id.home_top_topic_div_one);
        this.fEz = view.findViewById(R.id.home_top_topic_div_two);
        this.fEA = view.findViewById(R.id.home_card_top_divider_line);
        this.fEB = view.findViewById(R.id.home_card_bottom_divider_line);
        this.fEp.setOnClickListener(this);
        this.fEq.setOnClickListener(this);
        this.fEr.setOnClickListener(this);
        this.fEs.setOnClickListener(this);
        this.fEo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.h(n.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(n.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", SchemeCollecter.CLASSIFY_ALL)));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.fED = str;
        this.fEE = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.fEC != null && com.baidu.tbadk.core.util.v.getItem(this.fEC.fHS, i) != null) {
            TiebaStatic.log(new an(this.fEE).cp("obj_locate", String.valueOf(this.fEC.locate)).cp("obj_name", this.fEC.fHS.get(i).cMn));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.h(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.fEC.fHS.get(i).topicId), this.fEC.fHS.get(i).cMn, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.cGB, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fEo, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fEt, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fEu, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fEv, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fEw, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.fEx, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fEy, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fEz, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fEA, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fEB, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fEp, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fEq, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fEr, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fEs, R.drawable.card_topic_click_selector);
            d(this.fEt, 0);
            d(this.fEu, 1);
            d(this.fEv, 2);
            d(this.fEw, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.fHR) || com.baidu.tbadk.core.util.v.getCount(nVar.fHS) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.fEC = nVar;
        this.fEA.setVisibility(this.fEC.fHP ? 0 : 8);
        showBottomLine(this.fEC.fHQ);
        this.cGB.setText(this.fEC.fHR.trim());
        c(this.fEt, 0);
        c(this.fEu, 1);
        c(this.fEv, 2);
        c(this.fEw, 3);
        d(this.fEt, 0);
        d(this.fEu, 1);
        d(this.fEv, 2);
        d(this.fEw, 3);
    }

    private void c(TextView textView, int i) {
        m mVar = this.fEC.fHS.get(i);
        if (!StringUtils.isNull(mVar.cMn)) {
            textView.setText(mVar.cMn.trim());
        }
    }

    private void d(TextView textView, int i) {
        m mVar;
        if (this.fEC != null && com.baidu.tbadk.core.util.v.getCount(this.fEC.fHS) >= 4 && (mVar = (m) com.baidu.tbadk.core.util.v.getItem(this.fEC.fHS, i)) != null) {
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
            this.fEB.setVisibility(0);
        } else {
            this.fEB.setVisibility(8);
        }
    }

    public void re(int i) {
        ViewGroup.LayoutParams layoutParams = this.fEA.getLayoutParams();
        layoutParams.height = i;
        this.fEA.setLayoutParams(layoutParams);
    }
}
