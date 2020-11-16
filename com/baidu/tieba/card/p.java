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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class p extends b<com.baidu.tieba.card.data.n> {
    private TextView etx;
    private TextView hYO;
    private LinearLayout hYP;
    private LinearLayout hYQ;
    private LinearLayout hYR;
    private LinearLayout hYS;
    private TextView hYT;
    private TextView hYU;
    private TextView hYV;
    private TextView hYW;
    private View hYX;
    private View hYY;
    private View hYZ;
    private View hZa;
    private View hZb;
    private com.baidu.tieba.card.data.n hZc;
    private String hZd;
    private String hZe;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.etx = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.hYO = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.hYP = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.hYQ = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.hYR = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.hYS = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.hYT = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.hYU = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.hYV = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.hYW = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.hYX = view.findViewById(R.id.home_top_div);
        this.hYY = view.findViewById(R.id.home_top_topic_div_one);
        this.hYZ = view.findViewById(R.id.home_top_topic_div_two);
        this.hZa = view.findViewById(R.id.home_card_top_divider_line);
        this.hZb = view.findViewById(R.id.home_card_bottom_divider_line);
        this.hYP.setOnClickListener(this);
        this.hYQ.setOnClickListener(this);
        this.hYR.setOnClickListener(this);
        this.hYS.setOnClickListener(this);
        this.hYO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.hZd = str;
        this.hZe = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.hZc != null && com.baidu.tbadk.core.util.y.getItem(this.hZc.icK, i) != null) {
            TiebaStatic.log(new ar(this.hZe).dR("obj_locate", String.valueOf(this.hZc.locate)).dR("obj_name", this.hZc.icK.get(i).eBa));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.hZc.icK.get(i).topicId), this.hZc.icK.get(i).eBa, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.etx, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.hYO, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.hYT, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.hYU, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.hYV, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.hYW, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(this.hYX, R.color.CAM_X0204);
            ap.setBackgroundResource(this.hYY, R.color.CAM_X0204);
            ap.setBackgroundResource(this.hYZ, R.color.CAM_X0204);
            ap.setBackgroundResource(this.hZa, R.color.CAM_X0204);
            ap.setBackgroundResource(this.hZb, R.color.CAM_X0204);
            ap.setBackgroundResource(this.hYP, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hYQ, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hYR, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hYS, R.drawable.card_topic_click_selector);
            e(this.hYT, 0);
            e(this.hYU, 1);
            e(this.hYV, 2);
            e(this.hYW, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.icJ) || com.baidu.tbadk.core.util.y.getCount(nVar.icK) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.hZc = nVar;
        this.hZa.setVisibility(this.hZc.icH ? 0 : 8);
        showBottomLine(this.hZc.icI);
        this.etx.setText(this.hZc.icJ.trim());
        d(this.hYT, 0);
        d(this.hYU, 1);
        d(this.hYV, 2);
        d(this.hYW, 3);
        e(this.hYT, 0);
        e(this.hYU, 1);
        e(this.hYV, 2);
        e(this.hYW, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.hZc.icK.get(i);
        if (!StringUtils.isNull(mVar.eBa)) {
            textView.setText(mVar.eBa.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.hZc != null && com.baidu.tbadk.core.util.y.getCount(this.hZc.icK) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.y.getItem(this.hZc.icK, i)) != null) {
            switch (mVar.tag) {
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
            this.hZb.setVisibility(0);
        } else {
            this.hZb.setVisibility(8);
        }
    }

    public void xE(int i) {
        ViewGroup.LayoutParams layoutParams = this.hZa.getLayoutParams();
        layoutParams.height = i;
        this.hZa.setLayoutParams(layoutParams);
    }
}
