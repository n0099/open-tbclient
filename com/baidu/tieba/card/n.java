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
    private TextView cLd;
    private TextView fKS;
    private LinearLayout fKT;
    private LinearLayout fKU;
    private LinearLayout fKV;
    private LinearLayout fKW;
    private TextView fKX;
    private TextView fKY;
    private TextView fKZ;
    private TextView fLa;
    private View fLb;
    private View fLc;
    private View fLd;
    private View fLe;
    private View fLf;
    private com.baidu.tieba.card.data.n fLg;
    private String fLh;
    private String fLi;
    private View mRootView;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.cLd = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.fKS = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.fKT = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.fKU = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.fKV = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.fKW = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.fKX = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.fKY = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.fKZ = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.fLa = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.fLb = view.findViewById(R.id.home_top_div);
        this.fLc = view.findViewById(R.id.home_top_topic_div_one);
        this.fLd = view.findViewById(R.id.home_top_topic_div_two);
        this.fLe = view.findViewById(R.id.home_card_top_divider_line);
        this.fLf = view.findViewById(R.id.home_card_bottom_divider_line);
        this.fKT.setOnClickListener(this);
        this.fKU.setOnClickListener(this);
        this.fKV.setOnClickListener(this);
        this.fKW.setOnClickListener(this);
        this.fKS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.h(n.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(n.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", SchemeCollecter.CLASSIFY_ALL)));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.fLh = str;
        this.fLi = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.fLg != null && com.baidu.tbadk.core.util.v.getItem(this.fLg.fOv, i) != null) {
            TiebaStatic.log(new an(this.fLi).cx("obj_locate", String.valueOf(this.fLg.locate)).cx("obj_name", this.fLg.fOv.get(i).cQP));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.h(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.fLg.fOv.get(i).topicId), this.fLg.fOv.get(i).cQP, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.cLd, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fKS, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fKX, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fKY, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fKZ, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fLa, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.fLb, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fLc, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fLd, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fLe, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fLf, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.fKT, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fKU, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fKV, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.fKW, R.drawable.card_topic_click_selector);
            d(this.fKX, 0);
            d(this.fKY, 1);
            d(this.fKZ, 2);
            d(this.fLa, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.fOu) || com.baidu.tbadk.core.util.v.getCount(nVar.fOv) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.fLg = nVar;
        this.fLe.setVisibility(this.fLg.fOs ? 0 : 8);
        showBottomLine(this.fLg.fOt);
        this.cLd.setText(this.fLg.fOu.trim());
        c(this.fKX, 0);
        c(this.fKY, 1);
        c(this.fKZ, 2);
        c(this.fLa, 3);
        d(this.fKX, 0);
        d(this.fKY, 1);
        d(this.fKZ, 2);
        d(this.fLa, 3);
    }

    private void c(TextView textView, int i) {
        m mVar = this.fLg.fOv.get(i);
        if (!StringUtils.isNull(mVar.cQP)) {
            textView.setText(mVar.cQP.trim());
        }
    }

    private void d(TextView textView, int i) {
        m mVar;
        if (this.fLg != null && com.baidu.tbadk.core.util.v.getCount(this.fLg.fOv) >= 4 && (mVar = (m) com.baidu.tbadk.core.util.v.getItem(this.fLg.fOv, i)) != null) {
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
            this.fLf.setVisibility(0);
        } else {
            this.fLf.setVisibility(8);
        }
    }

    public void rs(int i) {
        ViewGroup.LayoutParams layoutParams = this.fLe.getLayoutParams();
        layoutParams.height = i;
        this.fLe.setLayoutParams(layoutParams);
    }
}
