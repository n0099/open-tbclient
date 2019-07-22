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
    private TextView eCV;
    private LinearLayout eCW;
    private LinearLayout eCX;
    private LinearLayout eCY;
    private LinearLayout eCZ;
    private TextView eDa;
    private TextView eDb;
    private TextView eDc;
    private TextView eDd;
    private View eDe;
    private View eDf;
    private View eDg;
    private View eDh;
    private com.baidu.tieba.card.data.n eDi;
    private String eDj;
    private String eDk;
    private View eig;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.bCd = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.eCV = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.eCW = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.eCX = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.eCY = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.eCZ = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.eDa = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.eDb = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.eDc = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.eDd = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.eDe = view.findViewById(R.id.home_top_div);
        this.eDf = view.findViewById(R.id.home_top_topic_div_one);
        this.eDg = view.findViewById(R.id.home_top_topic_div_two);
        this.eDh = view.findViewById(R.id.home_card_top_divider_line);
        this.eig = view.findViewById(R.id.home_card_bottom_divider_line);
        this.eCW.setOnClickListener(this);
        this.eCX.setOnClickListener(this);
        this.eCY.setOnClickListener(this);
        this.eCZ.setOnClickListener(this);
        this.eCV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.f(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.eDj = str;
        this.eDk = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int f = com.baidu.adp.lib.g.b.f((String) view.getTag(), -1);
        if (this.eDi != null && com.baidu.tbadk.core.util.v.c(this.eDi.eGt, f) != null) {
            TiebaStatic.log(new an(this.eDk).bT("obj_locate", String.valueOf(this.eDi.locate)).bT("obj_name", this.eDi.eGt.get(f).bID));
            if (f >= 0 && !com.baidu.tbadk.plugins.b.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.eDi.eGt.get(f).topicId), this.eDi.eGt.get(f).bID, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(this.mRootView, R.color.cp_bg_line_d);
            am.f(this.bCd, R.color.cp_cont_d, 1);
            am.f(this.eCV, R.color.cp_cont_d, 1);
            am.f(this.eDa, R.color.cp_cont_b, 1);
            am.f(this.eDb, R.color.cp_cont_b, 1);
            am.f(this.eDc, R.color.cp_cont_b, 1);
            am.f(this.eDd, R.color.cp_cont_b, 1);
            am.k(this.eDe, R.color.cp_bg_line_b);
            am.k(this.eDf, R.color.cp_bg_line_b);
            am.k(this.eDg, R.color.cp_bg_line_b);
            am.k(this.eDh, R.color.cp_bg_line_c);
            am.k(this.eig, R.color.cp_bg_line_c);
            am.k(this.eCW, R.drawable.card_topic_click_selector);
            am.k(this.eCX, R.drawable.card_topic_click_selector);
            am.k(this.eCY, R.drawable.card_topic_click_selector);
            am.k(this.eCZ, R.drawable.card_topic_click_selector);
            j(this.eDa, 0);
            j(this.eDb, 1);
            j(this.eDc, 2);
            j(this.eDd, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.eGs) || com.baidu.tbadk.core.util.v.Z(nVar.eGt) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eDi = nVar;
        this.eDh.setVisibility(this.eDi.eGq ? 0 : 8);
        showBottomLine(this.eDi.eGr);
        this.bCd.setText(this.eDi.eGs.trim());
        i(this.eDa, 0);
        i(this.eDb, 1);
        i(this.eDc, 2);
        i(this.eDd, 3);
        j(this.eDa, 0);
        j(this.eDb, 1);
        j(this.eDc, 2);
        j(this.eDd, 3);
    }

    private void i(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.eDi.eGt.get(i);
        if (!StringUtils.isNull(mVar.bID)) {
            textView.setText(mVar.bID.trim());
        }
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.eDi != null && com.baidu.tbadk.core.util.v.Z(this.eDi.eGt) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.c(this.eDi.eGt, i)) != null) {
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
            this.eig.setVisibility(0);
        } else {
            this.eig.setVisibility(8);
        }
    }

    public void pF(int i) {
        ViewGroup.LayoutParams layoutParams = this.eDh.getLayoutParams();
        layoutParams.height = i;
        this.eDh.setLayoutParams(layoutParams);
    }
}
