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
/* loaded from: classes7.dex */
public class n extends a<com.baidu.tieba.card.data.n> {
    private TextView cGN;
    private LinearLayout fHA;
    private LinearLayout fHB;
    private LinearLayout fHC;
    private TextView fHD;
    private TextView fHE;
    private TextView fHF;
    private TextView fHG;
    private View fHH;
    private View fHI;
    private View fHJ;
    private View fHK;
    private View fHL;
    private com.baidu.tieba.card.data.n fHM;
    private String fHN;
    private String fHO;
    private TextView fHy;
    private LinearLayout fHz;
    private View mRootView;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.cGN = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.fHy = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.fHz = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.fHA = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.fHB = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.fHC = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.fHD = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.fHE = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.fHF = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.fHG = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.fHH = view.findViewById(R.id.home_top_div);
        this.fHI = view.findViewById(R.id.home_top_topic_div_one);
        this.fHJ = view.findViewById(R.id.home_top_topic_div_two);
        this.fHK = view.findViewById(R.id.home_card_top_divider_line);
        this.fHL = view.findViewById(R.id.home_card_bottom_divider_line);
        this.fHz.setOnClickListener(this);
        this.fHA.setOnClickListener(this);
        this.fHB.setOnClickListener(this);
        this.fHC.setOnClickListener(this);
        this.fHy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.h(n.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(n.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", SchemeCollecter.CLASSIFY_ALL)));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.fHN = str;
        this.fHO = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.fHM != null && com.baidu.tbadk.core.util.v.getItem(this.fHM.fLc, i) != null) {
            TiebaStatic.log(new an(this.fHO).cp("obj_locate", String.valueOf(this.fHM.locate)).cp("obj_name", this.fHM.fLc.get(i).cMx));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.h(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.fHM.fLc.get(i).topicId), this.fHM.fLc.get(i).cMx, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.cGN, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fHy, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fHD, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fHE, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fHF, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fHG, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.fHH, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fHI, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fHJ, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fHK, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fHL, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fHz, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fHA, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fHB, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fHC, R.drawable.card_topic_click_selector);
            d(this.fHD, 0);
            d(this.fHE, 1);
            d(this.fHF, 2);
            d(this.fHG, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.fLb) || com.baidu.tbadk.core.util.v.getCount(nVar.fLc) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.fHM = nVar;
        this.fHK.setVisibility(this.fHM.fKZ ? 0 : 8);
        showBottomLine(this.fHM.fLa);
        this.cGN.setText(this.fHM.fLb.trim());
        c(this.fHD, 0);
        c(this.fHE, 1);
        c(this.fHF, 2);
        c(this.fHG, 3);
        d(this.fHD, 0);
        d(this.fHE, 1);
        d(this.fHF, 2);
        d(this.fHG, 3);
    }

    private void c(TextView textView, int i) {
        m mVar = this.fHM.fLc.get(i);
        if (!StringUtils.isNull(mVar.cMx)) {
            textView.setText(mVar.cMx.trim());
        }
    }

    private void d(TextView textView, int i) {
        m mVar;
        if (this.fHM != null && com.baidu.tbadk.core.util.v.getCount(this.fHM.fLc) >= 4 && (mVar = (m) com.baidu.tbadk.core.util.v.getItem(this.fHM.fLc, i)) != null) {
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
            this.fHL.setVisibility(0);
        } else {
            this.fHL.setVisibility(8);
        }
    }

    public void rj(int i) {
        ViewGroup.LayoutParams layoutParams = this.fHK.getLayoutParams();
        layoutParams.height = i;
        this.fHK.setLayoutParams(layoutParams);
    }
}
