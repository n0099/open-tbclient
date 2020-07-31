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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class o extends b<com.baidu.tieba.card.data.n> {
    private TextView dJr;
    private TextView gXa;
    private LinearLayout gXb;
    private LinearLayout gXc;
    private LinearLayout gXd;
    private LinearLayout gXe;
    private TextView gXf;
    private TextView gXg;
    private TextView gXh;
    private TextView gXi;
    private View gXj;
    private View gXk;
    private View gXl;
    private View gXm;
    private View gXn;
    private com.baidu.tieba.card.data.n gXo;
    private String gXp;
    private String gXq;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.dJr = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.gXa = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.gXb = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.gXc = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.gXd = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.gXe = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.gXf = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.gXg = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.gXh = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.gXi = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.gXj = view.findViewById(R.id.home_top_div);
        this.gXk = view.findViewById(R.id.home_top_topic_div_one);
        this.gXl = view.findViewById(R.id.home_top_topic_div_two);
        this.gXm = view.findViewById(R.id.home_card_top_divider_line);
        this.gXn = view.findViewById(R.id.home_card_bottom_divider_line);
        this.gXb.setOnClickListener(this);
        this.gXc.setOnClickListener(this);
        this.gXd.setOnClickListener(this);
        this.gXe.setOnClickListener(this);
        this.gXa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", SchemeCollecter.CLASSIFY_ALL)));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.gXp = str;
        this.gXq = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.gXo != null && com.baidu.tbadk.core.util.x.getItem(this.gXo.haI, i) != null) {
            TiebaStatic.log(new ap(this.gXq).dn("obj_locate", String.valueOf(this.gXo.locate)).dn("obj_name", this.gXo.haI.get(i).dQI));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.gXo.haI.get(i).topicId), this.gXo.haI.get(i).dQI, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ao.setViewTextColor(this.dJr, R.color.cp_cont_d, 1);
            ao.setViewTextColor(this.gXa, R.color.cp_cont_d, 1);
            ao.setViewTextColor(this.gXf, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.gXg, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.gXh, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.gXi, R.color.cp_cont_b, 1);
            ao.setBackgroundResource(this.gXj, R.color.cp_bg_line_c);
            ao.setBackgroundResource(this.gXk, R.color.cp_bg_line_c);
            ao.setBackgroundResource(this.gXl, R.color.cp_bg_line_c);
            ao.setBackgroundResource(this.gXm, R.color.cp_bg_line_c);
            ao.setBackgroundResource(this.gXn, R.color.cp_bg_line_c);
            ao.setBackgroundResource(this.gXb, R.drawable.card_topic_click_selector);
            ao.setBackgroundResource(this.gXc, R.drawable.card_topic_click_selector);
            ao.setBackgroundResource(this.gXd, R.drawable.card_topic_click_selector);
            ao.setBackgroundResource(this.gXe, R.drawable.card_topic_click_selector);
            e(this.gXf, 0);
            e(this.gXg, 1);
            e(this.gXh, 2);
            e(this.gXi, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.haH) || com.baidu.tbadk.core.util.x.getCount(nVar.haI) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.gXo = nVar;
        this.gXm.setVisibility(this.gXo.haF ? 0 : 8);
        showBottomLine(this.gXo.haG);
        this.dJr.setText(this.gXo.haH.trim());
        d(this.gXf, 0);
        d(this.gXg, 1);
        d(this.gXh, 2);
        d(this.gXi, 3);
        e(this.gXf, 0);
        e(this.gXg, 1);
        e(this.gXh, 2);
        e(this.gXi, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.gXo.haI.get(i);
        if (!StringUtils.isNull(mVar.dQI)) {
            textView.setText(mVar.dQI.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.gXo != null && com.baidu.tbadk.core.util.x.getCount(this.gXo.haI) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.x.getItem(this.gXo.haI, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.gXn.setVisibility(0);
        } else {
            this.gXn.setVisibility(8);
        }
    }

    public void tg(int i) {
        ViewGroup.LayoutParams layoutParams = this.gXm.getLayoutParams();
        layoutParams.height = i;
        this.gXm.setLayoutParams(layoutParams);
    }
}
