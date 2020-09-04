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
/* loaded from: classes16.dex */
public class o extends b<com.baidu.tieba.card.data.o> {
    private TextView dSD;
    private TextView hjX;
    private LinearLayout hjY;
    private LinearLayout hjZ;
    private LinearLayout hka;
    private LinearLayout hkb;
    private TextView hkc;
    private TextView hkd;
    private TextView hke;
    private TextView hkf;
    private View hkg;
    private View hkh;
    private View hki;
    private View hkj;
    private View hkk;
    private com.baidu.tieba.card.data.o hkl;
    private String hkm;
    private String hkn;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.dSD = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.hjX = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.hjY = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.hjZ = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.hka = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.hkb = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.hkc = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.hkd = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.hke = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.hkf = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.hkg = view.findViewById(R.id.home_top_div);
        this.hkh = view.findViewById(R.id.home_top_topic_div_one);
        this.hki = view.findViewById(R.id.home_top_topic_div_two);
        this.hkj = view.findViewById(R.id.home_card_top_divider_line);
        this.hkk = view.findViewById(R.id.home_card_bottom_divider_line);
        this.hjY.setOnClickListener(this);
        this.hjZ.setOnClickListener(this);
        this.hka.setOnClickListener(this);
        this.hkb.setOnClickListener(this);
        this.hjX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.hkm = str;
        this.hkn = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.hkl != null && com.baidu.tbadk.core.util.y.getItem(this.hkl.hnD, i) != null) {
            TiebaStatic.log(new aq(this.hkn).dD("obj_locate", String.valueOf(this.hkl.locate)).dD("obj_name", this.hkl.hnD.get(i).eaf));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.hkl.hnD.get(i).topicId), this.hkl.hnD.get(i).eaf, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.dSD, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hjX, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hkc, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hkd, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hke, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hkf, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(this.hkg, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hkh, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hki, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hkj, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hkk, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hjY, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hjZ, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hka, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hkb, R.drawable.card_topic_click_selector);
            e(this.hkc, 0);
            e(this.hkd, 1);
            e(this.hke, 2);
            e(this.hkf, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || StringUtils.isNull(oVar.hnC) || com.baidu.tbadk.core.util.y.getCount(oVar.hnD) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.hkl = oVar;
        this.hkj.setVisibility(this.hkl.hnA ? 0 : 8);
        showBottomLine(this.hkl.hnB);
        this.dSD.setText(this.hkl.hnC.trim());
        d(this.hkc, 0);
        d(this.hkd, 1);
        d(this.hke, 2);
        d(this.hkf, 3);
        e(this.hkc, 0);
        e(this.hkd, 1);
        e(this.hke, 2);
        e(this.hkf, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar = this.hkl.hnD.get(i);
        if (!StringUtils.isNull(nVar.eaf)) {
            textView.setText(nVar.eaf.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar;
        if (this.hkl != null && com.baidu.tbadk.core.util.y.getCount(this.hkl.hnD) >= 4 && (nVar = (com.baidu.tieba.card.data.n) com.baidu.tbadk.core.util.y.getItem(this.hkl.hnD, i)) != null) {
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
            this.hkk.setVisibility(0);
        } else {
            this.hkk.setVisibility(8);
        }
    }

    public void vv(int i) {
        ViewGroup.LayoutParams layoutParams = this.hkj.getLayoutParams();
        layoutParams.height = i;
        this.hkj.setLayoutParams(layoutParams);
    }
}
