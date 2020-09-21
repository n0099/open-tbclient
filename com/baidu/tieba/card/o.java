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
/* loaded from: classes21.dex */
public class o extends b<com.baidu.tieba.card.data.o> {
    private TextView dUN;
    private TextView hra;
    private LinearLayout hrb;
    private LinearLayout hrc;
    private LinearLayout hrd;
    private LinearLayout hre;
    private TextView hrf;
    private TextView hrg;
    private TextView hrh;
    private TextView hri;
    private View hrj;
    private View hrk;
    private View hrl;
    private View hrm;
    private View hrn;
    private com.baidu.tieba.card.data.o hro;
    private String hrp;
    private String hrq;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.dUN = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.hra = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.hrb = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.hrc = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.hrd = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.hre = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.hrf = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.hrg = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.hrh = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.hri = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.hrj = view.findViewById(R.id.home_top_div);
        this.hrk = view.findViewById(R.id.home_top_topic_div_one);
        this.hrl = view.findViewById(R.id.home_top_topic_div_two);
        this.hrm = view.findViewById(R.id.home_card_top_divider_line);
        this.hrn = view.findViewById(R.id.home_card_bottom_divider_line);
        this.hrb.setOnClickListener(this);
        this.hrc.setOnClickListener(this);
        this.hrd.setOnClickListener(this);
        this.hre.setOnClickListener(this);
        this.hra.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.hrp = str;
        this.hrq = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.hro != null && com.baidu.tbadk.core.util.y.getItem(this.hro.huH, i) != null) {
            TiebaStatic.log(new aq(this.hrq).dF("obj_locate", String.valueOf(this.hro.locate)).dF("obj_name", this.hro.huH.get(i).ecp));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.hro.huH.get(i).topicId), this.hro.huH.get(i).ecp, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.dUN, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hra, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hrf, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hrg, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hrh, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hri, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(this.hrj, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hrk, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hrl, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hrm, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hrn, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hrb, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hrc, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hrd, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hre, R.drawable.card_topic_click_selector);
            e(this.hrf, 0);
            e(this.hrg, 1);
            e(this.hrh, 2);
            e(this.hri, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || StringUtils.isNull(oVar.huG) || com.baidu.tbadk.core.util.y.getCount(oVar.huH) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.hro = oVar;
        this.hrm.setVisibility(this.hro.huE ? 0 : 8);
        showBottomLine(this.hro.huF);
        this.dUN.setText(this.hro.huG.trim());
        d(this.hrf, 0);
        d(this.hrg, 1);
        d(this.hrh, 2);
        d(this.hri, 3);
        e(this.hrf, 0);
        e(this.hrg, 1);
        e(this.hrh, 2);
        e(this.hri, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar = this.hro.huH.get(i);
        if (!StringUtils.isNull(nVar.ecp)) {
            textView.setText(nVar.ecp.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar;
        if (this.hro != null && com.baidu.tbadk.core.util.y.getCount(this.hro.huH) >= 4 && (nVar = (com.baidu.tieba.card.data.n) com.baidu.tbadk.core.util.y.getItem(this.hro.huH, i)) != null) {
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
            this.hrn.setVisibility(0);
        } else {
            this.hrn.setVisibility(8);
        }
    }

    public void vU(int i) {
        ViewGroup.LayoutParams layoutParams = this.hrm.getLayoutParams();
        layoutParams.height = i;
        this.hrm.setLayoutParams(layoutParams);
    }
}
