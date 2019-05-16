package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class p extends a<com.baidu.tieba.card.data.n> {
    private TextView bBh;
    private View edD;
    private TextView exW;
    private LinearLayout exX;
    private LinearLayout exY;
    private LinearLayout exZ;
    private LinearLayout eya;
    private TextView eyb;
    private TextView eyc;
    private TextView eyd;
    private TextView eye;
    private View eyf;
    private View eyg;
    private View eyh;
    private View eyi;
    private com.baidu.tieba.card.data.n eyj;
    private String eyk;
    private String eyl;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.bBh = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.exW = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.exX = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.exY = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.exZ = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.eya = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.eyb = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.eyc = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.eyd = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.eye = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.eyf = view.findViewById(R.id.home_top_div);
        this.eyg = view.findViewById(R.id.home_top_topic_div_one);
        this.eyh = view.findViewById(R.id.home_top_topic_div_two);
        this.eyi = view.findViewById(R.id.home_card_top_divider_line);
        this.edD = view.findViewById(R.id.home_card_bottom_divider_line);
        this.exX.setOnClickListener(this);
        this.exY.setOnClickListener(this);
        this.exZ.setOnClickListener(this);
        this.eya.setOnClickListener(this);
        this.exW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.f(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.eyk = str;
        this.eyl = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int f = com.baidu.adp.lib.g.b.f((String) view.getTag(), -1);
        if (this.eyj != null && com.baidu.tbadk.core.util.v.c(this.eyj.eBw, f) != null) {
            TiebaStatic.log(new am(this.eyl).bT("obj_locate", String.valueOf(this.eyj.locate)).bT("obj_name", this.eyj.eBw.get(f).bHC));
            if (f >= 0 && !com.baidu.tbadk.plugins.b.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.eyj.eBw.get(f).topicId), this.eyj.eBw.get(f).bHC, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, R.color.cp_bg_line_d);
            al.f(this.bBh, R.color.cp_cont_d, 1);
            al.f(this.exW, R.color.cp_cont_d, 1);
            al.f(this.eyb, R.color.cp_cont_b, 1);
            al.f(this.eyc, R.color.cp_cont_b, 1);
            al.f(this.eyd, R.color.cp_cont_b, 1);
            al.f(this.eye, R.color.cp_cont_b, 1);
            al.k(this.eyf, R.color.cp_bg_line_b);
            al.k(this.eyg, R.color.cp_bg_line_b);
            al.k(this.eyh, R.color.cp_bg_line_b);
            al.k(this.eyi, R.color.cp_bg_line_c);
            al.k(this.edD, R.color.cp_bg_line_c);
            al.k(this.exX, R.drawable.card_topic_click_selector);
            al.k(this.exY, R.drawable.card_topic_click_selector);
            al.k(this.exZ, R.drawable.card_topic_click_selector);
            al.k(this.eya, R.drawable.card_topic_click_selector);
            j(this.eyb, 0);
            j(this.eyc, 1);
            j(this.eyd, 2);
            j(this.eye, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.eBv) || com.baidu.tbadk.core.util.v.Z(nVar.eBw) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eyj = nVar;
        this.eyi.setVisibility(this.eyj.eBt ? 0 : 8);
        showBottomLine(this.eyj.eBu);
        this.bBh.setText(this.eyj.eBv.trim());
        i(this.eyb, 0);
        i(this.eyc, 1);
        i(this.eyd, 2);
        i(this.eye, 3);
        j(this.eyb, 0);
        j(this.eyc, 1);
        j(this.eyd, 2);
        j(this.eye, 3);
    }

    private void i(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.eyj.eBw.get(i);
        if (!StringUtils.isNull(mVar.bHC)) {
            textView.setText(mVar.bHC.trim());
        }
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.eyj != null && com.baidu.tbadk.core.util.v.Z(this.eyj.eBw) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.c(this.eyj.eBw, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.edD.setVisibility(0);
        } else {
            this.edD.setVisibility(8);
        }
    }

    public void pp(int i) {
        ViewGroup.LayoutParams layoutParams = this.eyi.getLayoutParams();
        layoutParams.height = i;
        this.eyi.setLayoutParams(layoutParams);
    }
}
