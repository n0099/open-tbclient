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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class p extends a<com.baidu.tieba.card.data.n> {
    private TextView bCd;
    private TextView eDc;
    private LinearLayout eDd;
    private LinearLayout eDe;
    private LinearLayout eDf;
    private LinearLayout eDg;
    private TextView eDh;
    private TextView eDi;
    private TextView eDj;
    private TextView eDk;
    private View eDl;
    private View eDm;
    private View eDn;
    private View eDo;
    private com.baidu.tieba.card.data.n eDp;
    private String eDq;
    private String eDr;
    private View ein;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.bCd = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.eDc = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.eDd = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.eDe = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.eDf = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.eDg = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.eDh = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.eDi = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.eDj = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.eDk = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.eDl = view.findViewById(R.id.home_top_div);
        this.eDm = view.findViewById(R.id.home_top_topic_div_one);
        this.eDn = view.findViewById(R.id.home_top_topic_div_two);
        this.eDo = view.findViewById(R.id.home_card_top_divider_line);
        this.ein = view.findViewById(R.id.home_card_bottom_divider_line);
        this.eDd.setOnClickListener(this);
        this.eDe.setOnClickListener(this);
        this.eDf.setOnClickListener(this);
        this.eDg.setOnClickListener(this);
        this.eDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.f(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.eDq = str;
        this.eDr = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int f = com.baidu.adp.lib.g.b.f((String) view.getTag(), -1);
        if (this.eDp != null && com.baidu.tbadk.core.util.v.c(this.eDp.eGA, f) != null) {
            TiebaStatic.log(new an(this.eDr).bT("obj_locate", String.valueOf(this.eDp.locate)).bT("obj_name", this.eDp.eGA.get(f).bII));
            if (f >= 0 && !com.baidu.tbadk.plugins.b.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.eDp.eGA.get(f).topicId), this.eDp.eGA.get(f).bII, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.mRootView, R.color.cp_bg_line_d);
            am.f(this.bCd, R.color.cp_cont_d, 1);
            am.f(this.eDc, R.color.cp_cont_d, 1);
            am.f(this.eDh, R.color.cp_cont_b, 1);
            am.f(this.eDi, R.color.cp_cont_b, 1);
            am.f(this.eDj, R.color.cp_cont_b, 1);
            am.f(this.eDk, R.color.cp_cont_b, 1);
            am.k(this.eDl, R.color.cp_bg_line_b);
            am.k(this.eDm, R.color.cp_bg_line_b);
            am.k(this.eDn, R.color.cp_bg_line_b);
            am.k(this.eDo, R.color.cp_bg_line_c);
            am.k(this.ein, R.color.cp_bg_line_c);
            am.k(this.eDd, R.drawable.card_topic_click_selector);
            am.k(this.eDe, R.drawable.card_topic_click_selector);
            am.k(this.eDf, R.drawable.card_topic_click_selector);
            am.k(this.eDg, R.drawable.card_topic_click_selector);
            j(this.eDh, 0);
            j(this.eDi, 1);
            j(this.eDj, 2);
            j(this.eDk, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.eGz) || com.baidu.tbadk.core.util.v.Z(nVar.eGA) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eDp = nVar;
        this.eDo.setVisibility(this.eDp.eGx ? 0 : 8);
        showBottomLine(this.eDp.eGy);
        this.bCd.setText(this.eDp.eGz.trim());
        i(this.eDh, 0);
        i(this.eDi, 1);
        i(this.eDj, 2);
        i(this.eDk, 3);
        j(this.eDh, 0);
        j(this.eDi, 1);
        j(this.eDj, 2);
        j(this.eDk, 3);
    }

    private void i(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.eDp.eGA.get(i);
        if (!StringUtils.isNull(mVar.bII)) {
            textView.setText(mVar.bII.trim());
        }
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.eDp != null && com.baidu.tbadk.core.util.v.Z(this.eDp.eGA) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.c(this.eDp.eGA, i)) != null) {
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
            this.ein.setVisibility(0);
        } else {
            this.ein.setVisibility(8);
        }
    }

    public void pG(int i) {
        ViewGroup.LayoutParams layoutParams = this.eDo.getLayoutParams();
        layoutParams.height = i;
        this.eDo.setLayoutParams(layoutParams);
    }
}
