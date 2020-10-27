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
/* loaded from: classes22.dex */
public class p extends b<com.baidu.tieba.card.data.o> {
    private TextView epn;
    private View hSA;
    private View hSB;
    private View hSC;
    private View hSD;
    private View hSE;
    private com.baidu.tieba.card.data.o hSF;
    private String hSG;
    private String hSH;
    private TextView hSr;
    private LinearLayout hSs;
    private LinearLayout hSt;
    private LinearLayout hSu;
    private LinearLayout hSv;
    private TextView hSw;
    private TextView hSx;
    private TextView hSy;
    private TextView hSz;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.epn = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.hSr = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.hSs = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.hSt = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.hSu = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.hSv = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.hSw = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.hSx = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.hSy = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.hSz = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.hSA = view.findViewById(R.id.home_top_div);
        this.hSB = view.findViewById(R.id.home_top_topic_div_one);
        this.hSC = view.findViewById(R.id.home_top_topic_div_two);
        this.hSD = view.findViewById(R.id.home_card_top_divider_line);
        this.hSE = view.findViewById(R.id.home_card_bottom_divider_line);
        this.hSs.setOnClickListener(this);
        this.hSt.setOnClickListener(this);
        this.hSu.setOnClickListener(this);
        this.hSv.setOnClickListener(this);
        this.hSr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.hSG = str;
        this.hSH = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.hSF != null && com.baidu.tbadk.core.util.y.getItem(this.hSF.hVZ, i) != null) {
            TiebaStatic.log(new aq(this.hSH).dR("obj_locate", String.valueOf(this.hSF.locate)).dR("obj_name", this.hSF.hVZ.get(i).ewR));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.hSF.hVZ.get(i).topicId), this.hSF.hVZ.get(i).ewR, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.epn, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hSr, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hSw, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hSx, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hSy, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hSz, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(this.hSA, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hSB, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hSC, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hSD, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hSE, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hSs, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hSt, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hSu, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hSv, R.drawable.card_topic_click_selector);
            e(this.hSw, 0);
            e(this.hSx, 1);
            e(this.hSy, 2);
            e(this.hSz, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || StringUtils.isNull(oVar.hVY) || com.baidu.tbadk.core.util.y.getCount(oVar.hVZ) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.hSF = oVar;
        this.hSD.setVisibility(this.hSF.hVW ? 0 : 8);
        showBottomLine(this.hSF.hVX);
        this.epn.setText(this.hSF.hVY.trim());
        d(this.hSw, 0);
        d(this.hSx, 1);
        d(this.hSy, 2);
        d(this.hSz, 3);
        e(this.hSw, 0);
        e(this.hSx, 1);
        e(this.hSy, 2);
        e(this.hSz, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar = this.hSF.hVZ.get(i);
        if (!StringUtils.isNull(nVar.ewR)) {
            textView.setText(nVar.ewR.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar;
        if (this.hSF != null && com.baidu.tbadk.core.util.y.getCount(this.hSF.hVZ) >= 4 && (nVar = (com.baidu.tieba.card.data.n) com.baidu.tbadk.core.util.y.getItem(this.hSF.hVZ, i)) != null) {
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
            this.hSE.setVisibility(0);
        } else {
            this.hSE.setVisibility(8);
        }
    }

    public void wT(int i) {
        ViewGroup.LayoutParams layoutParams = this.hSD.getLayoutParams();
        layoutParams.height = i;
        this.hSD.setLayoutParams(layoutParams);
    }
}
