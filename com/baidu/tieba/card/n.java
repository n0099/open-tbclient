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
    private TextView dkk;
    private LinearLayout gpA;
    private LinearLayout gpB;
    private LinearLayout gpC;
    private LinearLayout gpD;
    private TextView gpE;
    private TextView gpF;
    private TextView gpG;
    private TextView gpH;
    private View gpI;
    private View gpJ;
    private View gpK;
    private View gpL;
    private View gpM;
    private com.baidu.tieba.card.data.n gpN;
    private String gpO;
    private String gpP;
    private TextView gpz;
    private View mRootView;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.dkk = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.gpz = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.gpA = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.gpB = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.gpC = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.gpD = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.gpE = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.gpF = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.gpG = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.gpH = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.gpI = view.findViewById(R.id.home_top_div);
        this.gpJ = view.findViewById(R.id.home_top_topic_div_one);
        this.gpK = view.findViewById(R.id.home_top_topic_div_two);
        this.gpL = view.findViewById(R.id.home_card_top_divider_line);
        this.gpM = view.findViewById(R.id.home_card_bottom_divider_line);
        this.gpA.setOnClickListener(this);
        this.gpB.setOnClickListener(this);
        this.gpC.setOnClickListener(this);
        this.gpD.setOnClickListener(this);
        this.gpz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(n.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(n.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", SchemeCollecter.CLASSIFY_ALL)));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.gpO = str;
        this.gpP = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.gpN != null && com.baidu.tbadk.core.util.v.getItem(this.gpN.gtc, i) != null) {
            TiebaStatic.log(new an(this.gpP).cI("obj_locate", String.valueOf(this.gpN.locate)).cI("obj_name", this.gpN.gtc.get(i).dpV));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.gpN.gtc.get(i).topicId), this.gpN.gtc.get(i).dpV, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.dkk, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gpz, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gpE, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gpF, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gpG, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gpH, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.gpI, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gpJ, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gpK, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gpL, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gpM, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gpA, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.gpB, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.gpC, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.gpD, R.drawable.card_topic_click_selector);
            d(this.gpE, 0);
            d(this.gpF, 1);
            d(this.gpG, 2);
            d(this.gpH, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.gtb) || com.baidu.tbadk.core.util.v.getCount(nVar.gtc) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.gpN = nVar;
        this.gpL.setVisibility(this.gpN.gsZ ? 0 : 8);
        showBottomLine(this.gpN.gta);
        this.dkk.setText(this.gpN.gtb.trim());
        c(this.gpE, 0);
        c(this.gpF, 1);
        c(this.gpG, 2);
        c(this.gpH, 3);
        d(this.gpE, 0);
        d(this.gpF, 1);
        d(this.gpG, 2);
        d(this.gpH, 3);
    }

    private void c(TextView textView, int i) {
        m mVar = this.gpN.gtc.get(i);
        if (!StringUtils.isNull(mVar.dpV)) {
            textView.setText(mVar.dpV.trim());
        }
    }

    private void d(TextView textView, int i) {
        m mVar;
        if (this.gpN != null && com.baidu.tbadk.core.util.v.getCount(this.gpN.gtc) >= 4 && (mVar = (m) com.baidu.tbadk.core.util.v.getItem(this.gpN.gtc, i)) != null) {
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
            this.gpM.setVisibility(0);
        } else {
            this.gpM.setVisibility(8);
        }
    }

    public void rK(int i) {
        ViewGroup.LayoutParams layoutParams = this.gpL.getLayoutParams();
        layoutParams.height = i;
        this.gpL.setLayoutParams(layoutParams);
    }
}
