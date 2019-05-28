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
    private View edE;
    private TextView exX;
    private LinearLayout exY;
    private LinearLayout exZ;
    private LinearLayout eya;
    private LinearLayout eyb;
    private TextView eyc;
    private TextView eyd;
    private TextView eye;
    private TextView eyf;
    private View eyg;
    private View eyh;
    private View eyi;
    private View eyj;
    private com.baidu.tieba.card.data.n eyk;
    private String eyl;
    private String eyn;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.bBh = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.exX = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.exY = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.exZ = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.eya = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.eyb = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.eyc = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.eyd = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.eye = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.eyf = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.eyg = view.findViewById(R.id.home_top_div);
        this.eyh = view.findViewById(R.id.home_top_topic_div_one);
        this.eyi = view.findViewById(R.id.home_top_topic_div_two);
        this.eyj = view.findViewById(R.id.home_card_top_divider_line);
        this.edE = view.findViewById(R.id.home_card_bottom_divider_line);
        this.exY.setOnClickListener(this);
        this.exZ.setOnClickListener(this);
        this.eya.setOnClickListener(this);
        this.eyb.setOnClickListener(this);
        this.exX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.f(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.eyl = str;
        this.eyn = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int f = com.baidu.adp.lib.g.b.f((String) view.getTag(), -1);
        if (this.eyk != null && com.baidu.tbadk.core.util.v.c(this.eyk.eBx, f) != null) {
            TiebaStatic.log(new am(this.eyn).bT("obj_locate", String.valueOf(this.eyk.locate)).bT("obj_name", this.eyk.eBx.get(f).bHC));
            if (f >= 0 && !com.baidu.tbadk.plugins.b.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.eyk.eBx.get(f).topicId), this.eyk.eBx.get(f).bHC, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, R.color.cp_bg_line_d);
            al.f(this.bBh, R.color.cp_cont_d, 1);
            al.f(this.exX, R.color.cp_cont_d, 1);
            al.f(this.eyc, R.color.cp_cont_b, 1);
            al.f(this.eyd, R.color.cp_cont_b, 1);
            al.f(this.eye, R.color.cp_cont_b, 1);
            al.f(this.eyf, R.color.cp_cont_b, 1);
            al.k(this.eyg, R.color.cp_bg_line_b);
            al.k(this.eyh, R.color.cp_bg_line_b);
            al.k(this.eyi, R.color.cp_bg_line_b);
            al.k(this.eyj, R.color.cp_bg_line_c);
            al.k(this.edE, R.color.cp_bg_line_c);
            al.k(this.exY, R.drawable.card_topic_click_selector);
            al.k(this.exZ, R.drawable.card_topic_click_selector);
            al.k(this.eya, R.drawable.card_topic_click_selector);
            al.k(this.eyb, R.drawable.card_topic_click_selector);
            j(this.eyc, 0);
            j(this.eyd, 1);
            j(this.eye, 2);
            j(this.eyf, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.eBw) || com.baidu.tbadk.core.util.v.Z(nVar.eBx) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eyk = nVar;
        this.eyj.setVisibility(this.eyk.eBu ? 0 : 8);
        showBottomLine(this.eyk.eBv);
        this.bBh.setText(this.eyk.eBw.trim());
        i(this.eyc, 0);
        i(this.eyd, 1);
        i(this.eye, 2);
        i(this.eyf, 3);
        j(this.eyc, 0);
        j(this.eyd, 1);
        j(this.eye, 2);
        j(this.eyf, 3);
    }

    private void i(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.eyk.eBx.get(i);
        if (!StringUtils.isNull(mVar.bHC)) {
            textView.setText(mVar.bHC.trim());
        }
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.eyk != null && com.baidu.tbadk.core.util.v.Z(this.eyk.eBx) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.c(this.eyk.eBx, i)) != null) {
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
            this.edE.setVisibility(0);
        } else {
            this.edE.setVisibility(8);
        }
    }

    public void pp(int i) {
        ViewGroup.LayoutParams layoutParams = this.eyj.getLayoutParams();
        layoutParams.height = i;
        this.eyj.setLayoutParams(layoutParams);
    }
}
