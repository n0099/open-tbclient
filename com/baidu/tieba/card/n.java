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
    private TextView cKR;
    private TextView fJX;
    private LinearLayout fJY;
    private LinearLayout fJZ;
    private LinearLayout fKa;
    private LinearLayout fKb;
    private TextView fKc;
    private TextView fKd;
    private TextView fKe;
    private TextView fKf;
    private View fKg;
    private View fKh;
    private View fKi;
    private View fKj;
    private View fKk;
    private com.baidu.tieba.card.data.n fKl;
    private String fKm;
    private String fKn;
    private View mRootView;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.cKR = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.fJX = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.fJY = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.fJZ = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.fKa = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.fKb = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.fKc = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.fKd = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.fKe = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.fKf = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.fKg = view.findViewById(R.id.home_top_div);
        this.fKh = view.findViewById(R.id.home_top_topic_div_one);
        this.fKi = view.findViewById(R.id.home_top_topic_div_two);
        this.fKj = view.findViewById(R.id.home_card_top_divider_line);
        this.fKk = view.findViewById(R.id.home_card_bottom_divider_line);
        this.fJY.setOnClickListener(this);
        this.fJZ.setOnClickListener(this);
        this.fKa.setOnClickListener(this);
        this.fKb.setOnClickListener(this);
        this.fJX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.h(n.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(n.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", SchemeCollecter.CLASSIFY_ALL)));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.fKm = str;
        this.fKn = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.fKl != null && com.baidu.tbadk.core.util.v.getItem(this.fKl.fNA, i) != null) {
            TiebaStatic.log(new an(this.fKn).cy("obj_locate", String.valueOf(this.fKl.locate)).cy("obj_name", this.fKl.fNA.get(i).cQB));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.h(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.fKl.fNA.get(i).topicId), this.fKl.fNA.get(i).cQB, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.cKR, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fJX, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fKc, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fKd, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fKe, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fKf, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.fKg, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKh, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKi, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKj, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKk, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fJY, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fJZ, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fKa, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fKb, R.drawable.card_topic_click_selector);
            d(this.fKc, 0);
            d(this.fKd, 1);
            d(this.fKe, 2);
            d(this.fKf, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.fNz) || com.baidu.tbadk.core.util.v.getCount(nVar.fNA) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.fKl = nVar;
        this.fKj.setVisibility(this.fKl.fNx ? 0 : 8);
        showBottomLine(this.fKl.fNy);
        this.cKR.setText(this.fKl.fNz.trim());
        c(this.fKc, 0);
        c(this.fKd, 1);
        c(this.fKe, 2);
        c(this.fKf, 3);
        d(this.fKc, 0);
        d(this.fKd, 1);
        d(this.fKe, 2);
        d(this.fKf, 3);
    }

    private void c(TextView textView, int i) {
        m mVar = this.fKl.fNA.get(i);
        if (!StringUtils.isNull(mVar.cQB)) {
            textView.setText(mVar.cQB.trim());
        }
    }

    private void d(TextView textView, int i) {
        m mVar;
        if (this.fKl != null && com.baidu.tbadk.core.util.v.getCount(this.fKl.fNA) >= 4 && (mVar = (m) com.baidu.tbadk.core.util.v.getItem(this.fKl.fNA, i)) != null) {
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
            this.fKk.setVisibility(0);
        } else {
            this.fKk.setVisibility(8);
        }
    }

    public void rq(int i) {
        ViewGroup.LayoutParams layoutParams = this.fKj.getLayoutParams();
        layoutParams.height = i;
        this.fKj.setLayoutParams(layoutParams);
    }
}
