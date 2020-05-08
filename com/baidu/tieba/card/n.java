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
    private TextView dko;
    private TextView gpF;
    private LinearLayout gpG;
    private LinearLayout gpH;
    private LinearLayout gpI;
    private LinearLayout gpJ;
    private TextView gpK;
    private TextView gpL;
    private TextView gpM;
    private TextView gpN;
    private View gpO;
    private View gpP;
    private View gpQ;
    private View gpR;
    private View gpS;
    private com.baidu.tieba.card.data.n gpT;
    private String gpU;
    private String gpV;
    private View mRootView;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.dko = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.gpF = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.gpG = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.gpH = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.gpI = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.gpJ = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.gpK = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.gpL = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.gpM = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.gpN = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.gpO = view.findViewById(R.id.home_top_div);
        this.gpP = view.findViewById(R.id.home_top_topic_div_one);
        this.gpQ = view.findViewById(R.id.home_top_topic_div_two);
        this.gpR = view.findViewById(R.id.home_card_top_divider_line);
        this.gpS = view.findViewById(R.id.home_card_bottom_divider_line);
        this.gpG.setOnClickListener(this);
        this.gpH.setOnClickListener(this);
        this.gpI.setOnClickListener(this);
        this.gpJ.setOnClickListener(this);
        this.gpF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(n.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(n.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", SchemeCollecter.CLASSIFY_ALL)));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.gpU = str;
        this.gpV = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.gpT != null && com.baidu.tbadk.core.util.v.getItem(this.gpT.gti, i) != null) {
            TiebaStatic.log(new an(this.gpV).cI("obj_locate", String.valueOf(this.gpT.locate)).cI("obj_name", this.gpT.gti.get(i).dpZ));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.gpT.gti.get(i).topicId), this.gpT.gti.get(i).dpZ, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.dko, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gpF, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gpK, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gpL, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gpM, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gpN, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.gpO, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gpP, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gpQ, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gpR, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gpS, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gpG, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.gpH, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.gpI, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.gpJ, R.drawable.card_topic_click_selector);
            d(this.gpK, 0);
            d(this.gpL, 1);
            d(this.gpM, 2);
            d(this.gpN, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.gth) || com.baidu.tbadk.core.util.v.getCount(nVar.gti) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.gpT = nVar;
        this.gpR.setVisibility(this.gpT.gtf ? 0 : 8);
        showBottomLine(this.gpT.gtg);
        this.dko.setText(this.gpT.gth.trim());
        c(this.gpK, 0);
        c(this.gpL, 1);
        c(this.gpM, 2);
        c(this.gpN, 3);
        d(this.gpK, 0);
        d(this.gpL, 1);
        d(this.gpM, 2);
        d(this.gpN, 3);
    }

    private void c(TextView textView, int i) {
        m mVar = this.gpT.gti.get(i);
        if (!StringUtils.isNull(mVar.dpZ)) {
            textView.setText(mVar.dpZ.trim());
        }
    }

    private void d(TextView textView, int i) {
        m mVar;
        if (this.gpT != null && com.baidu.tbadk.core.util.v.getCount(this.gpT.gti) >= 4 && (mVar = (m) com.baidu.tbadk.core.util.v.getItem(this.gpT.gti, i)) != null) {
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
            this.gpS.setVisibility(0);
        } else {
            this.gpS.setVisibility(8);
        }
    }

    public void rK(int i) {
        ViewGroup.LayoutParams layoutParams = this.gpR.getLayoutParams();
        layoutParams.height = i;
        this.gpR.setLayoutParams(layoutParams);
    }
}
