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
/* loaded from: classes9.dex */
public class n extends a<com.baidu.tieba.card.data.n> {
    private TextView cKS;
    private String fKA;
    private TextView fKk;
    private LinearLayout fKl;
    private LinearLayout fKm;
    private LinearLayout fKn;
    private LinearLayout fKo;
    private TextView fKp;
    private TextView fKq;
    private TextView fKr;
    private TextView fKs;
    private View fKt;
    private View fKu;
    private View fKv;
    private View fKw;
    private View fKx;
    private com.baidu.tieba.card.data.n fKy;
    private String fKz;
    private View mRootView;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.cKS = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.fKk = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.fKl = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.fKm = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.fKn = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.fKo = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.fKp = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.fKq = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.fKr = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.fKs = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.fKt = view.findViewById(R.id.home_top_div);
        this.fKu = view.findViewById(R.id.home_top_topic_div_one);
        this.fKv = view.findViewById(R.id.home_top_topic_div_two);
        this.fKw = view.findViewById(R.id.home_card_top_divider_line);
        this.fKx = view.findViewById(R.id.home_card_bottom_divider_line);
        this.fKl.setOnClickListener(this);
        this.fKm.setOnClickListener(this);
        this.fKn.setOnClickListener(this);
        this.fKo.setOnClickListener(this);
        this.fKk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.h(n.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(n.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", SchemeCollecter.CLASSIFY_ALL)));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.fKz = str;
        this.fKA = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.fKy != null && com.baidu.tbadk.core.util.v.getItem(this.fKy.fNN, i) != null) {
            TiebaStatic.log(new an(this.fKA).cy("obj_locate", String.valueOf(this.fKy.locate)).cy("obj_name", this.fKy.fNN.get(i).cQC));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.h(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.fKy.fNN.get(i).topicId), this.fKy.fNN.get(i).cQC, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.cKS, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fKk, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fKp, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fKq, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fKr, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fKs, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.fKt, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKu, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKv, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKw, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKx, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKl, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fKm, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fKn, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fKo, R.drawable.card_topic_click_selector);
            d(this.fKp, 0);
            d(this.fKq, 1);
            d(this.fKr, 2);
            d(this.fKs, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.fNM) || com.baidu.tbadk.core.util.v.getCount(nVar.fNN) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.fKy = nVar;
        this.fKw.setVisibility(this.fKy.fNK ? 0 : 8);
        showBottomLine(this.fKy.fNL);
        this.cKS.setText(this.fKy.fNM.trim());
        c(this.fKp, 0);
        c(this.fKq, 1);
        c(this.fKr, 2);
        c(this.fKs, 3);
        d(this.fKp, 0);
        d(this.fKq, 1);
        d(this.fKr, 2);
        d(this.fKs, 3);
    }

    private void c(TextView textView, int i) {
        m mVar = this.fKy.fNN.get(i);
        if (!StringUtils.isNull(mVar.cQC)) {
            textView.setText(mVar.cQC.trim());
        }
    }

    private void d(TextView textView, int i) {
        m mVar;
        if (this.fKy != null && com.baidu.tbadk.core.util.v.getCount(this.fKy.fNN) >= 4 && (mVar = (m) com.baidu.tbadk.core.util.v.getItem(this.fKy.fNN, i)) != null) {
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
            this.fKx.setVisibility(0);
        } else {
            this.fKx.setVisibility(8);
        }
    }

    public void rq(int i) {
        ViewGroup.LayoutParams layoutParams = this.fKw.getLayoutParams();
        layoutParams.height = i;
        this.fKw.setLayoutParams(layoutParams);
    }
}
