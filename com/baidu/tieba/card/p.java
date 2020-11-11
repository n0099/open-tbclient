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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class p extends b<com.baidu.tieba.card.data.o> {
    private TextView evg;
    private View hYA;
    private View hYB;
    private com.baidu.tieba.card.data.o hYC;
    private String hYD;
    private String hYE;
    private TextView hYo;
    private LinearLayout hYp;
    private LinearLayout hYq;
    private LinearLayout hYr;
    private LinearLayout hYs;
    private TextView hYt;
    private TextView hYu;
    private TextView hYv;
    private TextView hYw;
    private View hYx;
    private View hYy;
    private View hYz;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.evg = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.hYo = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.hYp = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.hYq = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.hYr = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.hYs = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.hYt = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.hYu = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.hYv = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.hYw = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.hYx = view.findViewById(R.id.home_top_div);
        this.hYy = view.findViewById(R.id.home_top_topic_div_one);
        this.hYz = view.findViewById(R.id.home_top_topic_div_two);
        this.hYA = view.findViewById(R.id.home_card_top_divider_line);
        this.hYB = view.findViewById(R.id.home_card_bottom_divider_line);
        this.hYp.setOnClickListener(this);
        this.hYq.setOnClickListener(this);
        this.hYr.setOnClickListener(this);
        this.hYs.setOnClickListener(this);
        this.hYo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.hYD = str;
        this.hYE = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.hYC != null && com.baidu.tbadk.core.util.y.getItem(this.hYC.ibW, i) != null) {
            TiebaStatic.log(new aq(this.hYE).dR("obj_locate", String.valueOf(this.hYC.locate)).dR("obj_name", this.hYC.ibW.get(i).eCJ));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.hYC.ibW.get(i).topicId), this.hYC.ibW.get(i).eCJ, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.evg, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hYo, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hYt, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hYu, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hYv, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hYw, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(this.hYx, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hYy, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hYz, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hYA, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hYB, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hYp, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hYq, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hYr, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hYs, R.drawable.card_topic_click_selector);
            e(this.hYt, 0);
            e(this.hYu, 1);
            e(this.hYv, 2);
            e(this.hYw, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || StringUtils.isNull(oVar.ibV) || com.baidu.tbadk.core.util.y.getCount(oVar.ibW) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.hYC = oVar;
        this.hYA.setVisibility(this.hYC.ibT ? 0 : 8);
        showBottomLine(this.hYC.ibU);
        this.evg.setText(this.hYC.ibV.trim());
        d(this.hYt, 0);
        d(this.hYu, 1);
        d(this.hYv, 2);
        d(this.hYw, 3);
        e(this.hYt, 0);
        e(this.hYu, 1);
        e(this.hYv, 2);
        e(this.hYw, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar = this.hYC.ibW.get(i);
        if (!StringUtils.isNull(nVar.eCJ)) {
            textView.setText(nVar.eCJ.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar;
        if (this.hYC != null && com.baidu.tbadk.core.util.y.getCount(this.hYC.ibW) >= 4 && (nVar = (com.baidu.tieba.card.data.n) com.baidu.tbadk.core.util.y.getItem(this.hYC.ibW, i)) != null) {
            switch (nVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.hYB.setVisibility(0);
        } else {
            this.hYB.setVisibility(8);
        }
    }

    public void xg(int i) {
        ViewGroup.LayoutParams layoutParams = this.hYA.getLayoutParams();
        layoutParams.height = i;
        this.hYA.setLayoutParams(layoutParams);
    }
}
