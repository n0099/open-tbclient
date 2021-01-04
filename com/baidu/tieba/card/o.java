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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class o extends b<com.baidu.tieba.card.data.n> {
    private TextView eKc;
    private TextView iwi;
    private LinearLayout iwj;
    private LinearLayout iwk;
    private LinearLayout iwl;
    private LinearLayout iwm;
    private TextView iwn;
    private TextView iwo;
    private TextView iwp;
    private TextView iwq;
    private View iwr;
    private View iws;
    private View iwt;
    private View iwu;
    private View iwv;
    private com.baidu.tieba.card.data.n iww;
    private String iwx;
    private String iwy;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.eKc = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.iwi = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.iwj = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.iwk = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.iwl = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.iwm = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.iwn = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.iwo = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.iwp = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.iwq = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.iwr = view.findViewById(R.id.home_top_div);
        this.iws = view.findViewById(R.id.home_top_topic_div_one);
        this.iwt = view.findViewById(R.id.home_top_topic_div_two);
        this.iwu = view.findViewById(R.id.home_card_top_divider_line);
        this.iwv = view.findViewById(R.id.home_card_bottom_divider_line);
        this.iwj.setOnClickListener(this);
        this.iwk.setOnClickListener(this);
        this.iwl.setOnClickListener(this);
        this.iwm.setOnClickListener(this);
        this.iwi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.iwx = str;
        this.iwy = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.iww != null && com.baidu.tbadk.core.util.x.getItem(this.iww.iAe, i) != null) {
            TiebaStatic.log(new aq(this.iwy).dX("obj_locate", String.valueOf(this.iww.locate)).dX("obj_name", this.iww.iAe.get(i).eRS));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.iww.iAe.get(i).topicId), this.iww.iAe.get(i).eRS, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ao.setViewTextColor(this.eKc, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.iwi, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.iwn, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.iwo, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.iwp, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.iwq, R.color.CAM_X0105, 1);
            ao.setBackgroundResource(this.iwr, R.color.CAM_X0204);
            ao.setBackgroundResource(this.iws, R.color.CAM_X0204);
            ao.setBackgroundResource(this.iwt, R.color.CAM_X0204);
            ao.setBackgroundResource(this.iwu, R.color.CAM_X0204);
            ao.setBackgroundResource(this.iwv, R.color.CAM_X0204);
            ao.setBackgroundResource(this.iwj, R.drawable.card_topic_click_selector);
            ao.setBackgroundResource(this.iwk, R.drawable.card_topic_click_selector);
            ao.setBackgroundResource(this.iwl, R.drawable.card_topic_click_selector);
            ao.setBackgroundResource(this.iwm, R.drawable.card_topic_click_selector);
            e(this.iwn, 0);
            e(this.iwo, 1);
            e(this.iwp, 2);
            e(this.iwq, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.iAd) || com.baidu.tbadk.core.util.x.getCount(nVar.iAe) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.iww = nVar;
        this.iwu.setVisibility(this.iww.iAb ? 0 : 8);
        showBottomLine(this.iww.iAc);
        this.eKc.setText(this.iww.iAd.trim());
        d(this.iwn, 0);
        d(this.iwo, 1);
        d(this.iwp, 2);
        d(this.iwq, 3);
        e(this.iwn, 0);
        e(this.iwo, 1);
        e(this.iwp, 2);
        e(this.iwq, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.iww.iAe.get(i);
        if (!StringUtils.isNull(mVar.eRS)) {
            textView.setText(mVar.eRS.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.iww != null && com.baidu.tbadk.core.util.x.getCount(this.iww.iAe) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.x.getItem(this.iww.iAe, i)) != null) {
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
            this.iwv.setVisibility(0);
        } else {
            this.iwv.setVisibility(8);
        }
    }

    public void yy(int i) {
        ViewGroup.LayoutParams layoutParams = this.iwu.getLayoutParams();
        layoutParams.height = i;
        this.iwu.setLayoutParams(layoutParams);
    }
}
