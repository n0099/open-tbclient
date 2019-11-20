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
    private TextView bUf;
    private TextView eMA;
    private LinearLayout eMB;
    private LinearLayout eMC;
    private LinearLayout eMD;
    private LinearLayout eME;
    private TextView eMF;
    private TextView eMG;
    private TextView eMH;
    private TextView eMI;
    private View eMJ;
    private View eMK;
    private View eML;
    private View eMM;
    private View eMN;
    private com.baidu.tieba.card.data.n eMO;
    private String eMP;
    private String eMQ;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.bUf = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.eMA = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.eMB = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.eMC = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.eMD = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.eME = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.eMF = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.eMG = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.eMH = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.eMI = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.eMJ = view.findViewById(R.id.home_top_div);
        this.eMK = view.findViewById(R.id.home_top_topic_div_one);
        this.eML = view.findViewById(R.id.home_top_topic_div_two);
        this.eMM = view.findViewById(R.id.home_card_top_divider_line);
        this.eMN = view.findViewById(R.id.home_card_bottom_divider_line);
        this.eMB.setOnClickListener(this);
        this.eMC.setOnClickListener(this);
        this.eMD.setOnClickListener(this);
        this.eME.setOnClickListener(this);
        this.eMA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.f(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.eMP = str;
        this.eMQ = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.g.b.toInt((String) view.getTag(), -1);
        if (this.eMO != null && com.baidu.tbadk.core.util.v.getItem(this.eMO.ePX, i) != null) {
            TiebaStatic.log(new an(this.eMQ).bS("obj_locate", String.valueOf(this.eMO.locate)).bS("obj_name", this.eMO.ePX.get(i).bZW));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.eMO.ePX.get(i).topicId), this.eMO.ePX.get(i).bZW, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.bUf, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.eMA, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.eMF, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.eMG, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.eMH, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.eMI, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.eMJ, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.eMK, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.eML, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.eMM, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.eMN, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.eMB, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.eMC, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.eMD, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.eME, R.drawable.card_topic_click_selector);
            d(this.eMF, 0);
            d(this.eMG, 1);
            d(this.eMH, 2);
            d(this.eMI, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.ePW) || com.baidu.tbadk.core.util.v.getCount(nVar.ePX) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eMO = nVar;
        this.eMM.setVisibility(this.eMO.ePU ? 0 : 8);
        showBottomLine(this.eMO.ePV);
        this.bUf.setText(this.eMO.ePW.trim());
        c(this.eMF, 0);
        c(this.eMG, 1);
        c(this.eMH, 2);
        c(this.eMI, 3);
        d(this.eMF, 0);
        d(this.eMG, 1);
        d(this.eMH, 2);
        d(this.eMI, 3);
    }

    private void c(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.eMO.ePX.get(i);
        if (!StringUtils.isNull(mVar.bZW)) {
            textView.setText(mVar.bZW.trim());
        }
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.eMO != null && com.baidu.tbadk.core.util.v.getCount(this.eMO.ePX) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.getItem(this.eMO.ePX, i)) != null) {
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
            this.eMN.setVisibility(0);
        } else {
            this.eMN.setVisibility(8);
        }
    }

    public void oL(int i) {
        ViewGroup.LayoutParams layoutParams = this.eMM.getLayoutParams();
        layoutParams.height = i;
        this.eMM.setLayoutParams(layoutParams);
    }
}
