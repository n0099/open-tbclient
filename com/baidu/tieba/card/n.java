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
    private TextView cKQ;
    private TextView fJV;
    private LinearLayout fJW;
    private LinearLayout fJX;
    private LinearLayout fJY;
    private LinearLayout fJZ;
    private TextView fKa;
    private TextView fKb;
    private TextView fKc;
    private TextView fKd;
    private View fKe;
    private View fKf;
    private View fKg;
    private View fKh;
    private View fKi;
    private com.baidu.tieba.card.data.n fKj;
    private String fKk;
    private String fKl;
    private View mRootView;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.cKQ = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.fJV = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.fJW = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.fJX = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.fJY = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.fJZ = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.fKa = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.fKb = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.fKc = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.fKd = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.fKe = view.findViewById(R.id.home_top_div);
        this.fKf = view.findViewById(R.id.home_top_topic_div_one);
        this.fKg = view.findViewById(R.id.home_top_topic_div_two);
        this.fKh = view.findViewById(R.id.home_card_top_divider_line);
        this.fKi = view.findViewById(R.id.home_card_bottom_divider_line);
        this.fJW.setOnClickListener(this);
        this.fJX.setOnClickListener(this);
        this.fJY.setOnClickListener(this);
        this.fJZ.setOnClickListener(this);
        this.fJV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.h(n.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(n.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", SchemeCollecter.CLASSIFY_ALL)));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.fKk = str;
        this.fKl = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.fKj != null && com.baidu.tbadk.core.util.v.getItem(this.fKj.fNy, i) != null) {
            TiebaStatic.log(new an(this.fKl).cy("obj_locate", String.valueOf(this.fKj.locate)).cy("obj_name", this.fKj.fNy.get(i).cQA));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.h(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.fKj.fNy.get(i).topicId), this.fKj.fNy.get(i).cQA, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.cKQ, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fJV, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fKa, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fKb, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fKc, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fKd, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.fKe, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKf, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKg, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKh, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKi, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fJW, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fJX, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fJY, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fJZ, R.drawable.card_topic_click_selector);
            d(this.fKa, 0);
            d(this.fKb, 1);
            d(this.fKc, 2);
            d(this.fKd, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.fNx) || com.baidu.tbadk.core.util.v.getCount(nVar.fNy) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.fKj = nVar;
        this.fKh.setVisibility(this.fKj.fNv ? 0 : 8);
        showBottomLine(this.fKj.fNw);
        this.cKQ.setText(this.fKj.fNx.trim());
        c(this.fKa, 0);
        c(this.fKb, 1);
        c(this.fKc, 2);
        c(this.fKd, 3);
        d(this.fKa, 0);
        d(this.fKb, 1);
        d(this.fKc, 2);
        d(this.fKd, 3);
    }

    private void c(TextView textView, int i) {
        m mVar = this.fKj.fNy.get(i);
        if (!StringUtils.isNull(mVar.cQA)) {
            textView.setText(mVar.cQA.trim());
        }
    }

    private void d(TextView textView, int i) {
        m mVar;
        if (this.fKj != null && com.baidu.tbadk.core.util.v.getCount(this.fKj.fNy) >= 4 && (mVar = (m) com.baidu.tbadk.core.util.v.getItem(this.fKj.fNy, i)) != null) {
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
            this.fKi.setVisibility(0);
        } else {
            this.fKi.setVisibility(8);
        }
    }

    public void rq(int i) {
        ViewGroup.LayoutParams layoutParams = this.fKh.getLayoutParams();
        layoutParams.height = i;
        this.fKh.setLayoutParams(layoutParams);
    }
}
