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
    private TextView dSz;
    private TextView hjT;
    private LinearLayout hjU;
    private LinearLayout hjV;
    private LinearLayout hjW;
    private LinearLayout hjX;
    private TextView hjY;
    private TextView hjZ;
    private TextView hka;
    private TextView hkb;
    private View hkc;
    private View hkd;
    private View hke;
    private View hkf;
    private View hkg;
    private com.baidu.tieba.card.data.o hkh;
    private String hki;
    private String hkj;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.dSz = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.hjT = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.hjU = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.hjV = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.hjW = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.hjX = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.hjY = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.hjZ = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.hka = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.hkb = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.hkc = view.findViewById(R.id.home_top_div);
        this.hkd = view.findViewById(R.id.home_top_topic_div_one);
        this.hke = view.findViewById(R.id.home_top_topic_div_two);
        this.hkf = view.findViewById(R.id.home_card_top_divider_line);
        this.hkg = view.findViewById(R.id.home_card_bottom_divider_line);
        this.hjU.setOnClickListener(this);
        this.hjV.setOnClickListener(this);
        this.hjW.setOnClickListener(this);
        this.hjX.setOnClickListener(this);
        this.hjT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.hki = str;
        this.hkj = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.hkh != null && com.baidu.tbadk.core.util.y.getItem(this.hkh.hnz, i) != null) {
            TiebaStatic.log(new aq(this.hkj).dD("obj_locate", String.valueOf(this.hkh.locate)).dD("obj_name", this.hkh.hnz.get(i).eab));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.hkh.hnz.get(i).topicId), this.hkh.hnz.get(i).eab, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.dSz, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hjT, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hjY, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hjZ, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hka, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hkb, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(this.hkc, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hkd, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hke, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hkf, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hkg, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hjU, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hjV, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hjW, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hjX, R.drawable.card_topic_click_selector);
            e(this.hjY, 0);
            e(this.hjZ, 1);
            e(this.hka, 2);
            e(this.hkb, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || StringUtils.isNull(oVar.hny) || com.baidu.tbadk.core.util.y.getCount(oVar.hnz) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.hkh = oVar;
        this.hkf.setVisibility(this.hkh.hnw ? 0 : 8);
        showBottomLine(this.hkh.hnx);
        this.dSz.setText(this.hkh.hny.trim());
        d(this.hjY, 0);
        d(this.hjZ, 1);
        d(this.hka, 2);
        d(this.hkb, 3);
        e(this.hjY, 0);
        e(this.hjZ, 1);
        e(this.hka, 2);
        e(this.hkb, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar = this.hkh.hnz.get(i);
        if (!StringUtils.isNull(nVar.eab)) {
            textView.setText(nVar.eab.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar;
        if (this.hkh != null && com.baidu.tbadk.core.util.y.getCount(this.hkh.hnz) >= 4 && (nVar = (com.baidu.tieba.card.data.n) com.baidu.tbadk.core.util.y.getItem(this.hkh.hnz, i)) != null) {
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
            this.hkg.setVisibility(0);
        } else {
            this.hkg.setVisibility(8);
        }
    }

    public void vv(int i) {
        ViewGroup.LayoutParams layoutParams = this.hkf.getLayoutParams();
        layoutParams.height = i;
        this.hkf.setLayoutParams(layoutParams);
    }
}
